package testcases;


import static io.restassured.RestAssured.given;

import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

/* 
 * when()
 * 		get, put, post, delete
 * 
 * then()
 *  validate status code, extract response, extract response, extract headers cookies & response body.....
 * 
 * 
 */


public class Demo1_GET_Requests {
	
	@Test
	public void getWeatherDetails() {
		given()
		.when()
			.get("http://localhost:8080/getcountries")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("countryName", equalTo("India"))
			.header("Content-Type","application/json");
			
	}

}
