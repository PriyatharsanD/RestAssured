package com.reqres.test.createDependency;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreatePetTest {
	@Test
	public void createPet() throws IOException
	{
		File pet = new File("./src/test/resources/createPet.json");
		Response responseBody = given()
			.contentType(ContentType.JSON)
			.body(pet)
		.when()
			.post("https://petstore.swagger.io/v2/pet");
		responseBody.then().log().all();
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Pet.json");
		Properties properties = new Properties();
		properties.setProperty("petId",""+responseBody.jsonPath().getLong("id"));
		properties.store(fos,"Pet id is created");
	}

}
