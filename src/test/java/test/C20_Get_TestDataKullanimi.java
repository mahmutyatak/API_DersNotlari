package test;

import baseUrl.Dummy_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_Get_TestDataKullanimi extends Dummy_BaseUrl {
    /*
    20_Get_TestDataKullanimi
http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un status code’unun 200, content Type’inin
application/json ve body’sinin asagidaki gibi oldugunu test edin.
Response Body
{
"status": "success",
"data": {
"id": 3,
"employee_name": "Ashton Cox",
"employee_salary": 86000,
"employee_age": 66,
"profile_image": ""
},
"message": "Successfully! Record has been fetched."
}
     */
    @Test
    public void test01(){
        spaceDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);


        Response response=given().spec(spaceDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
        response.prettyPrint();
        JSONObject innerJason=new JSONObject();
        innerJason.put("id", 3);
        innerJason.put("employee_name","Ashton Cox");
        innerJason.put("employee_salary", 86000);
        innerJason.put("employee_age", 66);
        innerJason.put("profile_image", "");
        JSONObject expectedJason=new JSONObject();
        expectedJason.put("status", "success");
        expectedJason.put("data",innerJason);
        expectedJason.put("message", "Successfully! Record has been fetched.");
        JsonPath actualJason=response.jsonPath();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);


        Assert.assertEquals(expectedJason.get("status"),actualJason.get("status"));
        Assert.assertEquals(expectedJason.getJSONObject("data").get("id"),actualJason.get("data.id"));
        Assert.assertEquals(expectedJason.getJSONObject("data").get("profile_image"),actualJason.get("data.profile_image"));
    }
}
