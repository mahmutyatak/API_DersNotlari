package test;

import baseUrl.Herokuapp_BaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlHerokuappQueryParam extends Herokuapp_BaseUrl {
    // Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
    /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 209 id'ye sahip bir booking oldugunu test edin
     */
     /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */
    /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */
    @Test
    public void test01(){
        /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 209 id'ye sahip bir booking oldugunu test edin
     */
        spaceHerokuappPlace.pathParam("pp1","booking");
        Response response=given().spec(spaceHerokuappPlace).when().get("/{pp1}");

        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(209));
    }
    @Test
    public void test02(){

        /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */
        spaceHerokuappPlace.pathParam("pp1","booking");
        spaceHerokuappPlace.queryParam("firstname","Jim");
        Response response=given().spec(spaceHerokuappPlace).when().get("/{pp1}");

        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.not(Matchers.empty()));



    }
    @Test
    public void test03(){
 /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */
        spaceHerokuappPlace.pathParam("pp1","booking").queryParams("firstname","Mark","lastname","Smith");
        Response response=given().spec(spaceHerokuappPlace).when().get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.not(Matchers.empty()));
    }
}
