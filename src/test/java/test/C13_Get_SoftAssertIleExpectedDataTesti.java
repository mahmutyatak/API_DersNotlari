package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void test01(){
        String data="http://dummy.restapiexample.com/api/v1/employee/3";
        JSONObject innerData=new JSONObject();
        innerData.put("id",3);
        innerData.put("employee_name","Ashton Cox");
        innerData.put("employee_salary",86000);
        innerData.put("employee_age",66);
        innerData.put("profile_image","");

        JSONObject expectedJason=new JSONObject();
        expectedJason.put("status","success");
        expectedJason.put("data",innerData);
        expectedJason.put("message","Successfully! Record has been fetched.");


        Response response=given().when().get(data);
        response.prettyPrint();
        JsonPath actualJason=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualJason.get("status"),expectedJason.get("status"));
        softAssert.assertEquals(actualJason.get("data.employee_name"),expectedJason.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(actualJason.get("data.employee_salary"),expectedJason.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(actualJason.get("data.employee_age"),expectedJason.getJSONObject("data").get("employee_age"));

        softAssert.assertEquals(actualJason.get("data.profile_image"),expectedJason.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(actualJason.get("message"),expectedJason.get("message"));

        softAssert.assertAll();

    }



}
