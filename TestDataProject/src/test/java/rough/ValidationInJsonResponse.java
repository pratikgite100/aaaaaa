package rough;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class ValidationInJsonResponse {
	
	//test status code
		@Test
		public void testStatusCode() {
			given()
			    
			.when()
			    .get("http://jsonplaceholder.typicode.com/posts/5")
			.then()
				.statusCode(200)
				.log().all();
				
		}
		
		//Log Response
		@Test
		public void testLogging() {
			given()
				
			.when()
				.get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
				.statusCode(200)
				.log().all();
			
		}
		
		//verifying single content in response body
		@Test
		public void testSingleContent() {
			
			given()
			
			.when()
				.get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
				.statusCode(200)
				.body("RestResponse.result.name", equalTo("India"));	
			
			
		}
		
		
		
		//verifying Multiple content in response body
			@Test
			public void testMultipleContent() {
				
				given()
				
				.when()
					.get("http://services.groupkt.com/country/get/all")
				.then()
					.statusCode(200)
					.body("RestResponse.result.name", hasItems("India", "Austreliya", "United State of America"));	
				
				
			}
		
		
			//Setting parameters and headers
			@Test
			public void testParamsAndHeaders() {
				
				given()
				  .param("MyName", "pavan")
				  .header("MyHeader","Indian")
				.when()
					.get("http://services.groupkt.com/country/get/iso2code/IN")
				.then()
					.statusCode(200) 
					.log().all();	
				
				
			}

}
