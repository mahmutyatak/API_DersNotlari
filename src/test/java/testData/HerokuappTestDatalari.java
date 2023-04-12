package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class HerokuappTestDatalari {
  public int basariliStatusKodu=200;

    public JSONObject postHerokuappRequestJason(){

        JSONObject innerJason=new JSONObject();
        innerJason.put("checkin" , "2021-06-01");
        innerJason.put("checkout" ,"2021-06-10");
        JSONObject anaJason=new JSONObject();
        anaJason.put("firstname" , "Ahmet");
        anaJason.put("lastname" , "Bulut");
        anaJason.put("totalprice" , 500);
        anaJason.put("depositpaid" , false);
        anaJason.put("bookingdates" , innerJason);
        anaJason.put("additionalneeds" , "wi-fi");

        return anaJason;

    }
    HashMap<String,Object> requestMap=new HashMap<>();
    public HashMap postHerokuappRequestMap(){
/*
{
        "firstname" : "Ali",
        "lastname" : "Bak",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
                 "checkin" : "2021-06-01",
                 "checkout" : "2021-06-10"
                          },
        "additionalneeds" : "wi-fi"
    }
 */

        HashMap<String,Object> bokingdatesmapMap=new HashMap<>();
        bokingdatesmapMap.put("checkin" , "2021-06-01");
        bokingdatesmapMap.put("checkout" , "2021-06-10");

        requestMap.put("firstname" , "Ali");
        requestMap.put( "lastname" , "Bak");
        requestMap.put("totalprice" , 500.0);
        requestMap.put("depositpaid" , false);
        requestMap.put("bookingdates",bokingdatesmapMap);
        requestMap.put("additionalneeds" , "wi-fi");

return requestMap;

    }
    public HashMap expectedMap(){
        HashMap<String,Object> expectedMap=new HashMap<>();
        expectedMap.put("bookingid",24.0);
        expectedMap.put("booking",requestMap);
        return expectedMap;
    }

}
