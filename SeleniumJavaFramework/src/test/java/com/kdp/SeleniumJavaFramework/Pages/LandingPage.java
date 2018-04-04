package com.kdp.SeleniumJavaFramework.Pages;

import org.openqa.selenium.By;

import com.kdp.SeleniumJavaFramework.BaseFunction.Selenium;

public class LandingPage {
	
	public static By userName = By.xpath("//*[@id='cred_userid_inputtext']");
    public static By password = By.xpath("//*[@id='cred_password_inputtext']");
    public static By signIn = By.xpath("//*[@id='cred_sign_in_button']");
   

    
}
