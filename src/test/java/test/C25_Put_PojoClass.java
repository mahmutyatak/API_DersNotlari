package test;

import baseUrl.JasonPlaceOlder_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JasonPlaceHolderREQUESTBody_Pojo;

import static io.restassured.RestAssured.given;

public class C25_Put_PojoClass extends JasonPlaceOlder_BaseUrl {
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
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    @Test
    public void test01(){

        //1-URL VE REQUEST BODY İ OLUSTUR.

        spaceJasonPlace.pathParams("pp1","posts","pp2","70");

        JasonPlaceHolderREQUESTBody_Pojo requestbody=new JasonPlaceHolderREQUESTBody_Pojo("Ahmet","Merhaba",10,70);

        System.out.println(requestbody);

        //2-expected data hazırla
        JasonPlaceHolderREQUESTBody_Pojo expectedBody=new JasonPlaceHolderREQUESTBody_Pojo("Ahmet","Merhaba",10,70);

        //3-response u kaydet.
        Response response=given().spec(spaceJasonPlace).contentType(ContentType.JSON)
                .when().body(requestbody).put("/{pp1}/{pp2}");

        response.prettyPrint();

        //4-asertion
        //kendi hazırladıgımız data turune ceviriyoruz response i.
        JasonPlaceHolderREQUESTBody_Pojo actualresponsePojo=response.as(JasonPlaceHolderREQUESTBody_Pojo.class);

        Assert.assertEquals(expectedBody.getTitle(),actualresponsePojo.getTitle());
        Assert.assertEquals(expectedBody.getBody(),actualresponsePojo.getBody());
        Assert.assertEquals(expectedBody.getUserId(),actualresponsePojo.getUserId());
        Assert.assertEquals(expectedBody.getId(),actualresponsePojo.getId());




    }
}
