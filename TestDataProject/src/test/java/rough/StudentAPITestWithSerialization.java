package rough;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class StudentAPITestWithSerialization {
	
	
	@Test(priority =1)
	public void createStudentSerialization() {
		
		ArrayList<String> coursesList = new ArrayList<String>();
		
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		
		Student stu = new Student();
		
		stu.setId(101);
		stu.setFirstName("John");
		stu.setLastName("Deo");
		stu.setEmail("abc@gmail.com");
		stu.setProgramme("Computer Science");
		stu.setCourses(coursesList);
		
		
		
		given()
			.contentType(ContentType.JSON)
			.body(stu)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.assertThat().body("msg", equalTo("Student Added"));
		
	}
	
	
	@Test(priority = 2)
	public void getStudentRecordDeSerilization() {
		
		//Student stu = new Student();
		//Student stu = get("http://localhost:8085/student/101").as(Student.class);
		System.out.println(stu.getStudentRecord());
		//Assert.assertEquals(stu.getId(), 101);
	}

}
