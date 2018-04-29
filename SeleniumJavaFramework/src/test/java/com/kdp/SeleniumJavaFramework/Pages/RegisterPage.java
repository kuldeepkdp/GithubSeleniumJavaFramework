package com.kdp.SeleniumJavaFramework.Pages;

import org.openqa.selenium.By;

public class RegisterPage {
	public static By registerlink = By.xpath("//*[@id='menu-item-374']/a");
	public static By fname =By.xpath("//input[@name='first_name']");
	public static By lname =By.xpath("//input[@name='last_name']");
	public static By mstatus =By.xpath("//*[@id='pie_register']/li[2]/div/div/input[1]");
	public static By hobby =By.xpath("//*[@id='pie_register']/li[3]/div/div[1]/input[2]");
	public static By country =By.xpath("//*[@id='dropdown_7']/option[81]");
	public static By dm =By.xpath("//*[@id='mm_date_8']/option[3]");
	public static By dd =By.xpath("//*[@id='dd_date_8']/option[25]");
	public static By dy =By.xpath("//*[@id='yy_date_8']/option[21]");
	public static By ph =By.xpath("//input[@name='phone_9']");
	public static By uname =By.xpath("//input[@name='username']");
	public static By email =By.xpath("//input[@name='e_mail']");
	public static By pic =By.xpath("//*[@id='profile_pic_10']");
	public static By about =By.xpath("//textarea[@name='description']");
	public static By pw =By.xpath("//input[@name='password']");
	public static By cpw =By.xpath("//*[@id='confirm_password_password_2']");
	public static By send =By.xpath("//input[@name='pie_submit']");

}
