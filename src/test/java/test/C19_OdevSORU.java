package test;

import baseUrl.JasonPlaceOlder_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.JasonTestDatalari;

import static io.restassured.RestAssured.given;

public class C19_OdevSORU  extends JasonPlaceOlder_BaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
PUT request yolladigimizda donen response’in
status kodunun 200, content type’inin “application/json; charset=utf-8”,
Connection header degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
TEST DATA CLASS KULLANIMI
Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}

     */
    @Test
    public void test01(){

        spaceJasonPlace.pathParams("pp1","posts","pp2","70");
        JasonTestDatalari jasonTestDatalari=new JasonTestDatalari();

        JSONObject expectedJason=jasonTestDatalari.getExpectedJason(10,70);

        Response response=given().spec(spaceJasonPlace).contentType(ContentType.JSON).when().
                body(expectedJason.toString()).put("/{pp1}/{pp2}");

        response.prettyPrint();

        //ASSERTİON
        JsonPath actualJason=response.jsonPath();
        response.then().assertThat().statusCode(jasonTestDatalari.basariliStatusKodu).contentType(ContentType.JSON).
                header("Connection","keep-alive");

        Assert.assertEquals(expectedJason.get("id"),actualJason.get("id"));
        Assert.assertEquals(expectedJason.get("userId"),actualJason.get("userId"));










    }
}
