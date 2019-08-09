import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class GetResponse {



    @Test
    public void test1() {
        given().get(
                "https://ib-psd2-tpp-ibiznes24-main-zt004.app.os1.t.it.bzwbk/psd2/tpp/api/accounts/init?environment=zt004").then().statusCode(200);
    }

    @Test
    public void test2() {
        when().get(
                "https://ib-psd2-tpp-ibiznes24-main-zt004.app.os1.t.it.bzwbk/psd2/tpp/api/accounts/init?environment=zt004").then().statusCode(200);
    }

    @Test
    public void test3() {
        Response response = given().get("https://ib-psd2-tpp-ibiznes24-main-zt004.app.os1.t.it.bzwbk/psd2/tpp/api/accounts/init?environment=zt004");
        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void test4() {
     Response response = given().get("https://ib-psd2-tpp-ibiznes24-main-zt004.app.os1.t.it.bzwbk/psd2/tpp/api/accounts/init?environment=zt004");
    response.then().assertThat().statusCode(200);
    }
}
