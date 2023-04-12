package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Herokuapp_BaseUrl {

    protected RequestSpecification spaceHerokuappPlace;

    @Before
    public void setUp(){

        spaceHerokuappPlace=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }
}
