



import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIs.CreateCustomerApi;
import io.restassured.response.Response;
import listeners.ExtentListeners;
import setUp.BaseTest;

public class CreateCustomerTest extends BaseTest {
	
	@Test(dataProviderClass= DataUtil.class, dataProvider="data")
	public void validateCreateCustomerApi(Hashtable <String,String> data) {
		
		Response response = CreateCustomerApi.sendPostRequestToCreateCustomerApi(data);
		
		ExtentListeners.testReport.get().info(data.toString());
		
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		//Assert.assertEquals(response.statusCode(), 200);
		
		//CreateCustomerApi.sendPostRequestToCreateCustomerApi(data);
		System.out.println("Id"+ data.get("id"));
		System.out.println("customer"+ data.get("customer"));
		System.out.println("quantity"+ data.get("quantity"));
		System.out.println("price"+ data.get("price"));
		Assert.assertEquals(data.get("id"), 101);
		
	}
	
	
   
   

}
