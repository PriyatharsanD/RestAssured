package com.reqres.test.parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParam {
	@Test
	public void getUsers()
	{
		given()
			.queryParam("page","2").log().all()
			.queryParam("id","10")
		.when()
			.get("https://reqres.in/api/users")
		.then().log().all();
	}
}
