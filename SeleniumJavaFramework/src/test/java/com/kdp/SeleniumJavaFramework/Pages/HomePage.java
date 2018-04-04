package com.kdp.SeleniumJavaFramework.Pages;

import org.openqa.selenium.By;

import com.kdp.SeleniumJavaFramework.BaseFunction.Selenium;

public class HomePage {
	
	public static By servicesLink = By.xpath("//span[contains(text(),'Services')]");
	public static By policiesLink = By.xpath("//span[contains(text(),'Policies')]");
    public static By settingMenu = By.xpath("//*[@id='O365_MainLink_Settings']");
    public static By siteContents = By.xpath("//span[@aria-label='Site contents']");
    public static By siteSettings = By.xpath("//span[@aria-label='Site settings']");
    
    public static By profile = By.xpath("//div[@class='o365cs-me-tile-nophoto-username-container']");
    public static By signOut = By.xpath("//*[@id='O365_SubLink_ShellSignout']");
	
	 public static void GoToSiteSettingsPage() throws InterruptedException
     {
         Selenium.waitFor(15000);
         Selenium.driver.findElement(settingMenu).click();
         Selenium.waitFor(5000);
         Selenium.driver.findElement(siteSettings).click();
         Selenium.waitFor(10000);
     }

}
