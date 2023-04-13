package test;

import baseUrl.Herokuapp_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoHerokuap_Bokking;
import pojos.PojoHerokuappExpectedBody;
import pojos.PojoHerokuapp_bookingdates;

import static io.restassured.RestAssured.given;

public class C26_Post_Pojo extends Herokuapp_BaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ali",
                        "lastname" : “Bak",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body = Expected Data
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
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

    @Test
    public void test01(){

      spaceHerokuappPlace.pathParams("pp1","booking");
        PojoHerokuapp_bookingdates pojoHerokuapp_bookingdates=new PojoHerokuapp_bookingdates("2021-06-01","2021-06-10");
        PojoHerokuap_Bokking pojoHerokuap_bokking=new PojoHerokuap_Bokking("Ali","Bak",500,false,pojoHerokuapp_bookingdates,"wi-fi");

        PojoHerokuappExpectedBody pojoHerokuappExpectedBody=new PojoHerokuappExpectedBody(24,pojoHerokuap_bokking);

        Response response=given().spec(spaceHerokuappPlace).contentType(ContentType.JSON).
                when().body(pojoHerokuap_bokking).post("/{pp1}");

        response.prettyPrint();

        //4-assertion.
          PojoHerokuappExpectedBody actualResponseBody=response.as(PojoHerokuappExpectedBody.class);
        Assert.assertEquals(pojoHerokuappExpectedBody.getBooking().getFirstname(),actualResponseBody.getBooking().getFirstname());
        Assert.assertEquals(pojoHerokuappExpectedBody.getBooking().getTotalprice(),actualResponseBody.getBooking().getTotalprice());
        Assert.assertEquals(pojoHerokuappExpectedBody.getBooking().getBookingdates().getCheckin(),actualResponseBody.getBooking().getBookingdates().getCheckin());


    }



}
