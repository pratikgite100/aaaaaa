package rough;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Orders;
import pojo.PurchaseUnits;


public class TestPayPal {
	static String access_token;
	static String client_id = "AVNzxBnbs8Lcs1ZZmdUW2-nmjnKh5qk36tlRCmT2YXn7nTHqzDvBXR8BBEP_rYLFMGgdwfeOaT2yXQum";
	static String secret="EIGDp38-02a1mfZYFfM2BzXbjMKGdupopOK6jko_cT--u1nEnQdg5JQHFO_sG77Pp4LKh6XxTjrFBOiR";
	static String orderId;
	
	
	@Test(priority = 1)
	public void getAuthKey() {
		//RestAssured.baseURI = "https://api.sandbox.paypal.com";
		
		Response response = given().param("grant_type","client_credentials")
				.auth().preemptive()
				.basic(client_id,secret).post("https://api.sandbox.paypal.com/v1/oauth2/token");
		
		System.out.println("---------------------response-----------------------------");
		response.prettyPrint();
		
		access_token= response.jsonPath().get("access_token").toString();
		
		System.out.println("");
	    System.out.println("");
	    
		System.out.println("---------------------Getting access token from response-----------------------------");
		System.out.println("access token is:  "+access_token);
		
		System.out.println("");
	    System.out.println("");
		
	}
	
	
	@Test(priority = 2 , dependsOnMethods = "getAuthKey")
	public void createOrder() {
		
		System.out.println("---------------------Create Order using access token-----------------------------");
		
		System.out.println("");
		
		ArrayList<PurchaseUnits> list= new ArrayList<PurchaseUnits>();		
		list.add(new PurchaseUnits("USD", "500.00"));
		
		Orders order = new Orders("CAPTURE",list);
		
		/*
		String jsonBody= "{\r\n"
				+ "    \"inet\" : \"CAPTURE\",\r\n"
				+ "    \"purchase_units\" : [\r\n"
				+ "        {\r\n"
				+ "        \"amount\" : {\r\n"
				+ "            \"currency_code\" : \"USD\",\r\n"
				+ "            \"value\" : \"150.00\"\r\n"
				+ "        }\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
		*/
		
		Response response1 = given()
				.contentType(ContentType.JSON)
				.auth().oauth2(access_token)
				.body(order)
				.post("https://api.sandbox.paypal.com/v2/checkout/orders");
		
		
		System.out.println("Status: "+response1.statusCode());
		System.out.println("eeee: "+response1.jsonPath().get("status"));
		
		System.out.println("");
	    System.out.println("");
		
	    System.out.println("---------------------Printing response after creating order-----------------------------");
		System.out.println("");
		
	    response1.prettyPrint();
		
	    System.out.println("");
	    
		
		
		orderId = response1.jsonPath().get("id").toString();
		Assert.assertEquals(response1.jsonPath().get("status").toString(), "CREATED");
		
	}
	
	@Test(priority = 3 , dependsOnMethods = {"getAuthKey","createOrder"})
	public void getOrder() {
		
	    System.out.println("---------------------Getting The Order using access token-----------------------------");
		
	    System.out.println("");
		
		Response response1 = given()
				.contentType(ContentType.JSON)
				.auth().oauth2(access_token)
				.get("https://api.sandbox.paypal.com/v2/checkout/orders/"+orderId);
		
		
		response1.prettyPrint();
	
	} 
	
	
	public static void main(String[] args) {
		
	}
	

}
