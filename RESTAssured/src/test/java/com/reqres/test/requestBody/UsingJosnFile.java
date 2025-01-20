package com.reqres.test.requestBody;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UsingJosnFile {
	@Test
	public void createUser()
	{
		File body = new File("./src/test/resources/responseBody.json");
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(body).log().all()
		.when().post("https://reqres.in/api/users")
		.then().log().all();
	}

}
