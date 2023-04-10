package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_soru {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
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
                        Response Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */
    @Test
    public void test01(){
        String data=" https://restful-booker.herokuapp.com/booking";

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

        Response response=given().contentType(ContentType.JSON).when().
                            body(anaJason.toString()).post(data);

        response.prettyPrint();
        //4. adim test

        JSONObject expectedJason=new JSONObject();
        expectedJason.put("bookingid",24);
        expectedJason.put("booking",anaJason);
        JsonPath actualJason=response.jsonPath();
        Assert.assertEquals(expectedJason.getJSONObject("booking").get("firstname"),actualJason.get("booking.firstname"));
        Assert.assertEquals(expectedJason.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),actualJason.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedJason.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),actualJason.get("booking.bookingdates.checkout"));

    }
}
