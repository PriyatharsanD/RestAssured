package com.reqres.test.parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class FormParam {
	@Test
	public void updatePet()
	{
		RestAssured
			.given()
			.pathParam("petId","9223372036854748538")
			.formParam("name","Shimba")
			.formParam("status","Sold Out").log().all()
		.when()
			.post("http://petstore.swagger.io/v2/pet/{petId}")
		.then().log().all();
	}

}
