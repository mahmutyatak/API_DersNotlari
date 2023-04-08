package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JasonObjectVerileriOlusturma {

    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }
    ]
}
     */
    @Test
            public void jasonObjeTesti(){
        JSONObject cepTelefonu=new JSONObject();
        cepTelefonu.put("type", "iPhone");
        cepTelefonu.put("number", "0123-4567-8888");

        JSONObject evTelefonu=new JSONObject();
        evTelefonu.put("type", "home");
        evTelefonu.put("number", "0123-4567-8910");
        JSONArray telefon=new JSONArray();
        telefon.put(cepTelefonu);
        telefon.put(evTelefonu);

        JSONObject adresBlgisi=new JSONObject();
        adresBlgisi.put("streetAddress","naist street");
        adresBlgisi.put("city","Nara");
        adresBlgisi.put("postalCode","630-0192");

        JSONObject kisiBlgisi=new JSONObject();
        kisiBlgisi.put("firstName", "John");
        kisiBlgisi.put("lastName", "doe");
        kisiBlgisi.put("age", 26);
        kisiBlgisi.put("address",adresBlgisi);
        kisiBlgisi.put("phoneNumbers",telefon);

        System.out.println(kisiBlgisi);

        System.out.println("İSİM :"+kisiBlgisi.get("firstName"));//İSİM BİLGİSİNİ GETİRDİK.
        System.out.println("soyisim :"+kisiBlgisi.get("lastName"));//soyismi getirdik.

        System.out.println("Adress :"+kisiBlgisi.getJSONObject("address"));
        //ADRESİ getirmek icin tamamı bri jason objesi oldugu icin getJasonObject seklinde cagiriyoruz.
        //butun adress bilgisini getirdi

        System.out.println("city :"+kisiBlgisi.getJSONObject("address").get("city"));//Nara
        //once jason objesine bagli oldugu adrss bilgisini getirdik sonra icindeki city degerine ulaştık.


        System.out.println("phone numbers :"+kisiBlgisi.getJSONArray("phoneNumbers").get(0));

        //once jason arraye ulastık sonra icindeki jason objecti index kullanarak cağırdık.cep telefonu jasonobjectine ulastik.


        //type olarak iphone yazdırmak istiyoruz.
        System.out.println("type :"+kisiBlgisi.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));

        //ev telefon no sunu yazdırmak istiyoruz

        System.out.println("ev telefon no :"+kisiBlgisi.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));

        //ikisinde de once jason arraye gidiyoruz ardından array icindek jason objesinden faydalanarak veriye ulaşıyoruz.

    }

}
