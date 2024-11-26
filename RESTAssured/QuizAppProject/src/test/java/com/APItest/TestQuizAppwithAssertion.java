package com.APItest;
 
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
 
import org.testng.Assert;
import org.testng.annotations.Test;
 
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
 
public class TestQuizAppwithAssertion {
 
    @Test
    public void test_1() {
        // GET request to the API
        Response response = get("http://quiz-be-test.hematitecorp.com/api/user/");
        
        // Print response details
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + "ms");
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Content-Type Header: " + response.getHeader("content-type"));
        
        // Assert the status code is 200
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Expected status code 200 but found: " + statusCode);
    }
 
    @Test
    public void test_2() {
        // Base URI setup
        baseURI = "http://quiz-be-test.hematitecorp.com";
 
        // GET request and assertions
        given()
            .get("/api/user/")
        .then()
            .statusCode(200) // Validate status code
            .body("data[2].id", equalTo(17)) // Validate specific JSON data
            .log().all(); // Log response details
 
        // Optional alternative:
        // Uncomment the below line if `data[105].email` is present in the response:
        // .body("data[105].email", equalTo("loki@gmail.com"));
    }
}
