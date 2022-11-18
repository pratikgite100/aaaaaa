import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ExtractFieldValuesFromResponse {

		@Test
		public static void get() {
		HashMap<String,String> map =new HashMap<String,String>();
		map.put("email", "pratikgite100@gmail.com");
		map.put("password","pass@123");
		
		Response response = given().
				contentType(ContentType.JSON).
				get("https://randomuser.me/api/");
		//response.prettyPrint();
		
		
		JsonPath json =response.jsonPath();
		
		System.out.println("Gender: "+json.get("results[0].gender"));
		System.out.println("Name: ");
		System.out.println("  title: "+json.get("results[0].name.title"));
		System.out.println("  FirstName: "+json.get("results[0].name.first"));
		System.out.println("  LastName: "+json.get("results[0].name.last"));
		System.out.println("Location: ");
		System.out.println("  Streetnumber: "+json.get("results[0].location.street.number"));
		System.out.println("  StreetName: "+json.get("results[0].location.street.name"));
		System.out.println("  city: "+json.get("results[0].location.city"));
		System.out.println("  state: "+json.get("results[0].location.state"));
		System.out.println("  country: "+json.get("results[0].location.country"));
		System.out.println("  postcode: "+json.get("results[0].location.postcode"));
		System.out.println("coordinate: ");
		System.out.println("  latitute: "+json.get("results[0].location.coordinate.latitude"));
		System.out.println("  longitute: "+json.get("results[0].location.coordinate.longitute"));
		System.out.println("timezone");
		System.out.println("  offset: "+json.get("results[0].location.timezone.offset"));
		System.out.println("  description: "+json.get("results[0].location.timezone.description"));
		System.out.println("email: "+json.get("results[0].email"));
		System.out.println("Login");
		System.out.println("  uuid: "+json.get("results[0].login.uuid"));
		System.out.println("  username: "+json.get("results[0].login.username"));
		System.out.println("  password: "+json.get("results[0].login.password"));
		System.out.println("  salt: "+json.get("results[0].login.salt"));
		System.out.println("  md5: "+json.get("results[0].login.md5"));
		System.out.println("  sha1: "+json.get("results[0].login.sha1"));
		System.out.println("  sha256: "+json.get("results[0].login.sha256"));
		System.out.println("dob");
		System.out.println("  date: "+json.get("results[0].dob.date"));
		System.out.println("  age: "+json.get("results[0].dob.age"));
		System.out.println("registered");
		System.out.println("  date: "+json.get("results[0].registered.date"));
		System.out.println("  registered age: "+json.get("results[0].registered.age"));
		System.out.println("phone: "+json.get("results[0].phone"));
		System.out.println("cell: "+json.get("results[0].cell"));
		System.out.println("id");
		System.out.println("  name: "+json.get("results[0].id.name"));
		System.out.println("  value: "+json.get("results[0].id.value"));
		System.out.println("picture");
		System.out.println("  large: "+json.get("results[0].picture.large"));
		System.out.println("  medium: "+json.get("results[0].picture.medium"));
		System.out.println("  thumbnail: "+json.get("results[0].picture.thumbnail"));
		System.out.println("nat: "+json.get("results[0].nat"));
		
		System.out.println("Info");
		System.out.println("  seed: "+json.get("info.seed"));
		System.out.println("  results: "+json.get("info.results"));
		System.out.println("  page: "+json.get("info.page"));
		System.out.println("  version: "+json.get("info.version"));
		
	   //System.out.println("elements in whole json: "+json.getMap("$"));
	   System.out.println("Number of elements in whole json: "+json.getMap("$").size());
	   System.out.println("Number of elements in results array: "+json.getMap("results[0]").size());
	   System.out.println("Number of elements in name: "+json.getMap("results[0].name").size());
	   System.out.println("         elements in name: "+json.getMap("results[0].name"));
	   System.out.println("Number of elements in info: "+json.getMap("info").size());
		
		
		
		
		
		

}
		public static void main (String args[]) {
			get();
		}

}
