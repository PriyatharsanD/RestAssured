package com.reqres.test.crud;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateUserTest {
	@Test
	public void updateUser()
	{
		given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"name\": \"Ajay\",\r\n"
				+ "    \"job\": \"Tailor\"\r\n"
				+ "}")
		.log().all()
		.when()
		.put("https://reqres.in/api/users/2")
		.then().log().all();
	}

}
