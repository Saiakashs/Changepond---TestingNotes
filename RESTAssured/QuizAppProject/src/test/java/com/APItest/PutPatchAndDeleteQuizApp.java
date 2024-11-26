package com.APItest;
import static io.restassured.RestAssured.given;

import javax.annotation.meta.When;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutPatchAndDeleteQuizApp {
	
	@Test
	public void testPut() {
		// Create the JSON object for the PUT request
		JSONObject request = new JSONObject();
		request.put("fname", "SaiKutthalingamS");
		request.put("lname", "Srinivasan");
		request.put("contact", "9360335900");
		request.put("email", "saiakash@gmail.com");
		request.put("gender", "male");
		request.put("role", "Student");
 
		// Perform the PUT request using the token
		RestAssured.baseURI = "http://quiz-be-test.hematitecorp.com";
 
		given().
		header("Content-Type", "application/json").
		header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNzMxNTA1NDcyLCJpYXQiOjE3MzE0ODk4NzIsImp0aSI6ImMwM2M2YzI1Y2M1YTRlZGU5YjU4Mjk3Y2M1MDI1MTFlIiwidXNlcl9pZCI6Mn0.ciV9UII7uh5TYtRMOH-_NooohAqOp1TDpbCqfG38TX4"). // Add the token to the Authorization header
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		put("/api/user/employee/").
		then().
		statusCode(200).
		log().all();
	}
 
	@Test
	public void testDelete() {
		
		//for delete we don't require body
		
		RestAssured.baseURI = "https://reqres.in";
		
		When().
		delete("/api/users?page=2").then().statusCode(204).log().all();

	}

	private RestAssured When() {
		// TODO Auto-generated method stub
		return null;
	}

 
	

}
