package test;

import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {
/*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin
    asagida verilen ile ayni oldugunu test ediniz
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
    public void test01(){

        String data="https://jsonplaceholder.typicode.com/posts/22";
        //2- expected data olusturma.
        JSONObject expectedJason=new JSONObject();

        expectedJason.put("userId",3);
        expectedJason.put("id",22);
        expectedJason.put("title","dolor sint quo a velit explicabo quia nam");
        expectedJason.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");


        Response response=given().when().get(data);
        response.prettyPrint();
        //4-assertion
        //donen response objesinin body si ile islem yapmak istiyorsak bunu jasonpath objesine donusturmemiz gerikiyor.
        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(expectedJason.get("userId"),jsonPath.get("userId"));
        Assert.assertEquals(expectedJason.get("id"),jsonPath.get("id"));
        Assert.assertEquals(expectedJason.get("title"),jsonPath.get("title"));
        Assert.assertEquals(expectedJason.get("body"),jsonPath.get("body"));
    }


}
