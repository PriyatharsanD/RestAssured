package com.reqres.test.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParam {
	@Test
	public void getPet()
	{
		given()
			.pathParam("petId","9223372036854745599").log().all()
			.param("orderId","134423")
		.when()
			.get("http://petstore.swagger.io/v2/pet/{petId}")
		.then().log().all();
	}
}
