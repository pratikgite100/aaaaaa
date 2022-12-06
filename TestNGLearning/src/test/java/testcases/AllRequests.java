package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.RestUtils;

public class AllRequests {
	
	public static HashMap map = new HashMap();
	
	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	int emp_id = 11254;
	
	
	@BeforeClass
	public void putData() {
		
		map.put("name", empName);
		map.put("salary", empSalary);
		map.put("age", empAge);
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/update/"+emp_id;
	}
	
	
	@Test
	public void testPost() {
		
		given()
			.contentType("application/json")
			.body(map)
	    .when()	
	    	.post()
	    .then()
	    	.statusCode(201)
	    	.body("SuccessCode",equalTo("OPEARATION_SUCCESS"))
	    	.and()
	    	.body("Message", equalTo("Operation completed successfully"));
	}
	
	@Test
	public void testPUT() {
		
		given()
		  .contentType("application/json")
		  .body(map)
		
		.when()
		  .put()
		  
		.then()
		  .statusCode(200);
	}
	
	
	@Test
	public void deleteEmployeeRecord() {
		
		RestAssured.baseURI = "http://localhost:8080/getcountries";
		//RestAssured.basePath = "/delete/"+emp_id;
		
		
		Response response = 
		given()
		
		.when()
			.delete()
		.then()
		    .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		.log().all()
		.extract().response();
		
		String jsonAsString = response.asString();
		
		Assert.assertEquals(jsonAsString.contains("successfully! deleted records"), true);
		
	}
	
	
	
	
	
	

}
