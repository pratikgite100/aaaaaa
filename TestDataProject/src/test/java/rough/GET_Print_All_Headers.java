package rough;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import io.netty.handler.codec.Headers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Print_All_Headers {
	
	public void getWeathersDetails() {
		
		RestAssured.baseURI = "https://maps.googleapis.com";
	
		
		//request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//response object
		Response response = httpRequest.request("/maps/api/place/nearbysearch/xml?location=knjj");
		
		//print response in console window
		String responsebody = response.getBody().asString();
		System.out.println("Response ody is: "+responsebody);
		
		
		Headers allHeaders =  (Headers) response.headers(); //capture all headers from response\
		
		for(Headers header:allHeaders)
		{
			System.out.println(header.getName()+"        "+header.getValue());
		}
		
		
		
		//Validating JSON Response
		/*
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 
		  RequestSpecification httpRequest = RestAssured.given();
		  
		  Response response = httpRequest.request(Method.GET, "/Delhi");
		  
		  String responseBody = response.getBody().asString();
		  System.out.println("Response Body is: "+responseBody);
		  
		  Assert.assertEquals(responseBody.contains("Delhi"), true);
		  
		  */
			
		
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
