package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JasonPlaceOlder_BaseUrl {

    //https://jsonplaceholder.typicode.com

 protected RequestSpecification spaceJasonPlace;

 @Before
    public void setUp(){

     spaceJasonPlace=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();

 }



}
