package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {

    /*
        https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
*/
    @Test
    public void get01(){
        //1-Gonderecegimiz request icin gerekli olan url ve ihtiyacimiz varsa Request body i hazirla
        //2-expected datayı hazırla
        //3-bize donen response i actual data olarak kaydedecegiz.
        //4-expected data ile actual datayı karsılaştırırız(Assertion).

        //1- bu soruda body e ihityacimiz yok sadece url kopyalıyoruz.

        String data="https://restful-booker.herokuapp.com/booking/10";

        //2- geciyoeuz simdilik
        //3- donen datayı actual data olarak hazirlamak icin response objesine kaydediyoruz

        Response response=given().when().get(data);
        response.prettyPrint();//response ı yazdırmak icin kulaniyoruz.

        System.out.println("status kod :"+response.getStatusCode());//donen response ın status kodu nu dondurur.
        System.out.println("content Type :"+response.getContentType());//content type getirir.
        System.out.println("server isimli header ın degeri :"+response.getHeader("Server"));//ismi server olan header degeri.yum headerlar icin getheaders.
        System.out.println("status line :"+response.getStatusLine());//status line ı getirir.
        System.out.println("zaman :"+response.getTime()+"milisaniye");//zamani getirir.mili saniye olarak.

    }


}
