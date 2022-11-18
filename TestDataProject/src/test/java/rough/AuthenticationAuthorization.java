package rough;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthenticationAuthorization {
	
	@Test
	public void autherizationTest() {
		 
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		
		//Basic authentication
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");
		
		RestAssured.authentication = authScheme;
		
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/");
		
		//print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		
		
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println("StatusCode is: "+statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		
		//status line verification
		String statusLine = response.getStatusLine();
		System.out.println("StatusLine is: "+statusLine);
        
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}

}
