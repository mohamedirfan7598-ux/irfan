package org.azurTesting;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteRequest {
	@Test
	public void delete() {
		Response response = given().baseUri("https://dummyjson.com").when().delete("/users/8");

		int statusCode = response.getStatusCode();
		System.out.println("Status Code : " + statusCode);
		Assert.assertEquals(statusCode, 200);

		String contentType = response.getHeader("Content-Type");
		System.out.println("Content-Type : " + contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");

		JsonPath jsonPath = response.jsonPath();

		int deletedUserId = jsonPath.getInt("id");
		boolean isDeleted = jsonPath.getBoolean("isDeleted");

		Assert.assertEquals(deletedUserId, 8);
		Assert.assertEquals(isDeleted, true);

		long responseTime = response.getTime();
		System.out.println("Response Time : " + responseTime + " ms");
		
		Assert.assertTrue(responseTime < 5000, "Response time too slow");
		System.out.println("DELETE validated successfully");
	}


	}


