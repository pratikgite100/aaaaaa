import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PassJSONUsingPOJO {
   public static void main(String args[]) {
	   
	   User user= new User("pratikgite@gmail.com","pratik","gite", "A-108","kotul","Maharashtra","India");
	   user.setMobileNumbers(999999,888888);
	   
	   Response response=given().contentType(ContentType.JSON).body(user).log().all().post("https://reqbin.com/echo/post/json");
	   response.prettyPrint();
	   System.out.println(response.getStatusCode());
	   
	   
   }
}
