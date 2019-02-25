package com.studentapp.cucumber.serenity;

import java.util.ArrayList;
import java.util.List;

import com.studentapp.model.StudentClass;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

public class StudentSerenitySteps {

	public ValidatableResponse reusableMethod(String firstname,
			String lastname, String email, String program, List<String> courses) {
		
		StudentClass student = new StudentClass();
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setEmail(email);
		student.setProgram(program);
		student.setCourses((ArrayList<String>) courses);
		
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
