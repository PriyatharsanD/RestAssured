package com.reqres.test.createDependency;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadPetTest {
	@Test
	public void readPet() throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Pet.json");
		Properties properties = new Properties();
		properties.load(fis);
		given()
			.pathParam("petId",properties.get("petId"))
		.when()
			.get("https://petstore.swagger.io/v2/pet/{petId}")
		.then().log().all();
	}

}
