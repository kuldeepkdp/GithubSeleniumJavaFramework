package com.kdp.SeleniumJavaFramework.TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.kdp.SeleniumJavaFramework.BaseFunction.Selenium;
import com.kdp.SeleniumJavaFramework.Pages.HomePage;
import com.kdp.SeleniumJavaFramework.Pages.NatericaPage;

public class Naterica_PullData {
	

	//This test script is to pull data for Natrica work 1
	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException, InterruptedException {
			String browser = Selenium.GetData("browser");
			String IE;
			String Firefox;
			String Chrome;
			System.out.println("browser check");

			if (browser.equals("IE")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir")
								+ "//Drivers//IEDriver//IEDriverServer");
				Selenium.driver = new InternetExplorerDriver();
				Selenium.driver.manage().window().maximize();
				Selenium.driver.get("http://www.claytoncountyga.gov/government/courts/court-case-inquiry");

			} else if (browser.equals("Firefox")) {
				Selenium.driver = new FirefoxDriver();
				Selenium.driver.get("http://www.claytoncountyga.gov/government/courts/court-case-inquiry");

			}

			else if (browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")
								+ "//Drivers//ChromeDriver//chromedriver.exe");
				Selenium.driver = new ChromeDriver();
				Selenium.driver.manage().window().maximize();
				Selenium.driver.get("http://www.claytoncountyga.gov/government/courts/court-case-inquiry");

			}

		}


	@Test(groups = { "smoke" })
	public void testServiceLinkOnHomePage() throws InterruptedException,
			IOException, InvalidFormatException {
	
   		    WebDriverWait wait = new WebDriverWait(Selenium.driver, 45);
			

		  
		  for(int number=6770 ; number<7999; number++){
		  Thread.sleep(1000);
		  Selenium.driver.switchTo().frame(Selenium.driver.findElement(By.id("Clayton County")));
		  Selenium.driver.findElement(By.xpath("(//a[contains(text(),'Case Search')])[1]")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(NatericaPage.courtDropbox));
		  Thread.sleep(2000);
		  Selenium.driver.findElement(NatericaPage.courtDropbox).sendKeys("Magistrate Court");
		  Selenium.driver.findElement(By.xpath("//*[@id='inqcase1']/table/tbody/tr[2]/td[2]/input[1]")).sendKeys("2018");
		  Selenium.driver.findElement(By.xpath("//*[@id='inqcase1']/table/tbody/tr[2]/td[2]/input[2]")).sendKeys("CM");
		  
		  //String x=String.valueOf(number);
		  Thread.sleep(1000);
		  Selenium.driver.findElement(By.xpath("//*[@id='inqcase1']/table/tbody/tr[2]/td[2]/input[3]")).clear();
		  Selenium.driver.findElement(By.xpath("//*[@id='inqcase1']/table/tbody/tr[2]/td[2]/input[3]")).sendKeys("0"+number);
		  Selenium.driver.findElement(By.xpath("//*[@id='btnSrch']")).click();
		  
		  Thread.sleep(10000);   //Change wait time form this step
		  System.out.println("Data for case number->  " +number);
		  try{
		  System.out.println(Selenium.driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td/table[2]/tbody/tr[6]/td[2]/a")).getText());
		 
		  }catch(NoSuchElementException e){}
		  
		  try{
		  System.out.println(Selenium.driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td/table[2]/tbody/tr[7]/td[2]/a")).getText());
		
		  }catch(NoSuchElementException e){}
		  
		  try{
		  System.out.println(Selenium.driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td/table[2]/tbody/tr[8]/td[2]/a")).getText());
		  }catch(NoSuchElementException e){}
		  
		  try{
		  System.out.println(Selenium.driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td/table[2]/tbody/tr[9]/td[2]/a")).getText());
		  }catch(NoSuchElementException e){}
		  
		  try{
		  System.out.println(Selenium.driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td/table[2]/tbody/tr[10]/td[2]/a")).getText());
		  }catch (NoSuchElementException e)
          {
              
          }
		  
		  System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		  
		  Selenium.driver.navigate().to("http://www.claytoncountyga.gov/government/courts/court-case-inquiry/");
		  
		  }  
	}	

}
