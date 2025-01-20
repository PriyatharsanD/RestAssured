package com.reqres.test.crud;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUserTest {
	@Test
	public void create() {
		//Pre-Condition
		RestAssured.given()
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "    \"name\": \"Priyatharsan\",\r\n"
					+ "    \"job\": \"Software Test Engineer\"\r\n"
					+ "}")
		
		//http-Method
		.when()
			.post("https://reqres.in/api/users")
		//Response
		.then().log().all();
	}

}
