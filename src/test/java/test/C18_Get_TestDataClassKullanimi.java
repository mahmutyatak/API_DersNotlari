package test;

import baseUrl.JasonPlaceOlder_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.JasonTestDatalari;

import static io.restassured.RestAssured.given;

public class C18_Get_TestDataClassKullanimi extends JasonPlaceOlder_BaseUrl {
/*
  https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
  request yolladigimizda donen response’in status kodunun 200 ve
  response body’sinin asagida verilen ile ayni oldugunu test ediniz
   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

    @Test
    public void test(){
        spaceJasonPlace.pathParams("pp1","posts","pp2","22");

        //2 expected data olusturacagiz bunu metod ile yapacagiz.
        JasonTestDatalari jasonTestDatalari=new JasonTestDatalari();
        JSONObject expectedJason=jasonTestDatalari.getExpectedJason(3,22);


        Response response=given().spec(spaceJasonPlace).get("/{pp1}/{pp2}");
        response.prettyPrint();
        JsonPath actualJason=response.jsonPath();
        Assert.assertEquals(jasonTestDatalari.basariliStatusKodu,response.getStatusCode());
        Assert.assertEquals(expectedJason.get("userId"),actualJason.get("userId"));
        Assert.assertEquals(expectedJason.get("id"),actualJason.get("id"));
        Assert.assertEquals(expectedJason.get("title"),actualJason.get("title"));
        Assert.assertEquals(expectedJason.get("body"),actualJason.get("body"));




    }
}
