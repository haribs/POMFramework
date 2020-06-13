package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.hubspot.pages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public BasePage basePage;
	public LoginPage loginPage;
	public Properties properties;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();

		driver = basePage.init_browser(properties);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
