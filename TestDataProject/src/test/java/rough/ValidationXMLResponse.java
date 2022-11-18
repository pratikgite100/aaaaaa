package rough;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasXPath;

public class ValidationXMLResponse {
	
	//verifying single content in XML response
	@Test(priority = 1)
	public void testSingleContent() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
		    .log().all();
	}

	
	//verifying multiple content in XML Response
	@Test(priority = 2)
	public void testMultipleContents() {
		
		given()
		
		.when()
		    .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		  .body("CUSTOMER.ID", equalTo("15"))
		  .body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
		  .body("CUSTOMER.LASTNAME", equalTo("Clancy"))
		  .body("CUSTOMER.STREET", equalTo("319 Upland pl."))
		  .body("CUSTOMER.CITY", equalTo("Seattle"));
		  
	}
	
	
	//verifying all the content in XML Response in one go
	@Test(priority = 3)
	public void testMultipleContentInOneGo() {
		
		given()
		
		.when()
		   .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		   .body("CUSTOMER.text()", equalTo("15BillClancy319 Upland pl.Seattle"));
	}
	
	
	
	//find values using XML Path in XML response
	@Test(priority = 4)
	public void testUsingXPath1() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME", equalTo("Bill")));
	}
	
	
	//validating 30 is present in XML Response
	@Test(priority = 5)
	public void testUningXPath2() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text() = '30']"));
	}
	
}
