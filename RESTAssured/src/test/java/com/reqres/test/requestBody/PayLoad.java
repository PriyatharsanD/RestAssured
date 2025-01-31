package com.reqres.test.requestBody;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PayLoad {
	public static String getUserData()
	{
		return "{\r\n"
				+ "    \"name\": \"Priya\",\r\n"
				+ "    \"job\": \"Automation Test Engineer\"\r\n"
				+ "}";
	}
	@Test
	public void createUser()
	{
		RestAssured
			//Pre-Conditions
			.given()
			.contentType(ContentType.JSON)
			.body(getUserData())
			.log().all()
			//http Method
			.when()
			.post("https://reqres.in/api/users")
			//Response
			.then()
			.log().all();
	}
}