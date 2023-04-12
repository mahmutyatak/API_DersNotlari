package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_ODEV_SORU {
    /*
    C14_Put_SoftAssertIleExpectedDataTesti
http://dummy.restapiexample.com/api/v1/create url’ine asagidaki body’ye sahip bir POST
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Request Body
{
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40
}
}
Response Body
{ "status": "success",
"data": {
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40 }
},
"message": "Successfully! Record has been added."
}
     */
    @Test
    public void test01(){
        String data="https://dummy.restapiexample.com/api/v1/create";
        JSONObject dataJason=new JSONObject();
        dataJason.put("name", "Ahmet");
        dataJason.put("salary", "1230");
        dataJason.put("age", "44");
        dataJason.put("id", 40);
        JSONObject anaJason=new JSONObject();
        anaJason.put("status", "success");
        anaJason.put("data",dataJason);

        //2-expected data olustur
        JSONObject inner2Expected=new JSONObject();
        inner2Expected.put("name", "Ahmet");
        inner2Expected.put("salary", "1230");
        inner2Expected.put("age", "44");
        inner2Expected.put("id", 40);
        JSONObject inner1expected=new JSONObject();
        inner1expected.put("status", "success");
        inner1expected.put("data",inner2Expected);

        JSONObject expectedJason=new JSONObject();
        expectedJason.put("status", "success");
        expectedJason.put("data",inner1expected);
        expectedJason.put("message", "Successfully! Record has been added.");
        System.out.println(expectedJason);

        //3-response ı kaydet
        Response response=given().contentType(ContentType.JSON).when().body(anaJason.toString()).post(data);
        response.prettyPrint();

//{"data":{"data":{"name":"Ahmet","id":40,"salary":"1230","age":"44"},"status":"success"},"message":"Successfully! Record has been added.","status":"success"}

        //4- soft asertion
        JsonPath actualJason=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualJason.get("data.data.name"),expectedJason.getJSONObject("data").getJSONObject("data").get("name"));
        System.out.println(actualJason.get("data.data.name").toString());
    }
}
