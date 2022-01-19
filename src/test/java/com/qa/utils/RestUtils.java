package com.qa.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils 
{
	public static String userName()
	{
		String generatedName = RandomStringUtils.randomAlphabetic(5);
		return generatedName;
	}
	public static String userJob()
	{
		String generatedJob = RandomStringUtils.randomAlphabetic(5);
		return generatedJob;
	}
	
}
