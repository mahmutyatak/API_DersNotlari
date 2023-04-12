package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class DummyTestDatalari {


    public HashMap getexpectedMap(){
        HashMap<String,Object> innerMap=new HashMap<>();
        innerMap.put("id", 3.0);
        innerMap.put("employee_name","Ashton Cox");
        innerMap.put("employee_salary", 86000.0);
        innerMap.put("employee_age", 66.0);
        innerMap.put("profile_image", "");
        HashMap<String,Object> expectedMap=new HashMap<>();
        expectedMap.put("status", "success");
        expectedMap.put("data",innerMap);
        expectedMap.put("message", "Successfully! Record has been fetched.");

        return expectedMap;
    }

}
