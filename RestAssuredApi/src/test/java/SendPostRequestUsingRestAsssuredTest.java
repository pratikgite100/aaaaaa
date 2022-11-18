import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SendPostRequestUsingRestAsssuredTest {
	
	@Test
	public void get() {
		
		Response response=given()
		.header("Content-Type","Application/Json")
		.get("https://randomuser.me/api/");
	
		response.prettyPrint();
	}	
	
	@Test
	public void post() {
		HashMap<String,String> map =new HashMap<String,String>();
		map.put("email", "pratikgite100@gmail.com");
		map.put("password","pass@123");
		
		//method1
		Response response0 = given().contentType(ContentType.JSON).body(map).post("https://randomuser.me/api/");
		response0.prettyPrint();
		
		//method2
		Response response1 = given().contentType(ContentType.JSON).body(new File("users.JSON")).post("https://randomuser.me/api/");
		response1.prettyPrint();
		
		//method3
		String bodyString = "{\"email\":\"pratikgite@gmail.com\", \"passward\": \"Pass@123\"}";
		Response response2 = given().contentType(ContentType.JSON).body(bodyString).post("https://randomuser.me/api/");
		response2.prettyPrint();
		
		//method4
		Response response3= given()
				.formParam("email","pratikgite@gmail.com")
				.formParam("password","pass@123")
				.formParam("Description", "This is a new post request ")
				.post("https://randomuser.me/api/");
		response3.prettyPrint();
		
	}

}
