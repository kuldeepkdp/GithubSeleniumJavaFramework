package com.kdp.SeleniumJavaFramework.TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.kdp.SeleniumJavaFramework.BaseFunction.Selenium;
import com.kdp.SeleniumJavaFramework.Pages.ContactPage;
import com.kdp.SeleniumJavaFramework.Pages.HomePage;

public class PBI_101_HomeTest {

	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException, InterruptedException {
		Selenium.openBrowser();
	}

	@Test(groups = { "smoke" })
	public void testServiceLinkOnHomePage() throws InterruptedException,
			IOException, InvalidFormatException {
		Selenium.doLogin(Selenium.GetData("userName"),
				Selenium.GetData("password"));

		String actualLink = Selenium.driver.findElement(HomePage.servicesLink)
				.getText();
		Assert.assertEquals(actualLink, "Services");

		String data = Selenium.getDataFromExcel("CreateUser", 1, 0);
		System.out.println("Data from excel is  " + data);

		Selenium.storeResult("Account no. is 545454", 0, 0);
		
		String output = Selenium.getStoredResult("Output", 0, 0);
		System.out.println("Stored result is " + output);
		
		
		String generatedStringValue = Selenium.generateString(5);
		System.out.println("Generated string value is " + generatedStringValue);

	}

	@Test(enabled = true, groups = { "smoke" })
	public void testValidationOnHome_1() throws InterruptedException,
			IOException, InvalidFormatException {
		Selenium.driver.findElement(By.xpath("//a[@title='Home']")).click();
		

		/*Selenium.doLogin(Selenium.GetData("userName"),
				Selenium.GetData("password"));

		String actualPoliciesLink = Selenium.driver.findElement(
				HomePage.policiesLink).getText();
		Assert.assertEquals(actualPoliciesLink, "Policieskk");*/

	}

	@AfterMethod(alwaysRun = true)
	public void after() throws IOException, InterruptedException {
		Selenium.doLogOut();
	}

}
