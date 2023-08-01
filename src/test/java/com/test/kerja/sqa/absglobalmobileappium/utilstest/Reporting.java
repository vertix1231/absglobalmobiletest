package com.test.kerja.sqa.absglobalmobileappium.utilstest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting {
	
	ExtentSparkReporter htmlreporter;
	protected ExtentReports extentReports;
	@BeforeSuite
	public void reportSetup() {
		htmlreporter = new ExtentSparkReporter("src/test/resources/report_mobiletest_appium_teskerja.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlreporter);
	}
	
	@AfterSuite
	public void reportTeardown() {
		extentReports.flush();
	}

}
