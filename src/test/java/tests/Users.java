package tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import base.BaseTest;
import endpoints.Routes;
import io.restassured.response.Response;

public class Users extends BaseTest{
    
    @Test
    public void getSingleUser(){
        Response response = given()
                                .pathParam("id", 1)
                                .log().all()
                            .when()
                                .get(Routes.getSingleUser)
                            .then()
                                .statusCode(200)
                                .log().all()
                                .extract().response();
        String jsonString = response.asString();
        System.out.println(jsonString);
    }
    @Test
    public void getAllUsers(){
        Response response = given()
                                .log().all()
                            .when()
                                .get(Routes.getAllUsers)
                            .then()
                                .statusCode(200)
                                .log().all()
                                .extract().response();
        String jsonString = response.toString();
        System.out.println(jsonString);
    }
}
