package com.apitraining.Automation.testscripts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Extractdata {
	public final static Logger LOGGER = LogManager.getLogger(Extractdata.class);

	@Test
	public void testGetdetails() {
		Response response = RestAssured.given().get("https://dummyjson.com/products");
		System.out.println(response.getBody().asString());
		JsonPath js = response.jsonPath();
		ArrayList<String> list = js.get("products.id");
		assertThat(response.getStatusCode(), is(200));
		assertThat(response.statusLine(), contains("200") != null);
		System.out.println(list.size());
		String title = "iPhone";
		assertThat(title, startsWith("iPh"));
		for (int i = 0; i < list.size(); i++) {
			if ((js.get("products.title[" + i + "]")).equals(title)) {
				System.out.println("the mobile details==>" + js.get("products.title[" + i + "]"));
				assertThat(js.get("products.title[" + i + "]"), contains("iPhone"));
				System.out.println("the mobile details==>" + js.get("products.price[" + i + "]"));
				System.out.println("the mobile details==>" + js.get("products.stock[" + i + "]"));
				System.out.println("the mobile details==>" + js.get("products.id[" + i + "]"));
				
			}
		}

	}
}