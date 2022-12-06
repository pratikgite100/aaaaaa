package testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class printAllHeaders {
	
	@Test
	public void getWeathersDetails() {
		
		
	
		
		//request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//response object
		Response response = httpRequest.request("http://localhost:8080/getcountries");
		
		//print response in console window
		String responsebody = response.getBody().asString();
		System.out.println("Response body is: "+responsebody);
		
		
		Headers allHeaders = response.headers(); 
		 // Iterate over all the Headers 
		 for(Object header : allHeaders) { 
		   System.out.println("Key: " + ( (Header) header).getName() + " Value: " + ((Header) header).getValue()); 
		 }
		
		
		//Validating JSON Response
		
		/*  
		  String responseBody = response.getBody().asString();
		  System.out.println("Response Body is: "+responseBody);
		 */ 
		//  Assert.assertEquals(responseBody.contains("Delhi"), true);
		  
		
			
		
		//extract values of each node
		/*
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 
		  RequestSpecification httpRequest = RestAssured.given();
		  
		  JsonPath jsonPath = response.jsonPath();
		  
		  System.out.println(jsonPath.get("CIty"));
		  System.out.println(jsonPath.get("Temperature"));
		  System.out.println(jsonPath.get("Humidity"));
		  System.out.println(jsonPath.get("WeatherDescription"));
		  System.out.println(jsonPath.get("WindSpeed"));
		  System.out.println(jsonPath.get("WindDirectionDegree"));
		  
		  Assert.assertEquals(jsonPath.get("Temperature"),"39 Degree celsius");
		  
		  
		 
		 
		 
		 
		 
		 */
		
		
	}

	}
