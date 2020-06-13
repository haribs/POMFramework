package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.utils.Constants;

public class HomePageTest extends BaseTest {

	HomePage homePage;
	
	@BeforeClass
	public void homePageSetup() {
		homePage = loginPage.doLogin(properties.getProperty("username"),properties.getProperty("password"));
	}
	
	@Test(priority=3)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page Title..." + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE,"Home Page Title NOT matching...");
	}
	
	@Test(priority=1)
	public void verifyHomePageHeaderTest() {
		String homePageHeader = homePage.getHomePageHeaderText();
		System.out.println("Home Page Header..." + homePageHeader);
		Assert.assertEquals(homePageHeader, Constants.HOME_PAGE_HEADER, "Home Page Header is NOT matching...");
	}
	
	@Test(priority=2)
	public void verifyLoggedInUserTest() {
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println("LoggedIn User is..." + loggedInUser);
		Assert.assertEquals(loggedInUser, properties.get("loggedInUserName"), "Logged in user is NOT matching...");
	}
	
}
