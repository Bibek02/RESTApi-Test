import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.hamcrest.Matchers.equalTo;

public class AddAndDeletePlace {
    Properties prop = new Properties();

    @BeforeTest
    public void getData() throws IOException {
        FileInputStream fils = new FileInputStream("C:\\Users\\176791\\Documents\\NetBeansProjects\\AWF_PSD2\\src\\test\\resources\\env.properties");
        prop.load(fils);
    }

    @Test
    public void addAndDelete() {
        RestAssured.baseURI = prop.getProperty("HOST");
        Response res =
                given().header("Content-Type", "application/json").
                        body(PayLoad.getPostData()).when().post(Endpoint.getPostUser()).
                        then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and().body("name", equalTo("robert")).
                        extract().response();
        //Task 2 - Grab the Place ID from response
        String response = res.asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String id = js.get("id");
        System.out.println(id);
        // Task 3 place this place id in the Delete request
        given().when().delete("/api/users/" + id).then().statusCode(204).extract().response();
    }
}
