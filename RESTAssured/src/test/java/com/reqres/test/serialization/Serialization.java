package com.reqres.test.serialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import restAssured.pojo.Category;
import restAssured.pojo.CreatePet;
import restAssured.pojo.Tags;

public class Serialization {
	@Test
	public void test()
	{
		ArrayList<String> photoUrls = new ArrayList<String>();
		photoUrls.add("www.photo.com");
		
		ArrayList<Tags> tag1 = new ArrayList<Tags>();
		tag1.add(new Tags(12,"Brown"));
		
		CreatePet createPet = new CreatePet(0,new Category(10,"Dog"),"Sheerow",photoUrls,tag1,"Available");
		CreatePet pet = given()
			.contentType(ContentType.JSON)
			.body(createPet)
		.when()
			.post("https://petstore.swagger.io/v2/pet")
		.then()
			.extract().as(CreatePet.class);
		
		System.out.println(pet.getId());
		System.out.println(pet.getName());
		System.out.println(pet.getCategory().getName());
		System.out.println(pet.getTags().get(0).getName());
	}

}
