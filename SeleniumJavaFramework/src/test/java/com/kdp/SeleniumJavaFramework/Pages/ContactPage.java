package com.kdp.SeleniumJavaFramework.Pages;

import org.openqa.selenium.By;

public class ContactPage {

	public static By contactLink = By.xpath("//a[@title='Contact']");
	public static By send = By.xpath("//input[@value='Send']");
	public static By name =By.xpath("//input[@name='your-name']");
	public static By email =By.xpath("//input[@name='your-email']");
	public static By subject =By.xpath("//input[@name='your-subject']");
	public static By message =By.xpath("//textarea[@name='your-message']");
	public static By validationMessage=By.xpath("//*[@id='wpcf7-f375-p28-o1']/form/div[2]");
	
	//my sprint 2 work
}
