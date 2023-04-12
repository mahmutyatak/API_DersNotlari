package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JasonTestDatalari {
   public int basariliStatusKodu=200;

    public JSONObject getExpectedJason(int userId,int id){

    JSONObject expectedJason=new JSONObject();
    expectedJason.put("userId",userId);
    expectedJason.put("id",id);
    expectedJason.put("title","Ahmet");
    expectedJason.put("body","Merhaba");

    return expectedJason;

    }

    public HashMap requestBodyOlusturMap(){
     /*
     {
      "title":"Ahmet",
             "body":"Merhaba",
             "userId":10,
             "id":70
     }
     */

     HashMap<String,Object> requestBody=new HashMap<>();
     requestBody.put("title","Ahmet");
     requestBody.put("body","Merhaba");
     requestBody.put("userId",10.0);
     requestBody.put("id",70.0);

  return requestBody;
    }



}
