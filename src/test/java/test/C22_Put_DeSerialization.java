package test;

import baseUrl.JasonPlaceOlder_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.JasonTestDatalari;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class C22_Put_DeSerialization extends JasonPlaceOlder_BaseUrl {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
    @Test
    public void test01(){
        //url ve body olusturma
        spaceJasonPlace.pathParams("pp1","posts","pp2",70);

        //de-starilization kullanmak icin map olarak olusturacagiz request body i.
        //2- expectedData yı olustur.
        JasonTestDatalari jasonTestDatalari=new JasonTestDatalari();
        HashMap<String, Objects> requestBody=jasonTestDatalari.requestBodyOlusturMap();

        HashMap<String, Objects> expectedBody=requestBody;

        //Response body i kaydet
        Response response=given().spec(spaceJasonPlace).contentType(ContentType.JSON)
                .when().body(requestBody).put("/{pp1}/{pp2}");
//map zaten java objesi oldugu icin body nin icinde to string yapmamiza gerek kalmadi.
            response.prettyPrint();
            //4-aSSERTİON İCİN RESPONSE İ MAPA CEVİRDİK.
            HashMap<String,Object> actualBody=response.as(HashMap.class);

        Assert.assertEquals(jasonTestDatalari.basariliStatusKodu,response.getStatusCode());
        Assert.assertEquals(expectedBody.get("id"),actualBody.get("id"));
        Assert.assertEquals(expectedBody.get("userId"),actualBody.get("userId"));
        Assert.assertEquals(expectedBody.get("title"),actualBody.get("title"));
        Assert.assertEquals(expectedBody.get("body"),actualBody.get("body"));


    }

}
