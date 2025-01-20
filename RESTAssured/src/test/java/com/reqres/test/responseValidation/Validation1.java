package com.reqres.test.responseValidation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Validation1 {
	@Test
	public void validateTest()
	{
		given()
			.pathParam("petId","9223372036854775072")
			.when().log().all()
				.get("https://petstore.swagger.io/v2/pet/{petId}")
			.then()
				.assertThat()
					.statusCode(200)
					.statusLine(Matchers.containsString("OK"))
					.time(Matchers.lessThanOrEqualTo(5000L))
					.header("Server",Matchers.containsString("Jetty"))
					.body("name",Matchers.equalToIgnoringCase("Sheerow"))
					.body("tags[0].id",Matchers.equalTo(10));
	}
}