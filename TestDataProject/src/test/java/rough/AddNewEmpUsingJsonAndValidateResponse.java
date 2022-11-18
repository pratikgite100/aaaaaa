package rough;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ExcelReader;

public class AddNewEmpUsingJsonAndValidateResponse {
	
	@Test(dataProvider = "empdataprovider")
	public void postNewEmployeeAndValidateResp(String ename, String esalary, String eage)  {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", ename);
		requestParams.put("salary", esalary);
		requestParams.put("age", eage);
		
		
		//add a header stating the request body is a JSON
		httpRequest.header("Content-Type", "application/json");
		
		
		//Add the json to the body of therequest
		httpRequest.body(requestParams.toJSONString());
		
		//POST Request
		Response response = httpRequest.request("Method.POST","/create");
		
		
		//capture response body to perform validation
		String responseBody = response.getBody().asString();
		
		
		
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esalary), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@DataProvider(name = "empdataprovider")
	String[][] getEmpData(){
		
		//String empdata[][] = {{"abc123","30000","40"},{"xyz123","40000","30"},{"pqr123", "80000", "50"}};
		
		ExcelReader excel = new ExcelReader("C:\\Users\\141572\\eclipse-workspace\\RestAssured\\TestDataProject\\src\\test\\resources\\testdata\\TestSuiteData4.xlsx");
		
		int rownum = excel.getRowCount("Sheet1");
		int colcount = excel.getColumnCount("Sheet1");
		
	
		String empData[][] = new String[rownum][colcount];
		
		for(int i=1;i<rownum;i++) {
			for(int j=0;j<colcount;j++) {
				empData[i-1][j] = excel.getCellData("Sheet1",j,i);
			}
		}
		
		return empData;
	}

}
