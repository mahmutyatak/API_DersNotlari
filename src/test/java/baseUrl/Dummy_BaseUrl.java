package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Dummy_BaseUrl {

    protected RequestSpecification spaceDummy;

    @Before
    public void setUp(){

        spaceDummy=new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com").build();

    }


}
