package com.reqres.test.crud;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ReadUserTest {
	@Test
	public void getUserTest()
	{
		//Pre-Condition
		RestAssured.given()
		//Http Method
			.when()
			.get("https://reqres.in/api/users/2")
		//Response
			.then().log().all();
	}

}
