package com.qa.utils;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsUtil {
	WebDriver driver;

	public WaitsUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used for wait for element to be present in DOM and nothing to
	 * do with the visibility of the element on the page
	 * 
	 * @param locator
	 * @param waitTime
	 * @return element
	 */
	public WebElement waitForElementPresence(By locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}

	/**
	 * This method is used for wait for element to be visible on the screen
	 * 
	 * @param locator
	 * @param waitTime
	 * @return element
	 */
	public WebElement waitForElementToBeVisible(By locator, int waitTime) {
		ElementsUtil elementUtil = new ElementsUtil(driver);
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elementUtil.getElement(locator)));
		return element;
	}

	/**
	 * This method is used for wait for element to be clickable, primarily used for
	 * buttons and link clicking
	 * 
	 * @param locator
	 * @param waitTime
	 * @return element
	 */
	public WebElement waitForElementToBeClickable(By locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}

	/**
	 * This method is used for, wait for getting the current url after the page is
	 * completely loaded if a the specific string is found in the url
	 * 
	 * @param str
	 * @param waitTime
	 * @return url
	 */
	public Boolean waitForGetURL(String str, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		return wait.until(ExpectedConditions.urlContains(str));
	}

	/**
	 * This method is used for, wait for alert to be displayed
	 * 
	 * @param waitTime
	 * @return alert
	 */
	public Alert waitForAlertToBeDisplayedL(int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;

	}

	/**
	 * This method is used for, wait and click the element when ready instead of
	 * returning the element, primarily used for buttons and link clicking.
	 * 
	 * @param locator
	 * @param waitTime
	 */
	public void waitAndClickWhenReady(By locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

//	/**
//	 * This method is used for finding whether the given word is present in the
//	 * browser title or not
//	 * 
//	 * @param title
//	 * @param waitTime
//	 */
//	public Boolean waitForTitleToBeDisplayed(String title, int waitTime) {
//		WebDriverWait wait = new WebDriverWait(driver, waitTime);
//		return wait.until(ExpectedConditions.titleContains(title));
//	}

	/**
	 * This method is used for returning the page title after given wait time.
	 * @param title
	 * @param waitTime
	 * @return title
	 */
	public String waitForTitleToBePresent(String title, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	/**
	 * This method is used for, wait until all the elements are visible
	 * @param locator
	 * @param waitTime
	 * @return
	 */
	public List<WebElement> waitForVisiblityOfAllElements(By locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
}
