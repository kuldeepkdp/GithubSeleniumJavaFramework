package com.kdp.SeleniumJavaFramework.Pages;

import org.openqa.selenium.By;

public class AutoCompletePage {
	public static By autoselectlink = By.xpath("//*[@id='menu-item-145']/a");
	public static By tag =By.xpath("//*[@id='tagss']");
	public static By tagname =By.xpath("//li[contains(text(),'JavaScript')]");
	public static By framelink =By.xpath("//span[contains(text(),'IFrame practice page')]");
	public static By target =By.xpath("//*[@id='post-9']/div/div[1]/h5");
	public static By alertlink =By.xpath("//span[contains(text(),'Handling Alerts using Selenium WebDriver')]");
	public static By alertsimplelink =By.xpath("//*[@id='content']/p[4]/button");
	public static By promptlink =By.xpath("//*[@id='content']/p[11]/button");
}
