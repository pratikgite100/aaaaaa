package validate;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class validateStatusCode {
	
	public static HashMap<String,String> SetHash(String...pairs) {
	     HashMap<String,String> rtn = new HashMap<String,String>(pairs.length/2);
	     for ( int n=0; n < pairs.length; n+=2 ) rtn.put(pairs[n], pairs[n + 1]);
	    return rtn; 
	  }
	
	@Test
	public void validate() {
		HashMap<String,String> hm = SetHash( "Content-Type","application/json", "Accept","application/json");
		Response response = given().contentType(ContentType.JSON).headers(hm).body(new File("./users.json")).post("https://reqbin.com/echo/post/json");
		response.prettyPrint();
		System.out.println("Status code = "+response.getStatusCode());
		
		System.out.println("___________________________________________________________________________________");
		
		
			
		String jsonResponse=response.asString();
		
		
		
	}

}
