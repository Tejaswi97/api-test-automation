package tests;


import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import base.BaseTest;
import endpoints.Routes;

public class Authentication extends BaseTest{
    
    @Test
    public void login(){
    String payload = "{ \"username\": \"johnd\", \"password\": \"m38rmF$\" }";

        given()
            .header("Content-Type", "application/json")
            .body(payload)
            .log().all()
        .when()
            .post(Routes.loginUser)
        .then()
            .log().all()
            .statusCode(201);
    }
}
