import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetSomeResponse {
    Properties prop = new Properties();

    @BeforeTest
    public void getData() throws IOException {

    FileInputStream fils = new FileInputStream("C:\\Users\\176791\\Documents\\NetBeansProjects\\AWF_PSD2\\src\\test\\resources\\env.properties");
    prop.load(fils);
    }

    @Test
    public void getSingleUserStatus(){
        RestAssured.baseURI = prop.getProperty("HOST");
        int userNumber = 1;
        given().
                param("users", userNumber).
                when().
                get(Endpoint.getSingleUser()).
                then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }
    @Test
    public void getListResource(){
        RestAssured.baseURI = prop.getProperty("HOST");
        int pageNumber = 1;
        given().
                when().
                get(Endpoint.getListUsers()).
                then().
                assertThat().statusCode(200).contentType(ContentType.JSON).and().
                body("data[1].year", equalTo(2001)).and().
                body("data[1].name",equalTo("fuchsia rose")).and().
                header("Server", "cloudflare");
    }
}
