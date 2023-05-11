package com.apitraining.Automation.testscripts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.apitraining.Automation.utils.ProjectbasedConstantPaths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Extractdata {
	public final static Logger LOGGER = LogManager.getLogger(Extractdata.class);
	public Pattern pattern;
	public Properties prop;
	public FileInputStream path;

	@Test
	public void testGetdetails() throws Exception {
		pattern = Pattern.compile("^([a-zA-Z]+)");
		prop = new Properties();  
		path = new FileInputStream(
				ProjectbasedConstantPaths.TEST_DATA);
		prop.load(path);
		Response response = RestAssured.given().get(prop.getProperty("url"));
		System.out.println(response.getBody().asString());
		JsonPath js = response.jsonPath();
		ArrayList<String> list = js.get("products.id");
		assertThat(response.getStatusCode(), is(200));
		assertThat(response.statusLine(), contains("200") != null);
		System.out.println(list.size());
		Matcher matcher = pattern.matcher(ProjectbasedConstantPaths.title);
		if (matcher.matches()) {
			System.out.println(matcher.group(0));
		}
		for (int i = 0; i < list.size(); i++) {
			if ((js.get("products.brand[" + i + "]")).equals(matcher.group(0))) {
				System.out.println("the mobile title==>" + js.get("products.title[" + i + "]"));
				System.out.println("the mobile price==>" + js.get("products.price[" + i + "]"));
				System.out.println("the mobile stock==>" + js.get("products.stock[" + i + "]"));
				System.out.println("the mobile id==>" + js.get("products.id[" + i + "]"));
			}
		}
	}
}