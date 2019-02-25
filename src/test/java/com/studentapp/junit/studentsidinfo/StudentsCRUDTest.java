package com.studentapp.junit.studentsidinfo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class StudentsCRUDTest extends TestBase {
	
	static String firstname = "smokeuser";
	static String lastname = "smokeuser";
	static String program = "CS";
	static String email = "xyz@gmail.com";

	@Title("This test will create a new student")
	@Test
	public void createStudent() {
		StudentClass student = new StudentClass();
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");

		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setEmail(email);
		student.setProgram(program);
		student.setCourses(courses);
		
		SerenityRest.given()
		.contentType(ContentType.JSON)
		.log().all()
		.when()
		.body(student)
		.post()
		.then()
		.log()
		.all()
		.statusCode(201);
	}
}
