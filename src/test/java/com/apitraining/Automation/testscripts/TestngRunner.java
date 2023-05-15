package com.apitraining.Automation.testscripts;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apitraining.Automation.utils.ProjectbasedConstantPaths;
import com.apitraining.Automation.utils.TestngUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestngRunner extends TestngUtil {
	public Properties prop;
	public FileReader jsondata;
	public Object jsonbody;
	public JSONObject input;
	public String[] requestcall = ProjectbasedConstantPaths.requestcall;
	public final static Logger LOGGER = LogManager.getLogger(TestngRunner.class);

	@Test(priority = 1)
	public void posttest() {
		prop = new Properties();
		LOGGER.info("Started executing " + ProjectbasedConstantPaths.requestcall + " method");

		RestAssured.basePath = prop.getProperty("basepath");
		response = request.post(RestAssured.basePath + "/1").then().log().all().extract().response();
		System.out.println(response);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created", "Validated Success");
		System.out.println("Response is successfully validated");
	}

	@Test(priority = 2)
	public void gettest() {
		response = request.get("/users").then().log().all().extract().response();
		System.out.println(response);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Validated Success");
		// Assert.assertEquals(response.getStatusCode(), "200" , "Validated Success");
		System.out.println("Response is successfully validated");
	}

	@Test(priority = 3)
	public void puttest() {

		RestAssured.basePath = prop.getProperty("basepath");
		response = request.put(RestAssured.basePath + "/1").then().log().all().extract().response();
		System.out.println(response);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Validated Success");
		System.out.println("Response is successfully validated");
	}

	@Test(priority = 4)
	public void patchtest() {
		RestAssured.basePath = prop.getProperty("basepath");
		response = request.patch(RestAssured.basePath + "/1").then().log().all().extract().response();
		System.out.println(response);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Validated Success");
		System.out.println("Response is successfully validated");
	}

	@Test(priority = 5)
	public void deletetest() {

		RestAssured.basePath = prop.getProperty("basepath");
		response = request.delete(RestAssured.basePath + "/1").then().log().all().extract().response();
		System.out.println(response);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 204 No Content", "Validated Success");
		System.out.println("Response is successfully validated");

		LOGGER.info("Successfully executed " + ProjectbasedConstantPaths.requestcall + " method");
	}

}
