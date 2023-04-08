package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_GetResponseBodyTesti {
    /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        donen Response’in
             status code'unun 200,
             ve content type'inin ContentType.JSON,
             ve response body'sinde bulunan userId'nin 5,
             ve response body'sinde bulunan title'in "optio dolor molestias sit"
             oldugunu test edin.
         */

    @Test
    public void testResponse01(){

        String data="https://jsonplaceholder.typicode.com/posts/44";

        Response response=given().when().get(data);
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        response.then().assertThat().body("title", Matchers.equalTo("optio dolor molestias sit"));
        response.then().assertThat().body("userId",Matchers.equalTo(5));
    }
}
