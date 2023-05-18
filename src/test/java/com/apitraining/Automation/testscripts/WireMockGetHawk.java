package com.apitraining.Automation.testscripts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class WireMockGetHawk {

    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private static WireMockServer server = new WireMockServer(PORT);

    @BeforeClass
    public static void setup() {
        server.start();
        ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
        mockResponse.withStatus(200).withHeader("Content-Type", "application/json");
        WireMock.configureFor(HOST, PORT); // http://localhost:8080
        WireMock.stubFor(WireMock.get("/api/wiremockapi").willReturn(mockResponse));
    }

    @Test
    public void get() throws URISyntaxException {
        String hawkauthid = "12345";
        String hawkauthkey = "LKKNDFKWENJFOWINOIEFNOWINEK";
        Map<String, String> header = new HashMap();
        String[] headers = { hawkauthid,hawkauthkey };
        for (String headerValue : headers) {
            header.put("Authorization", headerValue);
        }

        Response response = RestAssured.given().baseUri("http://localhost:8080").header("Authentication", "application/json").headers(header)
                .accept(ContentType.JSON).when().get("/api/wiremockapi").then().assertThat().statusCode(200).and()
                //.body("employee_name", Matchers.equalTo("SriNischal"))
                .log().all().extract().response();
        System.out.println(response.getBody().asString());
    }

    @AfterClass
    public static void teardown() {
        if (null != server && server.isRunning()) {
            server.shutdownServer();
        }
    }
}