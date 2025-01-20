package com.reqres.test.authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Token {
	public String token;
	private int shopperId;
	@Test
	public void login()
	{
		Response response = given()
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "  \"email\": \"priyatharsan09990@gmail.com\",\r\n"
					+ "  \"password\": \"Priya@123\",\r\n"
					+ "  \"role\": \"SHOPPER\"\r\n"
					+ "}")
		.when()
			.post("https://www.shoppersstack.com/shopping/users/login");
		token = response.jsonPath().getString("data.jwtToken");
		shopperId = response.jsonPath().getInt("data.userId");
	}
	@Test(dependsOnMethods = "login")
	public void viewCart()
	{
		given()
			.header("Authorization","Bearer "+token)
			.pathParam("shopperId", shopperId)
		.when()
			.get("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/carts")
		.then().log().all();
	}

}
