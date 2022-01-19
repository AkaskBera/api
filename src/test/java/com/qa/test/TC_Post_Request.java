package com.qa.test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.utils.RestUtils;

public class TC_Post_Request extends BaseTest{
	
	String uname=RestUtils.userName();
	String ujob=RestUtils.userJob();
	
	@Test(description = "Add user - Post request")
	public static void createUserTest()
	{
		logger.info("Started Testcase");
		String url = "https://reqres.in/api/users";
		String requestBody = "{\r\n"
				+ "    \"name\": \"akash\",\r\n"
				+ "    \"job\": \"intern\"\r\n"
				+ "}";
		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "cloudflare");
		
		given().log().all().header("Content-Type", "application/json")
		.and().body(requestBody)
		.when().post(url)
		.then().log().all().assertThat().statusCode(201)
		.and().statusLine("HTTP/1.1 201 Created")
		.and().headers(expectedHeaders);
	}
	
	@Test(description = "Add user - Post call using Json object")
	public void createUserTest1()
	{
		logger.info("Started Testcase");
		String url = "https://reqres.in/api/users";
		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "cloudflare");

		JSONObject requestBody1 = new JSONObject();
		requestBody1.put("name", uname);
		requestBody1.put("job", ujob);
		
		given().log().all().header("Content-Type", "application/json")
		.and().body(requestBody1.toString())
		.when().post(url)
		.then().log().all().assertThat().statusCode(201)
		.and().statusLine("HTTP/1.1 201 Created")
		.and().headers(expectedHeaders);
	}
	
	@Test
	public static void createUserTest2()
	{
		String url = "https://reqres.in/api/users";
		Map<String, String> queryParam = new HashMap<String, String>();
		queryParam.put("page", "2");

		BaseTest.getResponseBody(url, queryParam);
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("Testcase execution finished");
	}
}
