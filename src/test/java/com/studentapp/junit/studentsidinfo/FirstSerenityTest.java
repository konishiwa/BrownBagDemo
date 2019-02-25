package com.studentapp.junit.studentsidinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {
	
	/**
	 * intialization 
	 */
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost:8080/student";
	}

	/**
	 * REST Assured Test
	 */
	@Title("This test will get the information of all students from the Student App")
	@Test
	public void getAllStudents() {
		//RestAssured.given()
		//wrapper ontop of the rest assured methods 
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	
	/**
	 * Test fails 
	 */
	@Test
	public void thisIsAFailingTest() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(500);
	}
	
	@Pending
	@Test
	public void thisIsAPendingTest() {
		
	}
	
	@Ignore
	@Test
	public void thisIsAnIgnoredTest() {
		
	}
	
	@Test
	public void thisIsATestWithError() {
		System.out.println("This is an error" + (5/0));
	}
	
	@Test
	public void fileDoesNotExist() throws FileNotFoundException {
		File file = new File("E://Ruby.text");
		FileReader fr = new FileReader(file);
	}
	
	@Manual
	@Test 
	public void thisIsAManualTest() {
		
	}
	
}
