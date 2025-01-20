package com.reqres.test.requestBody;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UsingHashMap {
	@Test
	public void createUser()
	{
		HashMap<String,String> body = new HashMap();
		body.put("name","Priya");
		body.put("job","Automation Test Engineer");
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(body)
		.when().post("https://reqres.in/api/users")
		.then().log().all();
	}

}
