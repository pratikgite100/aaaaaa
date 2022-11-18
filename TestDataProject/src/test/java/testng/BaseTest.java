package testng;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matcher.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import rough.GetRunMode;
import rough.ReadingExcelData;
import rough.SeleniumBegins;
import utilities.RestUtils;
import utilities.TestParameterization;


public class BaseTest {
	
	public static HashMap map = new HashMap();
	
	
	public void postData() {
		
		map.put("FirstName", RestUtils.getFirstName());
		map.put("LastName", RestUtils.getLastName());
		map.put("UserName", RestUtils.getUserName());
		map.put("Password", RestUtils.getPassword());
		map.put("Email", RestUtils.getEmail());
		//map.put("", RestUtils.getFirstName());
		
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RestAssured.basePath = "/register";
		
	}
	
	
	public void testPost() {
		given()
		  .contentType("application/json")
		  .body(map)
		  
		.when()
		  .post()
		  
		.then()
		  .statusCode(201);
		  //.and()
		 // .body("SuccessCode", equalTo("OPERATION_SUCCESS"))
		  //.and()
		  //.body("Message", equalTo("Operation completed successfully"));
	}
	
	
	@BeforeSuite
	public void setUp(){
		System.out.println("This method execute before test suite");
		System.out.println("");
		System.out.println("");
	
		
	}
	

	
	@BeforeTest
	public void beforeT() {
		System.out.println("This method execute before test case");
		System.out.println("");
		System.out.println("");
		
		
		
		
	}
	
	/*@Test(invocationCount =2)
	public void getRunMode() {
		List arr=GetRunMode.readexcelData();
		
		TestCases t=new TestCases("q","q",arr);
		
		
		
		System.out.println("Testcases having RunMode Y ");
		System.out.println(arr);
		System.out.println("******"+t.getArrr()+"***************");
		
		for(int i=0;i<arr.size();i++) {
			ReadingExcelData.readexcelData((String) arr.get(i));
		}
		
		
	}
	
	*/
	
	
	@Test
	public void listOfDatahavingRunmodeY() {
		HashMap<String, String> rowTestDataMap = GetRunMode.readexcelData();
		System.out.println("");
		
		for(Entry<String, String> entry:rowTestDataMap.entrySet()) {
			if(entry.getValue().equals("Y")) {
				System.out.println("===="+entry.getKey()+"======="+entry.getValue()+"====");
				
			    // ReadingExcelData.readexcelData(entry.getKey());
			}    
			System.out.println("");
	    }
	}
	
	@Test
	public void readDataTest() {
		System.out.println("");
		System.out.println("");
		
		Map<String,String> rowTestDataMap = GetRunMode.readexcelData();
		System.out.println("");
		
		int i=1;
		for(Entry<String, String> entry:rowTestDataMap.entrySet()) {
			Map<String,HashMap<String, String>> eachRowDataMap = ReadingExcelData.readexcelData(entry.getKey());
			
			for(Entry<String, HashMap<String, String>> entry1:eachRowDataMap.entrySet()) {
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				System.out.println("loop of "+i+" row of master excel file for manupulation");
			    System.out.println("key of row "+i+" "+entry1.getKey()+"  Value of row "+i+" "+entry1.getValue());
			    System.out.println("");
			    i++;
			    
			    
			}    
		
		//ReadingExcelData.readexcelData("LoginCustomer");
		
		}
	}
	
	
	@Test()
	public void validateSubTotal() throws IOException {
		System.out.println("");
		System.out.println("");
		SeleniumBegins.validateSubTotal();
	}
	
	
	
	
	@Test(dataProviderClass=TestParameterization.class, dataProvider = "getData")
	public void testData(Hashtable<String,String> data) {
		System.out.println("");
		System.out.println("");
		System.out.println(data.get("id")+"----"+data.get("customer")+"----"+data.get("quantity")+"----"+data.get("price"));
		
	}
	
	
	
	
	@AfterTest
	public void afterSuite() {
		System.out.println("");
		System.out.println("This method execute after test case");
		System.out.println("");
	}
	

	
	@AfterSuite
	public void tearDown() {
		System.out.println("");
		System.out.println("This method execute after test suite");
		System.out.println("");
	}

}