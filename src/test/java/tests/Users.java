package tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import base.BaseTest;
import endpoints.Routes;
import io.restassured.response.Response;
import payloads.PayloadProduct;

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
    @Test
    public void createUser(){

        PayloadProduct payload = new PayloadProduct();
        payload.id="1234";
        payload.email="hfsihfi@ifd.com";
        payload.user="huhu";
        payload.password="huh12";

        given()
            .header("Content-Type", "application/json")
            .body(payload)
            .log().all()
        .when()
            .post(Routes.createUser)
        .then()
            .log().all()
            .statusCode(201);
    }
    @Test
    public void updateUser(){
        PayloadProduct payload = new PayloadProduct();
        payload.email="hfsihfi@ibd.com";
        payload.user="huhu";
        payload.password="huh34";

        given()
            .pathParam("id", 1)
            .header("Content-Type", "application/json")
            .body(payload)
            .log().all()
        .when()
            .post(Routes.updateUser)
        .then()
            .log().all()
            .statusCode(200);
    }
    @Test
    public void deleteProductTest() {

    given()
        .pathParam("id", 1)
        .log().all()
    .when()
        .delete(Routes.deleteProduct)
    .then()
        .log().all()
        .statusCode(200);   // FakeStore returns 200
    }
}
