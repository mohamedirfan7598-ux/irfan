package org.azurTesting;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
public class PutRequest {
@Test
	public void PutReq() {
	String requestBody = "{ \"firstName\": \"Ravi\", \"lastName\": \"Kumar\" }";

    given()
        .baseUri("https://dummyjson.com")
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .put("/users/3")
        .then()
        .statusCode(200)
        .header("Content-Type", "application/json; charset=utf-8")
        .body("firstName", equalTo("Ravi"))
        .body("lastName", equalTo("Kumar"))
        .body("id", equalTo(3))

       
        .time(lessThan(10000L));

}
    		 
	}
	

