package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.utils.Constants;

public class ContactsPageTest extends BaseTest {

	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeClass
	public void contactsPageSetup() {
		homePage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		contactsPage = homePage.gotoContactsPage();		
	}
	
	@Test(priority=1)
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("Contacts Page Title is..." + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyCreateContactTest() {
		contactsPage.createContact("rahul@gmail.com", "Rahul", "Dravid", "CEO");
	}
}
