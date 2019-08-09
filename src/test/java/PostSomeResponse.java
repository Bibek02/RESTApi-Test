import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostSomeResponse {
    Properties prop = new Properties();

    @BeforeTest
    public void getData() throws IOException {
        FileInputStream fils = new FileInputStream("C:\\Users\\176791\\Documents\\NetBeansProjects\\AWF_PSD2\\src\\test\\resources\\env.properties");
        prop.load(fils);
    }

    @Test
    public void postNewUser() {
        RestAssured.baseURI = prop.getProperty("LOCALHOST");

        given().header("Content-Type", "application/json").
                body(PayLoad.getPostData()).when().post(Endpoint.getPostUser()).
                then().assertThat().statusCode(200).and().
                body("name", equalTo("robert"));
    }
    @Test
    public void checkStudents() {
        RestAssured.baseURI = prop.getProperty("LOCALHOST");

       Response res =  given().get(Endpoint.getPostUser()).then().statusCode(200).extract().response();
       String response =res.asString();
       System.out.println(response);
    }
}
