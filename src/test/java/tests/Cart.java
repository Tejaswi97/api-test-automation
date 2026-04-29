package tests;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import base.BaseTest;
import endpoints.Routes;
import io.restassured.response.Response;

public class Cart extends BaseTest{
    
    @Test
    public void getSingleCart(){
        Response response = given()
                                .pathParam("id", 1)
                                .log().all()
                            .when()
                                .get(Routes.getCart)
                            .then()
                                .log().all()
                                .statusCode(200)
                                .extract().response();
        System.out.println("Response body");
        //response.asPrettyString();
        String jsonString = response.asString();
        System.out.println(jsonString);
    }
    @Test
    public void getAllCart(){
        Response response = given()
                                .log().all()
                            .when()
                                .get(Routes.getAllCart)
                            .then()
                                .log().all()
                                .statusCode(200)
                                .extract().response();
        String jsonString = response.asString();
        System.out.println(jsonString);
    }
    @Test
    public void createCart(){
        Map<String, Object> product1 = new HashMap<>();
        product1.put("productId", 1);
        product1.put("quantity", 4);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("productId", 2);
        product2.put("quantity", 1);

        Map<String, Object> product3 = new HashMap<>();
        product3.put("productId", 3);
        product3.put("quantity", 6);

        // List of products
        List<Map<String, Object>> productsList = new ArrayList<>();
        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);

        // Main request body
        Map<String, Object> request = new HashMap<>();
        request.put("id", 1);
        request.put("userId", 1);
        request.put("date", "2020-03-02T00:00:00.000Z");
        request.put("products", productsList);
        request.put("__v", 0);

        given()
            .contentType("application/json")
            .body(request)
        .when()
            .post("/carts")
        .then()
            .statusCode(201);

    }
    @Test
    public void updateCart(){
        Map<String, Object> product1 = new HashMap<>();
        product1.put("productId", 1);
        product1.put("quantity", 2);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("productId", 2);
        product2.put("quantity", 3);

        Map<String, Object> product3 = new HashMap<>();
        product3.put("productId", 3);
        product3.put("quantity", 9);

        // List of products
        List<Map<String, Object>> productsList = new ArrayList<>();
        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);

        // Main request body
        Map<String, Object> request = new HashMap<>();
        request.put("id", 1);
        request.put("userId", 1);
        request.put("date", "2020-03-02T00:00:00.000Z");
        request.put("products", productsList);
        request.put("__v", 0);
        given()
            .pathParam("id", 1)
            .header("Content-Type", "application/json")
            .body(request)
            .log().all()
        .when()
            .put(Routes.updateProduct)
        .then()
            .log().all()
            .statusCode(200);
    }
    @Test
    public void deleteCart() {

    given()
        .pathParam("id", 1)
        .log().all()
    .when()
        .delete(Routes.deleteCart)
    .then()
        .log().all()
        .statusCode(200);   // FakeStore returns 200
    }
}
