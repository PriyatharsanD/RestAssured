package com.reqres.test.createDependency;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CRUD {
	public long petId;
	@Test
	public void createPet()
	{
		File pet = new File("./src/test/resources/createPet.json");
		Response responseBody = given()
			.contentType(ContentType.JSON)
			.body(pet)
		.when()
			.post("https://petstore.swagger.io/v2/pet");
		responseBody.then().log().all();
		petId=responseBody.jsonPath().getLong("id");
	}
	@Test(dependsOnMethods="createPet")
	public void updatePet()
	{
		given()
			.pathParam("petId",petId)
			.formParam("name","Sheero")
			.formParam("status","Sold out")
		.when()
			.post("https://petstore.swagger.io/v2/pet/{petId}")
		.then().log().all();
	}
	@Test(dependsOnMethods="updatePet")
	public void readPet()
	{
		given()
			.pathParam("petId",petId)
		.when()
			.get("https://petstore.swagger.io/v2/pet/{petId}")
		.then().log().all();
	}
	@Test(dependsOnMethods="readPet")
	public void deletePet()
	{
		given()
			.pathParam("petId",petId)
		.when()
			.delete("https://petstore.swagger.io/v2/pet/{petId}")
		.then()
			.assertThat()
				.statusCode(200)
				.statusLine(Matchers.containsString("OK"));
	}

}
