package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is..." + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Login Page Title NOT matching...");
	}

	@Test(priority = 1)
	public void verifySigupLinkTest() {
		Assert.assertTrue(loginPage.verifySignupLink(), "Signup link is NOT displayed...");
	}

	@Test(priority = 3)
	public void verifyLoginTest() {
		loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
	}

}
