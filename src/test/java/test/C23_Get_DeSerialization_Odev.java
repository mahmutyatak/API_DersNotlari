package test;

import baseUrl.Dummy_BaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.DummyTestDatalari;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C23_Get_DeSerialization_Odev extends Dummy_BaseUrl {
    /*
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

        DummyTestDatalari dummyTestDatalari=new DummyTestDatalari();
        HashMap<String,Object> expectedMap=dummyTestDatalari.getexpectedMap();

        Response response=given().spec(spaceDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
        response.prettyPrint();

        HashMap<String,Object> actualMap=response.as(HashMap.class);

        //System.out.println(expectedMap);
        //System.out.println(actualMap);

        Assert.assertEquals(expectedMap.get("status"),actualMap.get("status"));
        Assert.assertEquals(((Map)(expectedMap.get("data"))).get("id"),((Map)(actualMap.get("data"))).get("id"));
        Assert.assertEquals(((Map)(expectedMap.get("data"))).get("employee_name"),((Map)(actualMap.get("data"))).get("employee_name"));
        Assert.assertEquals(((Map)(expectedMap.get("data"))).get("employee_salary"),((Map)(actualMap.get("data"))).get("employee_salary"));
        Assert.assertEquals(((Map)(expectedMap.get("data"))).get("profile_image"),((Map)(actualMap.get("data"))).get("profile_image"));
        Assert.assertEquals(expectedMap.get("message"),actualMap.get("message"));

    }
}
