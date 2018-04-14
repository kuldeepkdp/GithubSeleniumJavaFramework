package com.kdp.SeleniumJavaFramework.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kdp.SeleniumJavaFramework.BaseFunction.Selenium;
import com.kdp.SeleniumJavaFramework.Pages.AutoCompletePage;
import com.kdp.SeleniumJavaFramework.Pages.ContactPage;

public class PBI_103_AutoComplete {
	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException, InterruptedException {
		Selenium.openBrowser();
	}
	
	//This test script is to test auto complete filed- only navigation
	@Test(enabled = true, groups = { "smoke" })
	public void testAutoComplete() throws InterruptedException {
		Selenium.driver.findElement(AutoCompletePage.autoselectlink).click();
		Selenium.driver.findElement(AutoCompletePage.tag).sendKeys("ja");
		Thread.sleep(5000);
		Selenium.driver.findElement(AutoCompletePage.tagname).click();
        //test 234
	}
	
	@AfterMethod (alwaysRun= true)
	public void after() throws IOException, InterruptedException {
	Selenium.driver.close();
	}

}
