package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JasonObjesiOlusturma {

     /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
    */
    //body bolumune ekleme yapmak icin json objesi olusturmamız ve sorgumuza eklememiz gerekir.
    @Test
    public void jasonObje1(){

        JSONObject ilkjasonObject=new JSONObject();
        ilkjasonObject.put("title","Ahmet");
        ilkjasonObject.put("body","Merhaba");
        ilkjasonObject.put("userId",1);

        System.out.println("ilk obje :"+ilkjasonObject);


    }
    @Test
    public void jasonObje2(){
         /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */
        //bu sekli olusturacagiz
        JSONObject innerBookingDate=new JSONObject();
        //once bookingdates olan icerdeki objeyi olusturyoruz
        innerBookingDate.put("checkin","2018-01-01");
        innerBookingDate.put("checkout","2019-01-01");


        //dısardaki jason i tammliyoruz
        JSONObject outerGenelJason=new JSONObject();
        outerGenelJason.put("firstname","Jim");
        outerGenelJason.put("additionalneeds","Breakfast");
        outerGenelJason.put("bookingdates",innerBookingDate);
        outerGenelJason.put("totalprice",111);
        outerGenelJason.put("depositpaid",true);
        outerGenelJason.put("lastname","Brown");

        System.out.println(outerGenelJason);

    }
}
