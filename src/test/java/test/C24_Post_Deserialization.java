package test;

import baseUrl.Herokuapp_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.HerokuappTestDatalari;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Post_Deserialization extends Herokuapp_BaseUrl {
    /*
      https://restful-booker.herokuapp.com/booking url'ine asagidaki
      body'ye sahip bir POST request gonderdigimizde donen response'un
      id haric asagidaki gibi oldugunu test edin.
        Request body
   {
        "firstname" : "Ali",
        "lastname" : "Bak",
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
           "firstname":"Ali",
           "lastname":"Bak",
           "totalprice":500,
           "depositpaid":false,
           "bookingdates":{
               "checkin":"2021-06-01",
               "checkout":"2021-06-10"
           },
           "additionalneeds":"wi-fi"
           }
       }
   */
    @Test
    public void test01(){
        spaceHerokuappPlace.pathParams("pp1","booking");
        HerokuappTestDatalari herokuappTestDatalari=new HerokuappTestDatalari();
        HashMap<String,Object> requestMAP=herokuappTestDatalari.postHerokuappRequestMap();

        Response response=given().spec(spaceHerokuappPlace).contentType(ContentType.JSON)
                .when().body(requestMAP).post("/{pp1}");

        response.prettyPrint();
        HashMap<String,Object> expectedMAP=herokuappTestDatalari.expectedMap();
        HashMap<String,Object> actualMap=response.as(HashMap.class);

        assertEquals(((Map)(expectedMAP.get("booking"))).get("firstname"),((Map)(actualMap.get("booking"))).get("firstname"));
        assertEquals(((Map)(expectedMAP.get("booking"))).get("lastname"),((Map)(actualMap.get("booking"))).get("lastname"));
        assertEquals(((Map)(expectedMAP.get("booking"))).get("totalprice"),((Map)(actualMap.get("booking"))).get("totalprice"));

        assertEquals(((Map)(((Map)(expectedMAP.get("booking"))).get("bookingdates"))).get("checkin"),((Map)(((Map)(actualMap.get("booking"))).get("bookingdates"))).get("checkin"));





    }
}
