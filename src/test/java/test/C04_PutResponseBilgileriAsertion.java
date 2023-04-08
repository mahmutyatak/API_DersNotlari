package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_PutResponseBilgileriAsertion {

/*
        https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
        Json formatindaki body ile bir PUT request gonderdigimizde
                {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
                }
        donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK
      */

    @Test
    public void puttest01(){
        //1-request url ve body hazirla
        String data="https://jsonplaceholder.typicode.com/posts/70";

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",10);
        jsonObject.put("id",70);

        //2-expected data hazirla.
        //3-response kaydet

        Response response=given().contentType(ContentType.JSON).when().body(jsonObject.toString()).put(data);

        response.prettyPrint();//sonucu dondurur.
        response.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Server","cloudflare").contentType("application/json; charset=utf-8");



    }



}
