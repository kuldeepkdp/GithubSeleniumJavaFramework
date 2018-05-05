package com.kdp.SeleniumJavaFramework.TestCases;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kdp.SeleniumJavaFramework.BaseFunction.Selenium;
import com.kdp.SeleniumJavaFramework.Pages.AutoCompletePage;
import com.kdp.SeleniumJavaFramework.Pages.ContactPage;
import com.kdp.SeleniumJavaFramework.Pages.RegisterPage;

public class PBI_103_AutoComplete {
	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException, InterruptedException {
		Selenium.openBrowser();
	}
	
	//This test script is to test auto complete filed- only navigation
	@Test(enabled = false, groups = { "smoke" })
	public void testAutoComplete() throws InterruptedException {
		//Selenium.driver.findElement(AutoCompletePage.autoselectlink).click();
				
		Selenium.driver.findElement(AutoCompletePage.tag).sendKeys("ja");
		Thread.sleep(5000);
		Selenium.driver.findElement(AutoCompletePage.tagname).click();
        //test 234
	}
	
	@Test (enabled = false, groups = { "smoke" })
	public void testFrame() throws InterruptedException
	{
		
		Selenium.driver.navigate().to("http://toolsqa.com");
		
		WebElement element = Selenium.driver.findElement(By.linkText("DEMO SITES"));
		 
        Actions action = new Actions(Selenium.driver);
 
        action.moveToElement(element).build().perform();
        Thread.sleep(5000);
	
		Thread.sleep(5000);	Selenium.driver.findElement(AutoCompletePage.framelink).click();
		//Selenium.driver.switchTo().frame(Selenium.driver.findElement(By.id("IF2")));
		Selenium.driver.switchTo().frame("IF2");
		String content= Selenium.driver.findElement(AutoCompletePage.target).getText();
		System.out.println("Content of the frame is" + content);
		Selenium.driver.switchTo().defaultContent();
		Selenium.driver.findElement(By.xpath("//*[@id='primary-menu']/li[1]/a/span[1]/span/span")).click();
			
	}
	
	@Test(enabled = false, groups = { "smoke" })
	public void testAlert() throws InterruptedException {
		Selenium.driver.navigate().to("http://toolsqa.com");
		WebElement element = Selenium.driver.findElement(By.linkText("DEMO SITES"));
		 
        Actions action = new Actions(Selenium.driver);
 
        action.moveToElement(element).build().perform();
        Thread.sleep(5000);
        Selenium.driver.findElement(AutoCompletePage.alertlink).click();
        Thread.sleep(5000);
        Selenium.driver.findElement(AutoCompletePage.alertsimplelink).click();
        Selenium.driver.switchTo().alert().accept();
       
	}
	
	@Test(enabled = true, groups = { "smoke" })
	public void testPrompt() throws InterruptedException  {
		Selenium.driver.navigate().to("http://toolsqa.com");
		WebElement element = Selenium.driver.findElement(By.linkText("DEMO SITES"));
		 
        Actions action = new Actions(Selenium.driver);
 
        action.moveToElement(element).build().perform();
        Thread.sleep(5000);
        Selenium.driver.findElement(AutoCompletePage.alertlink).click();
        Thread.sleep(5000);
        
        JavascriptExecutor je = (JavascriptExecutor) Selenium.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",Selenium.driver.findElement(AutoCompletePage.promptlink));
        
        je.executeScript("arguments[0].click();", Selenium.driver.findElement(AutoCompletePage.promptlink));
        
        Selenium.driver.findElement(AutoCompletePage.promptlink).click();
        
        Selenium.driver.switchTo().alert().sendKeys("Yes");
         Thread.sleep(4000);
         
         Selenium.driver.switchTo().alert().accept();
        
        
	}
}
	
	/*@AfterMethod (alwaysRun= true)
	public void after() throws IOException, InterruptedException {
	Selenium.driver.close();
	}*/


