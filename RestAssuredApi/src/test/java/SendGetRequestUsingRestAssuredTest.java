

import static io.restassured.RestAssured.given;

import java.util.Arrays;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class SendGetRequestUsingRestAssuredTest {
	
	
		
			
		     @Test
			public void get() {
				
				Response response=given()
				.header("Content-Type","Application/Json")
				.get("https://randomuser.me/api/");
				
				//response.prettyPrint();
				String jsonResponse=response.asString();
				//System.out.println(jsonResponse);
				//System.out.println(jsonResponse.substring(46,50));
				//System.out.println(jsonResponse.substring(60,72));
				//System.out.println(jsonResponse.substring(82,87));
				
				String[] sentences = jsonResponse.split("\\.");  
				//System.out.println(Arrays.toString(sentences));  
				
				System.out.println("Response code --> "+response.statusCode());
				
				String name=sentences[0];
				
				//System.out.println(name.toString());
				String name1=sentences[5];
				//System.out.println(name.toString());
				
				System.out.println("____________________________________________________________________________");
				System.out.println();
				System.out.print("        Name is : ");
				int id=jsonResponse.indexOf("M", 42);
				int idend=jsonResponse.indexOf("\"", id);
				System.out.print(" "+jsonResponse.substring(id,idend));
				
				int firstNameStart=jsonResponse.indexOf("t", 51);
				int firstNameEnd=jsonResponse.indexOf("\"", firstNameStart+4);
				System.out.print(" "+jsonResponse.substring(firstNameStart+4,firstNameEnd));
				
				int lastNameStart=jsonResponse.indexOf("t", 66);
				int lastNameEnd=jsonResponse.indexOf("\"", lastNameStart+4);
				System.out.println(" "+jsonResponse.substring(lastNameStart+4,lastNameEnd));
				
				System.out.println("____________________________________________________________________________");
				
				
				//given().contentType(ContentType.JSON);
				//given().contentType("Application/Json");
				//given().header("content-type","application/json");
			}
		
	
}
