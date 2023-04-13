package test;

import baseUrl.Dummy_BaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoDummy_Data;
import pojos.PojoDummy_EzpectedBody;

import static io.restassured.RestAssured.given;

public class C27_Get_Pojo extends Dummy_BaseUrl {

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
        spaceDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);
        PojoDummy_Data pojoDummy_data=new PojoDummy_Data(3,"Ashton Cox",86000,66,"");
        PojoDummy_EzpectedBody pojoDummy_ezpectedBody=new PojoDummy_EzpectedBody("success",pojoDummy_data,"Successfully! Record has been fetched.");

        Response response=given().spec(spaceDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
        response.prettyPrint();

        PojoDummy_EzpectedBody actualResponseBody=response.as(PojoDummy_EzpectedBody.class);

        Assert.assertEquals(pojoDummy_ezpectedBody.getStatus(),actualResponseBody.getStatus());
        Assert.assertEquals(pojoDummy_ezpectedBody.getData().getId(),actualResponseBody.getData().getId());
        Assert.assertEquals(pojoDummy_ezpectedBody.getData().getProfile_image(),actualResponseBody.getData().getProfile_image());
        Assert.assertEquals(pojoDummy_ezpectedBody.getMessage(),actualResponseBody.getMessage());





    }

}
