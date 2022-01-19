package com.qa.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;

public class TC_Get_Request extends BaseTest{
	
	@Test(description = "Get Request for all user")
	public static void getAllUserTest()
	{
		logger.info("Started Testcase");
		String url = "https://reqres.in/api/users";
		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "cloudflare");
		expectedHeaders.put("Content-Encoding", "gzip");

		given().log().all()
		.when().get(url)
		.then().log().all().assertThat().statusCode(200)
		.and().statusLine("HTTP/1.1 200 OK")
		.and().headers(expectedHeaders);
	}
	
	@Test(description = "Get Request for single user")
	public static void getSinglerUserTest()
	{
		logger.info("Started Testcase");
		String url = "https://reqres.in/api/users/2";
		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "cloudflare");
		expectedHeaders.put("Content-Encoding", "gzip");

		given().log().all()
		.when().get(url)
		.then().log().all().statusCode(200)
		.and().statusLine("HTTP/1.1 200 OK")
		.and().headers(expectedHeaders)
		.and().body(containsString("2"));
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("Testcase execution finished");
	}

}
