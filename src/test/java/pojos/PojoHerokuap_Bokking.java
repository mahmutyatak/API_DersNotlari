package pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PojoHerokuap_Bokking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private PojoHerokuapp_bookingdates bookingdates;
    private String additionalneeds;

}
