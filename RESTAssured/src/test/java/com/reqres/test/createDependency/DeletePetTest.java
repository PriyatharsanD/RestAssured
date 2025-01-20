package com.reqres.test.createDependency;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class DeletePetTest {
	@Test
	public void deletePet() throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Pet.json");
		Properties properties = new Properties();
		properties.load(fis);
		given()
			.pathParam("petId",properties.getProperty("petId"))
		.when()
			.delete("https://petstore.swagger.io/v2/pet/{petId}")
		.then()
			.assertThat()
				.statusCode(200)
				.statusLine(Matchers.containsString("OK"));
	}
}
