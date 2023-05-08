package com.apitraining.Automation.utils;

import java.util.Properties;
import com.apitraining.Automation.interfac.APIInterface;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIutil implements APIInterface{
	    Properties prop = new Properties();
     	public void apideletecall() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).param(prop.getProperty("parameter"),prop.getProperty("value")).when().delete("/users").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
	}

	public void apigetcall() {
		Response response = RestAssured.given().param(prop.getProperty("parameter"), prop.getProperty("value")).when().get("/users").then().log()
				.all().extract().response();
		System.out.println(response.getBody().asString());
	}

	public void apipostcall() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).body(prop.getProperty("postpayload_str".toString())).post("/users").then().log().all().extract().response();
		System.out.println(response);
	}

	public void apipatchcall() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).body(prop.getProperty("patchpayload_str".toString())).patch("/users/1").then().log().all().extract().response();
		System.out.println(response);
	}

	public void apiputcall() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).body(prop.getProperty("putpayload_str".toString())).put("/users").then().log().all().extract().response();
		System.out.println(response);
	}
	
	public void bearerauth() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).header("Auth", prop.getProperty("token")).when().get("/users/1").then().log().all().extract().response();
		System.out.println(response.getBody().asString());	
	}

	public void basicauth() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).auth().basic(prop.getProperty("username"), prop.getProperty("password")).param(prop.getProperty("parameter"), prop.getProperty("value")).when().get("/users").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
	}

	public void akamaiauth() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).header("Auth", prop.getProperty("token")).param(prop.getProperty("parameter"), prop.getProperty("value")).when().get("/users").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
	}

	public void awsauth() {
        Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).header("Authorization", prop.getProperty("token")).param(prop.getProperty("parameter"), prop.getProperty("value")).when().get("/users").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
	}

	public void digestauth() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).auth().digest(prop.getProperty("username"), prop.getProperty("password")).when().get("/users").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
	}

	public void hawkauth() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).header("Authorization", "Hawk id=12345, Hawk Auth key = a2V5c3RvcmUxMjM0NTY=").param(prop.getProperty("parameter"), prop.getProperty("value")).when().get("/users").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
	}

	public void jwtauth() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).header("Auth", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c").param(prop.getProperty("parameter"), prop.getProperty("value")).when().get("/users").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
	}

	public void apikeyauth() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).header("Authorization", prop.getProperty("keyvalue")).param(prop.getProperty("parameter"), prop.getProperty("value")).when().get("/users").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
	}

	public void ntmlauth() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).auth().ntlm(prop.getProperty("username"), prop.getProperty("password"), "nischal", "Nischal").param(prop.getProperty("parameter"), prop.getProperty("value")).when().get("/users").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
	}

	public void oauth1() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL"))
				.header("ABC123DEF456GHI789", "secret123", prop.getProperty("token"), "abcdefgh123456").when().get("/users").then().log()
				.all().extract().response();
		System.out.println(response.getBody().asString());	
	}

	public void oauth2() {
		Response response = RestAssured.given().baseUri(prop.getProperty("BaseURL")).auth().oauth2(prop.getProperty("token")).when().get("/users").then().log()
				.all().extract().response();
		System.out.println(response.getBody().asString());	
	}

}
