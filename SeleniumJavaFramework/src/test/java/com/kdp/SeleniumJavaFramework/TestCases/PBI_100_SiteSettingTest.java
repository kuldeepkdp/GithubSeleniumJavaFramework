package com.kdp.SeleniumJavaFramework.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.kdp.SeleniumJavaFramework.BaseFunction.Selenium;
import com.kdp.SeleniumJavaFramework.Pages.HomePage;
import com.kdp.SeleniumJavaFramework.Pages.LandingPage;
import com.kdp.SeleniumJavaFramework.Pages.SiteSettingPage;

public class PBI_100_SiteSettingTest {

	@BeforeMethod (alwaysRun= true)
	public void before() throws IOException, InterruptedException {
		Selenium.openBrowser();
		
		//commit 1
	}

	@Test (enabled = true, groups = { "regression" })
	public void testSitePermissionsLinkOnSiteSettingScreen() throws InterruptedException,
			IOException {

		Selenium.doLogin(Selenium.GetData("userName"),
				Selenium.GetData("password"));

		HomePage.GoToSiteSettingsPage();

		String actualPermissionLink = Selenium.driver.findElement(
				SiteSettingPage.sitePermissions).getText();
		Assert.assertEquals(actualPermissionLink, "Site permissions kk");

	}

	@Test (groups = { "regression" })
	public void testAdminLinkOnSiteSettingScreen() throws InterruptedException,
			IOException {

		Selenium.doLogin(Selenium.GetData("userName"),
				Selenium.GetData("password"));

		HomePage.GoToSiteSettingsPage();

		String actualAdminLink = Selenium.driver.findElement(
				SiteSettingPage.sfwPlazaAdministration).getText();
		Assert.assertEquals(actualAdminLink, "SFW Plaza Administration");

	}

	@AfterMethod (alwaysRun= true)
	public void after() throws IOException, InterruptedException {
		Selenium.doLogOut();
	}
}
