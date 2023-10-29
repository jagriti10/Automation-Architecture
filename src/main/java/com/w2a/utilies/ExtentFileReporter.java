package com.w2a.utilies;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentFileReporter {

	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extentReport;
	static ExtentSparkReporter spark;

	public static ExtentReports getInstance() {
		
		if(extentReport == null) {
			extentReport = new ExtentReports();
			spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/surefire-reports/extent-reports/extent.html");
			spark.config(
					ExtentSparkReporterConfig.builder()
						.theme(Theme.STANDARD)
						.documentTitle("Automation Test Report")
						.offlineMode(true)
						.reportName("Web tests")
						.timeStampFormat("dd.MM.yyyy, HH:mm:ss")
						.build());
			
			extentReport.setSystemInfo("Machine", "macOS");
			extentReport.attachReporter(spark);
		}
		return extentReport;
	}
	
	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extentReport.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
	
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}
	
	public static synchronized void endTest() {
		extentReport.flush();
	}
}
