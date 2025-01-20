package com.reqres.test.responseValidation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class CaptureResponse {
	@Test
	public void captureResponse()
	{
		Response response = given()
				.queryParam("page","2").log().all()
				.when()
				.get("https://reqres.in/api/users");
		//fetch user data
		List l = response.jsonPath().get("data");
		//Fetch user email from response
		String email=null;
		for(int i=0;i<l.size();i++)
		{
			if(response.jsonPath().get("data["+i+"].first_name").equals("Tobias"))
			{
				email=response.jsonPath().getString("data["+i+"].email");
				break;
			}
		}
		System.out.println(email);
		
		//Validate in traditional way
		response
			.then().assertThat()
				.statusCode(200)
				.statusLine(Matchers.containsStringIgnoringCase("OK"));
		
		//Validate using testNG
		int statusCode=response.getStatusCode();
		String server=response.getHeader("Server");
		ResponseBody resBody=response.getBody();
		int id=resBody.jsonPath().getInt("data[0].id");
		
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(server,"cloudflare");
		Assert.assertEquals(id,7);
	}

}
