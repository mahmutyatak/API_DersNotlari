package test;

import baseUrl.Herokuapp_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.HerokuappTestDatalari;

import static io.restassured.RestAssured.given;

public class C21_Post_TestDataKullanimi extends Herokuapp_BaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
Response Body
{
"bookingid": 24,
"booking": {
"firstname": "Ahmet",
"lastname": "Bulut",
"totalprice": 500,
"depositpaid": false,
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
},
"additionalneeds": "wi-fi"
}
}
Request body
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}

     */
    @Test
    public void test01(){
        HerokuappTestDatalari herokuappTestDatalari=new HerokuappTestDatalari();
        spaceHerokuappPlace.pathParams("pp1","booking");
        JSONObject requestJason=herokuappTestDatalari.postHerokuappRequestJason();

        Response response=given().spec(spaceHerokuappPlace).contentType(ContentType.JSON)
                .when().body(requestJason.toString()).post("/{pp1}");

        response.prettyPrint();

        JSONObject expectedJason=new JSONObject();
        expectedJason.put("bookingid", 6197);
        expectedJason.put("booking",requestJason);
        JsonPath actualJason=response.jsonPath();

        Assert.assertEquals(expectedJason.getJSONObject("booking").get("firstname"),actualJason.get("booking.firstname"));
        Assert.assertEquals(expectedJason.getJSONObject("booking").get("lastname"),actualJason.get("booking.lastname"));
        Assert.assertEquals(expectedJason.getJSONObject("booking").get("totalprice"),actualJason.get("booking.totalprice"));
        Assert.assertEquals(expectedJason.getJSONObject("booking").get("depositpaid"),actualJason.get("booking.depositpaid"));
        Assert.assertEquals(expectedJason.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),actualJason.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedJason.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),actualJason.get("booking.bookingdates.checkout"));
        Assert.assertEquals(expectedJason.getJSONObject("booking").get("additionalneeds"),actualJason.get("booking.additionalneeds"));

        //status kodu assert ile
        Assert.assertEquals(herokuappTestDatalari.basariliStatusKodu,response.getStatusCode());

    }
}
