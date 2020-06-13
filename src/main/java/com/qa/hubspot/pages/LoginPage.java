package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.utils.Constants;
import com.qa.utils.ElementsUtil;
import com.qa.utils.WaitsUtil;

public class LoginPage extends BasePage {

	// For every page we need create the below 3 events
	// 1. Define all By locators - Object Repository
	// 2. Create a constructor
	// 3. Create page actions

	private WebDriver driver;
	
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signupLink = By.linkText("Sign up");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementsUtil = new ElementsUtil(this.driver);
		waitsUtil = new WaitsUtil(driver);
	}

	public String getLoginPageTitle() {
		return waitsUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}

	public boolean verifySignupLink() {
		return elementsUtil.doIsDisplayed(signupLink);
	}

	public HomePage doLogin(String username, String password) {
		waitsUtil.waitForElementToBeVisible(this.username, 10);
		elementsUtil.doSendKeys(this.username, username);
		elementsUtil.doSendKeys(this.password, password);
		elementsUtil.doClick(this.loginButton);
		
		return new HomePage(driver);
	}

}
