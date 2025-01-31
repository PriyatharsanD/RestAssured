package com.reqres.test.requestBody.complex;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingJsonObject {
	@Test
	public void post()
	{
		JSONObject obj = new JSONObject();
		obj.put("name","Priya");
		obj.put("job","Auto Test Engineer");
	
		given()
		.contentType(ContentType.JSON)
		.body(obj)
		.when()
		.post("https://reqres.in/api/users")
		.then().log().all();
		
		
		
	}

}
