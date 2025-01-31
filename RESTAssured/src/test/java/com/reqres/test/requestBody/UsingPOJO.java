package com.reqres.test.requestBody;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import restAssured.pojo.User;

public class UsingPOJO {
	@Test
	public void createUser()
	{
		User body = new User("Priya","Automation Test Engineer");
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(body).log().all()
		.when().post("https://reqres.in/api/users")
		.then().log().all();
	}
}