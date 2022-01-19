package com.qa.test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;

public class TC_Delete_Request extends BaseTest{
	
	@Test
	public void deleteUserTest()
	{
		logger.info("Started Testcase");
		String url = "https://reqres.in/api/users/" + userID;
		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", null);
		expectedHeaders.put("Server", "cloudflare");

		given().log().all()
		.when().delete(url)
		.then().log().all().assertThat().statusCode(204)
		.and().statusLine("HTTP/1.1 204 No Content")
		.and().headers(expectedHeaders);
	}
	@AfterClass
	void tearDown()
	{
		logger.info("Testcase execution finished");
	}
}
