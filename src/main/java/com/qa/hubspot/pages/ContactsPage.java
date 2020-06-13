package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.utils.Constants;
import com.qa.utils.ElementsUtil;
import com.qa.utils.JavaScriptUtil;
import com.qa.utils.WaitsUtil;

public class ContactsPage {

	private WebDriver driver;
	private ElementsUtil elementsUtil;
	private WaitsUtil waitsUtil;
	private JavaScriptUtil jsUtil;
	
	By contactsPageHeader = By.xpath("//h1");
	By createContactPrimary = By.xpath("//span[text()='Create contact']");
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By createContactSecodary = By.xpath("(//span[text()='Create contact'])[last()]");
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementsUtil = new ElementsUtil(this.driver);
		waitsUtil = new WaitsUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	public String getContactsPageTitle() {
		return waitsUtil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 10);
	}
	
	public String getContactsPageHeader() {
		waitsUtil.waitForElementToBeVisible(contactsPageHeader, 10);
		return elementsUtil.doGetText(contactsPageHeader);
	}
	
	public void createContact(String email, String firstName, String lastName, String jobTitle) {
		waitsUtil.waitAndClickWhenReady(createContactPrimary, 10);
		
		waitsUtil.waitForElementToBeVisible(this.email, 5);
		elementsUtil.doSendKeys(this.email, email);
		elementsUtil.doSendKeys(this.firstName, firstName);
		elementsUtil.doSendKeys(this.lastName, lastName);
		
		waitsUtil.waitForElementToBeVisible(this.jobTitle, 5);
		elementsUtil.doSendKeys(this.jobTitle, jobTitle);

		WebElement ele = driver.findElement(createContactSecodary);
		jsUtil.clickElementByJS(ele);
		//elementsUtil.doClick(createContactSecodary);
		//waitsUtil.waitAndClickWhenReady(createContactSecodary, 5);
		
		
		
	}
}
