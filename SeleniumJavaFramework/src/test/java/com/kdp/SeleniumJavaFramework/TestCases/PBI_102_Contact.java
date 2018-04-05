package com.kdp.SeleniumJavaFramework.TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kdp.SeleniumJavaFramework.BaseFunction.Selenium;
import com.kdp.SeleniumJavaFramework.Pages.HomePage;

public class PBI_102_Contact {
	
	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException, InterruptedException {
		Selenium.openBrowser();
	}
	
	@Test(groups = { "smoke" })
	public void testValidationOnContactForm() throws InterruptedException,
			IOException, InvalidFormatException {
		
		System.out.println("Write your Test Code here");
		System.out.println("Write your Test Code here");

	}
	
	@AfterMethod (alwaysRun= true)
	public void after() throws IOException, InterruptedException {
		Selenium.driver.quit();
	}

}
