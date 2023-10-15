package com.w2a.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.naveenautomationlabs.core.WebDriverFactory;
import com.naveenautomationlabs.products.endpoints.CodprogEndPoints;
import com.w2a.endpoints.BankDemoSiteEndPoints;

public class W2aCoreTest {
		
	
	public static WebDriver driver; //rn its null
	public static Properties config;
	public static FileInputStream fis;
	public static String url;
	

	@BeforeSuite
	public void setup() throws IOException {
			
		if (driver == null) {
			Properties config  = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/properties/Config.properties");
			
			config.load(fis);
			String browser = config.getProperty("browser");
			
			WebDriverFactory factory = new WebDriverFactory(browser);
			driver = factory.createDriver();
			
			url = BankDemoSiteEndPoints.v3;
			driver.get(config.getProperty("baseUrl")+ url);
		}
		}
	
	@AfterSuite
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
}
