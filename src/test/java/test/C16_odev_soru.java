package test;

import baseUrl.Herokuapp_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C16_odev_soru extends Herokuapp_BaseUrl {
    /*
    C16_BaseUrlHerokuapp
Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve
Response’ta 12 booking oldugunu test edin

2- https://restful-booker.herokuapp.com/booking
endpointine asagidaki body’ye sahip bir POST
request gonderdigimizde donen response’un
status code’unun 200 oldugunu ve “firstname”
degerinin “Ahmet” oldugunu test edin
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
        /*
        1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve
Response’ta 12 booking oldugunu test edin
         */

        spaceHerokuappPlace.pathParam("pp1","booking");
        Response response=given().spec(spaceHerokuappPlace).when().get("/{pp1}");

        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(12));

    }
    @Test
    public void test02(){
        /*
        2- https://restful-booker.herokuapp.com/booking
endpointine asagidaki body’ye sahip bir POST
request gonderdigimizde donen response’un
status code’unun 200 oldugunu ve “firstname”
degerinin “Ahmet” oldugunu test edin
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

        spaceHerokuappPlace.pathParam("pp1","booking");
        JSONObject innerJason=new JSONObject();
        innerJason.put("checkin" , "2021-06-01");
        innerJason.put("checkout" , "2021-06-10");
        JSONObject anaJason=new JSONObject();
        anaJason.put("firstname" , "Ahmet");
        anaJason.put("lastname" , "Bulut");
        anaJason.put("totalprice" , 500);
        anaJason.put("depositpaid" , false);
        anaJason.put("bookingdates" , innerJason);
        anaJason.put("additionalneeds" , "wi-fi");

        Response response=given().spec(spaceHerokuappPlace).contentType(ContentType.JSON).when()
                .body(anaJason.toString()).post("/{pp1}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("booking.firstname",Matchers.equalTo("Ahmet"));


    }

}
