package com.kdp.SeleniumJavaFramework.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kdp.SeleniumJavaFramework.BaseFunction.Selenium;
import com.kdp.SeleniumJavaFramework.Pages.AccordionPage;
import com.kdp.SeleniumJavaFramework.Pages.ContactPage;
import com.kdp.SeleniumJavaFramework.Pages.RegisterPage;

public class PBI_105_RegisterTest {
	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException, InterruptedException {
		Selenium.openBrowser();
	}
	
	//This test script is to test auto complete filed- only navigation
	@Test(enabled = true, groups = { "smoke" })
	public void testAccordion() throws InterruptedException {
		Selenium.driver.findElement(RegisterPage.registerlink).click();
		Selenium.driver.findElement(RegisterPage.fname).sendKeys("Tapi");
		Selenium.driver.findElement(RegisterPage.lname).sendKeys("Kumari");
		Selenium.driver.findElement(RegisterPage.mstatus).click();
		Selenium.driver.findElement(RegisterPage.hobby).click();
		Selenium.driver.findElement(RegisterPage.country).click();
		Selenium.driver.findElement(RegisterPage.dm).click();
		Selenium.driver.findElement(RegisterPage.dd).click();
		Selenium.driver.findElement(RegisterPage.dy).click();
		Selenium.driver.findElement(RegisterPage.ph).sendKeys("8271675498");
		Selenium.driver.findElement(RegisterPage.uname).sendKeys(Selenium.generateString(8));
		Selenium.driver.findElement(RegisterPage.email).sendKeys(Selenium.generateString(6)+"@gmail.com");
		//Selenium.driver.findElement(RegisterPage.pic).click();
		Selenium.driver.findElement(RegisterPage.pic).sendKeys("C:\\Users\\lenovo\\Pictures\\11.jpg");
		Selenium.driver.findElement(RegisterPage.about).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ");
		Selenium.driver.findElement(RegisterPage.pw).sendKeys("password123");	
		Selenium.driver.findElement(RegisterPage.cpw).sendKeys("password123");
		Selenium.driver.findElement(RegisterPage.send).click();
		String expectedValidation="Thank you for your registration";
	    Thread.sleep(5000);
		String actualvalidation= Selenium.driver.findElement(By.xpath("//*[@id='post-49']/div/p")).getText();
		Assert.assertEquals(actualvalidation, expectedValidation);
		
		
	}


		
		/*@AfterMethod (alwaysRun= true)
		public void after() throws IOException, InterruptedException {
		Selenium.driver.close();

		}*/
}
