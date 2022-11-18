import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetName {
	
	@Test
	public void get() {
		
		RestAssured.baseURI = "https://randomuser.me/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/api/");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		String title = jsonPathEvaluator.get("results[0].name.title");
		System.out.println("title: " + title);
		
		String firstName = jsonPathEvaluator.get("results[0].name.first");
		System.out.println("firstName: " + firstName);
		
		String lastName = jsonPathEvaluator.get("results[0].name.last");
		System.out.println("lastName: " + lastName);
		
	}

}
