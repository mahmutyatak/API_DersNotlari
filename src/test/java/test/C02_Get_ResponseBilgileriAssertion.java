package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ResponseBilgileriAssertion {
//Asertion testi yapacagiz o yuzden 4. adimi yapiyoruz ayni soru icin.

    @Test
    public void get01() {
        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Request Body hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";
        // 2 - Eger soruda bize verilmisse Expected Data hazirla
        // 3 - Bize donen Response'i Actual Data olarak kaydet
        Response response = given().when().get(url);
        response.prettyPrint();
        //4-expected data ile actual datayı karsılaştırırız(Assertion).
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                .header("Server","Cowboy").statusLine("HTTP/1.1 200 OK");

    }
}
