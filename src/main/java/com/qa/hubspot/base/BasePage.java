package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.utils.ElementsUtil;
import com.qa.utils.WaitsUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties properties;
	protected ElementsUtil elementsUtil;
	protected WaitsUtil waitsUtil;

	public WebDriver init_browser(Properties properties) {
		
		String browserName =properties.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get(properties.getProperty("url"));

		return driver;
	}

	public Properties init_properties() {

		properties = new Properties();
		try {
			// FileInputStream fileStream = new
			// FileInputStream("C:\\Users\\harib\\PracticeWS\\POMLearning\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			FileInputStream fileStream = new FileInputStream(
					".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			properties.load(fileStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
