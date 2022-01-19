package com.qa.test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.utils.RestUtils;

public class TC_Put_Request extends BaseTest{

	String uname=RestUtils.userName();
	String ujob=RestUtils.userJob();

	@Test(description = "Update user - Put request")
	public void updateUserTest()
	{
		logger.info("Started Testcase");
		String url = "https://reqres.in/api/users/" + userID;
		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "cloudflare");

		JSONObject requestBody1 = new JSONObject();
		requestBody1.put("name", uname);
		requestBody1.put("job", ujob);
		
		given().log().all().header("Content-Type", "application/json")
		.and().body(requestBody1.toString())
		.when().put(url)
		.then().log().all().assertThat().statusCode(200)
		.and().statusLine("HTTP/1.1 200 OK")
		.and().headers(expectedHeaders);

	}
	@AfterClass
	void tearDown()
	{
		logger.info("Testcase execution finished");
	}

}
