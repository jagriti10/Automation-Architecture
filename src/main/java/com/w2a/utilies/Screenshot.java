package com.w2a.utilies;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.w2a.base.W2aCoreTest;

public class Screenshot extends W2aCoreTest implements ITestListener {

	protected static String imagePath = System.getProperty("user.dir") + "/test-output/Screenshots/Results/";

	public static String takeScreenShot(WebDriver driver, String screenShotName, String testName) {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(imagePath + testName + "/" + screenShotName);
		try {
			FileUtils.copyFile(screenshotFile, targetFile);
		} catch (IOException e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
		}
		return screenShotName;
	}

	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("/");
		return reqTestClassname[reqTestClassname.length - 1];
	}
}
