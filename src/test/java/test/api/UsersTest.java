package test.api;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class UsersTest {
	
	Response response;
	@Test
	public void setup() {
		RestAssured.defaultParser = Parser.JSON;
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		response = RestAssured
			.given()
				.header("Content-Type",ContentType.JSON, "Accept", ContentType.JSON)
			.when()
				.get("/users")
			.then()
				.assertThat().statusCode(200)
				.and()
				.contentType(ContentType.JSON).extract().response();
	}
	
	@Test(dependsOnMethods = {"setup"})
	public void validateUsersLength(){
		List<String> usersList = response.jsonPath().getList("$");
		Assert.assertEquals(usersList.size(),10);
		
		/*
		response.jsonPath().getString("username");
		response.jsonPath().getString("username[0]");
		response.jsonPath().getList("username");
		response.jsonPath().getMap("company");
		response.jsonPath().getMap("company[0]");
		*/
	}

}
