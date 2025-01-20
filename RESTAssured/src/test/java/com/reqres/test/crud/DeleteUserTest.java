package com.reqres.test.crud;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUserTest {
	@Test
	public void delete()
	{
		given()
		.when()
		.delete("https://reqres.in/api/users/2")
		.then().log().all();
	}

}
