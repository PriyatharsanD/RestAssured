package com.reqres.test.requestBody.complex;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import restAssured.pojo.Category;
import restAssured.pojo.CreatePet;
import restAssured.pojo.Tags;

public class UsingPOJO {
	@Test
	public void createPet()
	{
		ArrayList<String> photoUrls = new ArrayList();
		photoUrls.add("http://google.com/dog");
		
		Tags tag1 = new Tags(123,"Yellow");
		ArrayList<Tags> tags = new ArrayList();
		tags.add(tag1);
		
		CreatePet body = new CreatePet(0,new Category(12,"Dog"),"Sheero",photoUrls,tags,"Available");
		RestAssured 
			.given()
			.contentType(ContentType.JSON)
			.body(body).log().all()
			.when()
			.post("https://petstore.swagger.io/v2/pet")
			.then()
			.log().all();
	}
}