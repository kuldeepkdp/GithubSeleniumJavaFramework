package com.kdp.SeleniumJavaFramework.TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kdp.SeleniumJavaFramework.BaseFunction.Selenium;
import com.kdp.SeleniumJavaFramework.Pages.ContactPage;
import com.kdp.SeleniumJavaFramework.Pages.HomePage;

public class PBI_102_Contact {
	
	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException, InterruptedException {
		Selenium.openBrowser();
	}
	
	//This test is to check that name and email is mandatory on contact form
	@Test(enabled = true, groups = { "smoke" })
	public void testValidationOnContactForm() throws InterruptedException {
		
		Selenium.driver.findElement(ContactPage.contactLink).click();
		Selenium.driver.findElement(ContactPage.send).click();
		String expectedValidation= "Validation errors occurred. Please confirm the fields and submit it again.";
		Thread.sleep(5000);
		String actulavalidation= Selenium.driver.findElement(ContactPage.validationMessage).getText();
		Assert.assertEquals(actulavalidation, expectedValidation);
		
	}
	
	
	@Test(groups = { "smoke" })
	public void testContactFormSubmission() throws InterruptedException {
		Selenium.driver.findElement(ContactPage.contactLink).click();
		Selenium.driver.findElement(ContactPage.name).sendKeys("neha kumari");
		Selenium.driver.findElement(ContactPage.email).sendKeys("nehakr12@gmail.com");
		Selenium.driver.findElement(ContactPage.subject).sendKeys("saDCGDEHVCGG");
		Selenium.driver.findElement(ContactPage.message).sendKeys("fghrghbgyjfcjghhh");
		Selenium.driver.findElement(ContactPage.send).click();
		String expectedValidation= "Your message was sent successfully. Thanks.";
		Thread.sleep(5000);
		String actualvalidation= Selenium.driver.findElement(By.xpath("//*[@id='wpcf7-f375-p28-o1']/form/div[2]")).getText();
		Assert.assertEquals(actualvalidation, expectedValidation);
		
		//my sprint 2 work
	}
	
	@AfterMethod (alwaysRun= true)
	public void after() throws IOException, InterruptedException {
	Selenium.driver.close();
	}

}
