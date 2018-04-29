package com.kdp.SeleniumJavaFramework.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kdp.SeleniumJavaFramework.BaseFunction.Selenium;
import com.kdp.SeleniumJavaFramework.Pages.AccordionPage;
import com.kdp.SeleniumJavaFramework.Pages.AutoCompletePage;

public class PBI_104_Accordion {
	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException, InterruptedException {
		Selenium.openBrowser();
	}
	
	//This test script is to test auto complete filed- only navigation
	@Test(enabled = true, groups = { "smoke" })
	public void testAccordion() throws InterruptedException {
		Selenium.driver.findElement(AccordionPage.accordionlink).click();
		Selenium.driver.findElement(AccordionPage.text).click();
		String expectedValidation= "Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.\r\n" + 
				"Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero\r\n" + 
				"ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis\r\n" + 
				"lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.";
		Thread.sleep(5000);
		String actualvalidation= Selenium.driver.findElement(By.xpath("//*[@id='ui-id-9']/p")).getText();
		Assert.assertEquals(actualvalidation, expectedValidation);
		
	}
	
	/*@AfterMethod (alwaysRun= true)
	public void after() throws IOException, InterruptedException {
	Selenium.driver.close();
	}*/

}



