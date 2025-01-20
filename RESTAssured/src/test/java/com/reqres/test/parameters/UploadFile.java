package com.reqres.test.parameters;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UploadFile {
	@Test
	public void uploadImage()
	{
		File image = new File("./src/test/resources/image/Viji.jpg");
		RestAssured.given()
		.multiPart(image)
		.pathParam("petId","9223372036854748538")
		.when()
		.post("https://petstore.swagger.io/v2/pet/{petId}/uploadImage")
		.then().log().all();
	}
}