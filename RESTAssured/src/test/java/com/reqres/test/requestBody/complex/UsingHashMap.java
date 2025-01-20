package com.reqres.test.requestBody.complex;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import restAssured.pojo.Category;
import restAssured.pojo.Tags;

public class UsingHashMap {
	@Test
	public void createPet()
	{
		ArrayList<String> photoUrls = new ArrayList();
		photoUrls.add("https://www.google.com/dogs");
		
		Category category = new Category(12,"Dog");
		 
		Tags tag1 = new Tags(10,"Yellow");
		ArrayList<Tags> tags = new ArrayList();
		tags.add(tag1);
		
		HashMap<String,Object> body = new HashMap();
		body.put("category",category);
		body.put("name","Sheerow");
		body.put("photoUrls",photoUrls);
		body.put("tags",tags);
		body.put("status","Available");
		
		RestAssured.given()
		.contentType(ContentType.JSON).body(body)
		.log().all()
		.when()
		.post("https://petstore.swagger.io/v2/pet")
		.then().log().all();
	}

}
