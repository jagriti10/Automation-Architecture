package com.w2a.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.w2a.utilies.ExtentFileReporter;
import com.w2a.utilies.Screenshot;

public class Listeners extends Screenshot implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		log.info("This test has been started " + result.getName().toString().trim());
		ExtentFileReporter.startTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("This test has been successfully passed " + result.getName());
		ExtentFileReporter.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error " + result.getName() + " test has failed *****");

		 ITestContext context = result.getTestContext();
         driver = (WebDriver)context.getAttribute("driver");

		String testClassName = getTestClassName(result.getInstanceName()).trim();

		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + ".png";

		if (driver != null) {
			takeScreenShot(driver, screenShotName, testClassName);
			System.out.println("Screenshot can be found : " + imagePath);
		}
		
		ExtentFileReporter.getTest().fail("Screenshot",
				MediaEntityBuilder.createScreenCaptureFromPath(imagePath + testMethodName + ".png").build());
		ExtentFileReporter.getTest().log(Status.FAIL, "Failed with exception" + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("This test has been skipped " + result.getInstanceName() +"/"+result.getName());
		ExtentFileReporter.getTest().log(Status.SKIP, "Skipped with exception" + result.getThrowable());
	}

	public void onStart(ITestResult result) {
		log.trace("The test has been started");
		 ExtentFileReporter.startTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		log.trace("The test has been finish");
		ExtentFileReporter.endTest();
		ExtentFileReporter.getInstance().flush();
	}
}
