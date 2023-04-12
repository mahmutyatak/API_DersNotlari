package test;

import baseUrl.JasonPlaceOlder_BaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C15_BaseUrl extends JasonPlaceOlder_BaseUrl {

    //Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
    /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
         request gonderdigimizde donen response’un status code’unun 200 oldugunu
         ve Response’ta 100 kayit oldugunu test edin.
        */
    /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response’un status code’unun 200 oldugunu
            ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
         */
    /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            response body’sinin null oldugunu test edin
         */

    @Test
    public void test01(){
        /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
         request gonderdigimizde donen response’un status code’unun 200 oldugunu
         ve Response’ta 100 kayit oldugunu test edin.
        */
        //1-urlhazırla
        spaceJasonPlace.pathParam("pp1","posts");
        //2-expecteddat hazırla
        //3- response body olustur.
        Response response=given().spec(spaceJasonPlace).when().get("/{pp1}");
        response.prettyPrint();
        //4-assertion
        response.then().assertThat().statusCode(200).body("userId", Matchers.hasSize(100));


}
    @Test
    public void test02(){
/*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response’un status code’unun 200 oldugunu
            ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
         */
        spaceJasonPlace.pathParams("pp1","posts","pp2",44);

        Response response=given().spec(spaceJasonPlace).when().get("/{pp1}/{pp2}");
        response.prettyPrint();
        response.then().statusCode(200).body("title",Matchers.equalTo("optio dolor molestias sit"));




    }
    @Test
    public void test03(){
       /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            response body’sinin null oldugunu test edin
         */
        spaceJasonPlace.pathParams("pp1","posts","pp2",50);
        Response response=given().spec(spaceJasonPlace).when().delete("/{pp1}/{pp2}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("id",Matchers.nullValue());

    }




}
