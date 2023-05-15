package com.apitraining.Automation.testscripts;

import java.net.URI;
import java.net.URISyntaxException;

import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class WireMocktest {
	private static final int PORT = 8080;
	private static final String HOST = "localhost";
	private static WireMockServer server = new WireMockServer(PORT);

	@BeforeClass
	public static void setup() {
		server.start();
		ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
		mockResponse.withStatus(200).withBody(
				"{\"message\": \"This is a mock response\", \"id\": 1, \"employee_name\": \"nischal\", \"employee_salary\": 30200, \"employee_age\": 28}")
				.withHeader("Content-Type", "application/json");
		WireMock.configureFor(HOST, PORT); // http://localhost:8080
		WireMock.stubFor(WireMock.get("/api/wiremockapi").willReturn(mockResponse));
	}

	@Test
	public void getrequest() throws URISyntaxException {
		Response res = RestAssured.given().accept(ContentType.JSON).when()
				.get(new URI("http://localhost:8080/api/wiremockapi")).then().assertThat().statusCode(200).and()
				.body("employee_name", Matchers.equalTo("nischal")).body("employee_salary", Matchers.equalTo(30200)).extract().response();
		System.out.println(res.getBody().asString());
	}
	
	@AfterClass
	public static void teardown() {
		if (null != server && server.isRunning()) {
			server.shutdownServer();
		}
	}
}