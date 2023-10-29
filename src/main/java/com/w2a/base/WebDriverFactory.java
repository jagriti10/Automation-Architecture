package com.w2a.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;


public class WebDriverFactory extends W2aCoreTest {
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	
	public WebDriverFactory(String browser) {
		this.browser = browser;
	}
	
	public WebDriver createDriver() {
		
		switch(browser) {
		case "chrome" : {
			
			log.info("Launching Chrome...");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("--start-maximized");
			driver.set(new ChromeDriver(options));
			break;
		}
		case "safari" :{
			
			//log.info("Launching Safari...");
			driver.set(new SafariDriver());
			break;
		}
		case "firefox" : {
			
			//log.info("Launching Firefox...");
	        FirefoxOptions options = new FirefoxOptions();
	        options.addArguments("--start-maximized");
	        driver.set(new FirefoxDriver(options));
	        break;
		}
		}
		return driver.get();
	}

}
