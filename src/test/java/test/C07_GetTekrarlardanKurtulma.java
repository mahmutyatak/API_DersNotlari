package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_GetTekrarlardanKurtulma {
     /*
                https://restful-booker.herokuapp.com/booking/14018 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"James",
                    ve "lastname“in, "Brown",
                    ve "totalprice“in, 111,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */
    @Test
    public void test01(){
        String data="https://restful-booker.herokuapp.com/booking/272";

        Response response=given().when().get(data);

        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("firstname",equalTo("James"),
                "lastname", equalTo("Brown"),
                "totalprice", equalTo(111),
                "depositpaid", equalTo(true),
                "additionalneeds", equalTo("Breakfast"));
    }
}
