package org.azurTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class AzureTask {

	@Test
	
	public void getRequest() {
		Response getResponse = given()
		.baseUri("https://dummyjson.com/")
		.header("Content-Type","application/json")
		.queryParam("key", "hair.color")
		.queryParam("value","Brown")
		.when().get("/users/filter");
		
		System.out.println("Status Code	:"+getResponse.statusCode());
		Assert.assertEquals(getResponse.statusCode(), 200);
		
		 String getResponseBody = getResponse.getBody().asPrettyString();
		System.out.println("Response Body :"+getResponseBody);
		
		List<String> userFirstName = getResponse.jsonPath().getList("users.firstName");
        ArrayList<String> users = new ArrayList<>();
        for (int i = 0; i < userFirstName.size(); i++) {
			users.add(userFirstName.get(i));
		}
        
        System.out.println(users)
	}
	System.out.println(userFirstName);
}
