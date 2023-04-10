package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C09_Post_JsonPathIleBodyTesti {

    /*
            https://restful-booker.herokuapp.com/booking
             url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
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
            donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */

    @Test
    public void jasonPath01(){
        String data="https://restful-booker.herokuapp.com/booking";
        JSONObject innerJason=new JSONObject();
        innerJason.put("checkin" , "2021-06-01");
        innerJason.put("checkout" ,"2021-06-10");
        JSONObject anaJason=new JSONObject();
        anaJason.put("firstname" , "Ali");
        anaJason.put("lastname" , "Bak");
        anaJason.put("totalprice" , 500);
        anaJason.put("depositpaid" , false);
        anaJason.put("bookingdates" , innerJason);
        anaJason.put("additionalneeds" , "wi-fi");

        Response response=given().contentType(ContentType.JSON).when()
                .body(anaJason.toString()).post(data);

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType("application/json").
                body("booking.firstname", equalTo("Ali"),
                        "booking.lastname",equalTo("Bak"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2021-06-01"),
                        "booking.bookingdates.checkout",equalTo("2021-06-10"),
                        "booking.additionalneeds",equalTo("wi-fi"));

    }
}
