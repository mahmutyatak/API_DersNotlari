package testData;

import org.json.JSONObject;

public class JasonTestDatalari {
   public int basariliStatusKodu=200;

    public JSONObject getExpectedJason(int userId,int id){

    JSONObject expectedJason=new JSONObject();
    expectedJason.put("userId",userId);
    expectedJason.put("id",id);
    expectedJason.put("title","dolor sint quo a velit explicabo quia nam");
    expectedJason.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

    return expectedJason;

    }



}
