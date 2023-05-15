package com.apitraining.Automation.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.apitraining.Automation.utils.ProjectbasedConstantPaths;
import com.apitraining.Automation.utils.TestngUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testng {
	@Test
	public void test() {
		TestngUtil util = new TestngUtil();
		util.beforeSuite();
		util.beforeTest();
		util.test();
	}
		
	}