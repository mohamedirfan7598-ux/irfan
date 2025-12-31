package org.azurTesting;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class PostRequest {
	@Test
	
	public void postreq() {
		Map <String,String> requestBody = new HashMap<>();
		requestBody.put("firstName", "Mohamed");
		requestBody.put("lastName", "Irfan");
		requestBody.put("maidenName", "KA");
		requestBody.put("age", "29");
		requestBody.put("gender", "male");
		requestBody.put("email", "irfan@gmail.com");
		requestBody.put("phone", "9080706050");
		requestBody.put("password", "**********");
		requestBody.put("birthDate", "27/04/1996");
		requestBody.put("image", "Not Available");
		requestBody.put("bloodGroup", "AB +ve");
		requestBody.put("eyeColor", "Black");

		  Response postResponse =
		            given()
		                .baseUri("https://dummyjson.com")
		                .contentType(ContentType.JSON)
		                .body(requestBody)
		                .when()
		                .post("/users/add");

		    System.out.println("Status Code : " + postResponse.getStatusCode());
		    Assert.assertEquals(postResponse.getStatusCode(), 201);
		    
		    System.out.println("Response Body : ");
		    System.out.println(postResponse.getBody().asPrettyString());
		    
		    JsonPath jsonPath = postResponse.jsonPath();

		    Assert.assertEquals(jsonPath.getString("firstName"), "Mohamed");
		    Assert.assertEquals(jsonPath.getString("lastName"), "Irfan");
		    Assert.assertEquals(jsonPath.getInt("age"), 29);
		    Assert.assertEquals(jsonPath.getString("gender"), "male");
		    Assert.assertEquals(jsonPath.getString("email"), "irfan@gmail.com");

		    System.out.println("POST request validated successfully");
		}
	}


