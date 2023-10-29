package com.w2a.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.endpoints.BankDemoSiteEndPoints;

public class W2aCoreTest {
		
	
	public static WebDriver driver;
	public static Properties config;
	public static FileInputStream fis;
	public static String url;
	protected static Logger log;

	@BeforeSuite
	public void setup() throws IOException {
		String currentDir = System.getProperty("user.dir");
		
		LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        File file = new File(currentDir +"/src/test/resources/properties/log4j2.properties");
        context.setConfigLocation(file.toURI());
        
        log = LogManager.getLogger(W2aCoreTest.class);
		
	
		if (driver == null) {
			Properties config  = new Properties();
			FileInputStream fis = new FileInputStream(currentDir + "/src/test/resources/properties/Config.properties");
			
			config.load(fis);
			log.debug("Config file has been loaded");
			String browser = config.getProperty("browser");
			
			WebDriverFactory factory = new WebDriverFactory(browser);
			driver = factory.createDriver();
			
			url = BankDemoSiteEndPoints.v3;
			driver.get(config.getProperty("baseUrl")+ url);
			log.info("Reaching the url...");
		}
		}
	
	@AfterSuite
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
}
