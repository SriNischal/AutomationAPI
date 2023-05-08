package com.apitraining.Automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestngUtil {
	private FileInputStream path;
	private Properties prop;
	private RequestSpecification request;
	private Response response;
	public FileReader jsondata;
	public Object jsonbody;
	public JSONObject input;
	public String requestcall = ProjectbasedConstantPaths.requestcall;
	
	@BeforeSuite
	public void beforeSuite() {
		prop = new Properties();
		try {
			path = new FileInputStream(
					ProjectbasedConstantPaths.TEST_DATA);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		try {
			prop.load(path);
		} catch (IOException e) {
			System.out.println("path is invalid");
		}
		RestAssured.baseURI = prop.getProperty("BaseURL");
		System.out.println(prop.getProperty("BaseURL"));
	}
	
	@BeforeTest
	public void beforeTest(){
		JSONParser data = new JSONParser();
		try {
			jsondata = new FileReader(ProjectbasedConstantPaths.JSON_DATA);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			jsonbody = data.parse(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
        input = (JSONObject) jsonbody;
		request = RestAssured.given().auth().basic(prop.getProperty("username"), prop.getProperty("password")).body(input.toJSONString());
		System.out.println(request);
	}
	
	public void test() {
		if(requestcall.equals("Get")) {
			response = request.when().get("/users/1").then().log()
					.all().extract().response();
			System.out.println(response);
		}
		else if (requestcall.equals("Post")) {
			RestAssured.basePath = prop.getProperty("basepath");
			response = request.when().put(RestAssured.basePath+"/1").then().log()
					.all().extract().response();
			System.out.println(response);
		}
		else if (requestcall.equals("Put")) {
			RestAssured.basePath = prop.getProperty("basepath");
			response = request.when().put(RestAssured.basePath+"/1").then().log()
					.all().extract().response();
			System.out.println(response);
		}
		else if (requestcall.equals("Patch")) {
			RestAssured.basePath = prop.getProperty("basepath");
			response = request.when().patch(RestAssured.basePath+"/1").then().log()
					.all().extract().response();
			System.out.println(response);
		}
		else {
			RestAssured.basePath = prop.getProperty("basepath");
	 		response = request.when().delete(RestAssured.basePath + "/1").then().log().all().extract().response();
	 		System.out.println(response);
		}
	}

	@AfterTest
	public void afterTest() {
		if(requestcall.equals("Get")) {
			Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK" , "Validated Success");
			System.out.println("Response is successfully validated");
		}
		else if (requestcall.equals("Post")) {
			Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Validated Success");
			System.out.println("Response is successfully validated");
		}
		else if (requestcall.equals("Put")) {
			Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Validated Success");
			System.out.println("Response is successfully validated");
		}
		else if (requestcall.equals("Patch")) {
			Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Validated Success");
			System.out.println("Response is successfully validated");
		}
		else {
			Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 204 No Content", "Validated Success");
			System.out.println("Response is successfully validated");
		}
		
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Suite executed successfully");
	}

}
