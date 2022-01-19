package com.qa.base;

import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;

public class BaseTest {
	
	public String userID="2";	
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger=Logger.getLogger("ReqresRestAPI");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	public static void getResponseBody(String url, final Map<String, String> requestParam)
	{
		given().log().all().queryParam(String.valueOf(requestParam))
		.when().get(url)
		.then().log().all().extract();
	}
	
	public static void postRequest(String requestBody, String url)
	{
		given().log().all().body(requestBody).when().post(url).then().log().all().extract();
	}
}
