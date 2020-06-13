package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.utils.Constants;
import com.qa.utils.ElementsUtil;
import com.qa.utils.WaitsUtil;

public class HomePage extends BasePage {

	private WebDriver driver;

	By homePageHeader = By.cssSelector("h1.dashboard-selector__title");
	By accountName = By.cssSelector("span.account-name ");
	
	By contactsParent = By.id("nav-primary-contacts-branch");
	By contactsChild = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementsUtil = new ElementsUtil(this.driver);
		waitsUtil = new WaitsUtil(driver);
	}

	public String getHomePageTitle() {
		return waitsUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}

	public String getHomePageHeaderText() {
		if (elementsUtil.doIsDisplayed(homePageHeader)) {
			return elementsUtil.doGetText(homePageHeader);
		}
		return null;
	}

	public String getLoggedInUser() {
		if (elementsUtil.doIsDisplayed(accountName)) {
			return elementsUtil.doGetText(accountName);
		}
		return null;
	}

	public ContactsPage gotoContactsPage() {
		clickOnConcatsLlink();
		return new ContactsPage(driver);
	}
	
	private void clickOnConcatsLlink() {
		waitsUtil.waitForElementToBeVisible(contactsParent, 10);
		elementsUtil.doClick(contactsParent);
		waitsUtil.waitForElementToBeVisible(contactsChild, 5);
		elementsUtil.doClick(contactsChild);
	}
}
