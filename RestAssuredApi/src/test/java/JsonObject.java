import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonObject {
	
	@Test
	public void useOfJsonObject() {
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("email","pratikgite@gmail.com");
	jsonObject.put("firstName","pratik");
	jsonObject.put("lastName","gite");
	
	
	JSONArray listOfMobiles = new JSONArray();
	listOfMobiles.put(999999999);
	listOfMobiles.put(1111111);
	
	jsonObject.put("Mobile", "listOfMobiles");
	
	
	JSONObject address=new JSONObject();
	address.put("flat number", "A-103");
	address.put("city", "kotul");
	address.put("state", "maharashtra");
	address.put("ccountry", "India");
	
	jsonObject.put("Addresses", "address");
	
	Response response=given().contentType(ContentType.JSON).body(jsonObject.toString()).log().all().post("https://reqbin.com/echo/post/json");
	response.prettyPrint();
	System.out.println(response.getStatusCode());
	
	}
}
