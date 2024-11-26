package com.APItest;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
 
public class LoginandRegistrationApiTest {
	
	@Test
	
	public void GET_LoginPage(){
		Response response = get("http://quiz-fe.hematitecorp.com/");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getHeader("User-Agent"));
		System.out.println(response.getHeader("Host"));
		System.out.println(response.getHeader("Connection"));
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);  



		
	}
	
	@Test
	public void GET_Student_registration() {
		
		Response response = get("http://quiz-fe.hematitecorp.com/#/student-registration");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getHeader("User-Agent"));
		System.out.println(response.getHeader("Host"));
		System.out.println(response.getHeader("Connection"));
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
	}
	
	
	@Test
	public void testPost(){
		Map<String, Object> map = new HashMap<String, Object>();
	
//	map.put("name", "Monica");
//	map.put("job", "Trainer");
//	
//	System.out.println(map);
	
	JSONObject request = new JSONObject(map);
	
	request.put("fname", "SaiS");
	request.put("lname", "Srinivasan");
	request.put("contact", "9360335900");
	request.put("email", "saiakash@gmail.com");
	request.put("gender", "male");
	request.put("role", "student");
	
	System.out.println(request.toJSONString());
	
	baseURI = "http://quiz-be-test.hematitecorp.com";
	
	given().
	header("Content-Type", "application/json").//you should know header of your json response.
	contentType(ContentType.JSON).accept(ContentType.JSON). //explicitly telling to server that my content type is json
	body(request.toJSONString()).
	post("/api/user/").then().statusCode(200).log().all();
	
	}

}
