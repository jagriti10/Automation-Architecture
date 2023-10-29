package com.w2a.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.w2a.base.W2aCoreTest;

public class Listeners extends W2aCoreTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		log.info("This test has been started " + result.getName().toString().trim());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("This test has been successfully passed " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		log.info("This test has failed " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("This test has been skipped " + result.getInstanceName() +"/"+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		log.trace("The test has been started");
	}

	@Override
	public void onFinish(ITestContext context) {
		log.trace("The test has been finish");
	}
}
