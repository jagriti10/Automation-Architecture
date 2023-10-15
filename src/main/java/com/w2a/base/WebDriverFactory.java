package com.w2a.base;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class WebDriverFactory {
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	
	public WebDriverFactory(String browser) {
		this.browser = browser;
	}
	
	public WebDriver createDriver() {
		
		switch(browser) {
		case "chrome" : {
			
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless=new");
			options.addArguments("--start-maximized");
			driver.set(new ChromeDriver(options));
			break;
		}
		case "safari" :{
			
			driver.set(new SafariDriver());
			break;
		}
		case "firefox" : {
			
	        FirefoxOptions options = new FirefoxOptions();
	        options.addArguments("--start-maximized");
	        driver.set(new FirefoxDriver(options));
		}
		}
		return driver.get();
	}

}
