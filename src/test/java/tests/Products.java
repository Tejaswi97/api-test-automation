//This class contains test scripts of products
package tests;

import base.BaseTest;
import endpoints.Routes;
import io.restassured.response.Response;
import payloads.PayloadProduct;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class Products extends BaseTest {
    
    @Test
    public void getSingleUser() {

        Response response = given()
                                .pathParam("id", 1)
                                .log().all()
                            .when()
                                .get(Routes.getProduct)
                            .then()
                                .log().all()
                                .statusCode(200)
                                .extract().response();

        // Print full response
        System.out.println("Response Body:");
        response.asPrettyString();
        String jsonString = response.asString();
        String category = JsonPath.from(jsonString).getString("category");
        System.out.println("Category is "+category);
    }
    @Test
    public void getAllUsers(){

        Response response = given()
                                .log().all()
                            .when()
                                .get(Routes.getAllProducts)
                            .then()
                                .log().all()
                                .statusCode(200)
                                .extract().response();
        System.out.println("Response Body:");
        response.asPrettyString();
    }

    @Test
    public void createProduct() {

        PayloadProduct payload = new PayloadProduct();
        payload.title = "Test Product";
        payload.price = 99.99;
        payload.description = "Automation Test Product";
        payload.image = "https://i.pravatar.cc";
        payload.category = "electronics";

        given()
            .header("Content-Type", "application/json")
            .body(payload)
            .log().all()
        .when()
            .post(Routes.createProduct)
        .then()
            .log().all()
            .statusCode(201)
            .body("title", equalTo(payload.title));
    }

    @Test
    public void updateProduct() {

        PayloadProduct payload = new PayloadProduct();
        payload.title = "Updated product";
        payload.price = 120.50;
        payload.description = "updated description";
        payload.image = "https://i.pravatar.cc";
        payload.category = "electronics";

        given()
            .pathParam("id", 1)
            .header("Content-Type", "application/json")
            .body(payload)
            .log().all()
        .when()
            .put(Routes.updateProduct)
        .then()
            .log().all()
            .statusCode(200)
            .body("title", equalTo(payload.title))
            .body("category",equalTo(payload.category));
    }

    @Test
    public void partialUpdateProduct() {

        String patchBody = "{ \"price\": 150.00 }";

        given()
            .pathParam("id", 1)
            .header("Content-Type", "application/json")
            .body(patchBody)
        .when()
            .patch(Routes.updateProduct)
        .then()
            .statusCode(200);
            //.body("price", equalTo(150.00f))
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

    @Test
    public void invalidEndpointTest() {

        given()
        .when()
            .get("/invalidEndpoint")
        .then()
            .statusCode(404);
    }

    @Test
    public void createProduct_EmptyBody() {

        given()
            .header("Content-Type", "application/json")
            .body("")
        .when()
            .post(Routes.createProduct)
        .then()
            .statusCode(201);
    }
}