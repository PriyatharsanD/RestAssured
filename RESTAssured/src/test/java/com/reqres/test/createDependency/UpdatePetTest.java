package com.reqres.test.createDependency;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class UpdatePetTest {
	@Test
	public void updatePet() throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Pet.json");
		Properties properties = new Properties();
		properties.load(fis);
		given()
			.pathParam("petId",properties.getProperty("petId"))
			.formParam("name","Sheero")
			.formParam("status","Sold out")
		.when()
			.post("https://petstore.swagger.io/v2/pet/{petId}")
		.then().log().all();
	}

}
