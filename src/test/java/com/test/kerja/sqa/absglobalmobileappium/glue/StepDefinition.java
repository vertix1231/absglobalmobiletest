package com.test.kerja.sqa.absglobalmobileappium.glue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.kerja.sqa.absglobalmobileappium.config.AutomationFrameworkConfiguration;
import com.test.kerja.sqa.absglobalmobileappium.driver.DriverSingleton;
import com.test.kerja.sqa.absglobalmobileappium.scenariopage.FungsiApp;
import com.test.kerja.sqa.absglobalmobileappium.utils.ConfigurationProperties;
import com.test.kerja.sqa.absglobalmobileappium.utils.ScenarioTestCases;
import com.test.kerja.sqa.absglobalmobileappium.utils.UtilsTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition  {
//	private static WebDriver driverWeb;
	private ExtentTest extentTest;
	static ExtentReports extentReports = new ExtentReports();
//	static ExtentSparkReporter htmlreporter = new ExtentSparkReporter("src/test/resources/stepdef_report_mobiletest_appium_teskerja_stepdef.html");
	static ExtentSparkReporter htmlreporter = new ExtentSparkReporter("src/test/resources/stepdef_report_mobiletest_appium_teskerja_stepdeffix_pass.html");
	private static AppiumDriver<MobileElement> driver;
	private static FungsiApp fungsiApp;

//start WEB TEST KERJA---------------------------------------------------------------------------------------------------------------------

//MULAI TESTSTING TEST KERJA-------------------------------------------------------------------------------------------------------------------
	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void workSetUp() {
		DriverSingleton driverSingleton =DriverSingleton.getInstance();
		driver = driverSingleton.getDriver();
		System.out.println("Appium Testing started...");
		fungsiApp = new FungsiApp();
		extentReports.attachReporter(htmlreporter);
		ScenarioTestCases[] tests = ScenarioTestCases.values();
		extentTest = extentReports.createTest(tests[UtilsTest.scenariotestcount].getScenarioTestName());
		UtilsTest.scenariotestcount++;
	}

//---------------------------------------------------------------------------------------------------------------------

	@Given("^Go to Contacts App")
	public void workZero() throws IOException {
//		System.out.println("Go to " + fungsiApp.getmainContactTitle()+" App pass");
//		extentTest.log(Status.PASS, "Go to " + fungsiApp.getmainContactTitle()+" App");
//		extentTest.log(Status.PASS, "Go to Contacts App");
		if (fungsiApp.getmainContactTitle().contains(configurationProperties.getMainContactTitle())) {
			System.out.println("Go to " + fungsiApp.getmainContactTitle()+" App pass");
			extentTest.log(Status.PASS, "Go to " + fungsiApp.getmainContactTitle()+" App");
		} else {
			System.out.println("Go to " + fungsiApp.getmainContactTitle()+" App fail");
			extentTest.fail("Go to " + fungsiApp.getmainContactTitle()+" App",
					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
		}

	}

	@When("^Click search button")
	public void workOne() throws IOException {
		fungsiApp.formClick();
		System.out.println("Click search button");
		extentTest.log(Status.PASS, "Click search button");

	}

	@Then("^input contact name (.*) in search contact button")
	public void workTwo(String name) throws IOException {
		fungsiApp.formInputNameContact(name);
		if (fungsiApp.getselectedContactTitleTitle().contains(configurationProperties.getSelectedContactTitleTitle())) {
			System.out.println("input contact name "+name+" in search contact button pass");
			extentTest.log(Status.PASS, "input contact name "+name+" in search contact button");
		} else {
			System.out.println("input contact name "+name+" in search contact button fail");
			extentTest.fail("input contact name "+name+" in search contact button",
					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
		}

	}
	@When("^click contact that want to be selected one of the research results")
	public void workTwoo() throws IOException {
		fungsiApp.selectedContactClick();
		System.out.println("click contact that want to be selected one of the research results");
		extentTest.log(Status.PASS, "click contact that want to be selected one of the research results");
	}

	@Then("^Directing to Next Page Detail Selected Contact Information with (.*)")
	public void workThree(String name) throws IOException {
		if (fungsiApp.getdetailnumberselectedContactTitle().contains(configurationProperties.getDetailnumberselectedContactTitle())) {
			System.out.println(fungsiApp.getdetailnumberselectedContactTitle());
			System.out.println("Directing to Next Page Detail Selected Contact Information with "+name+" pass");
			extentTest.log(Status.PASS, "Directing to Next Page Detail Selected Contact Information with "+name);
		} else {
			System.out.println(fungsiApp.getdetailnumberselectedContactTitle());
			System.out.println("Directing to Next Page Detail Selected Contact Information with "+name+" fail");
			extentTest.fail("Directing to Next Page Detail Selected Contact Information with "+name,
					MediaEntityBuilder.createScreenCaptureFromPath(failcaptureScreen()).build());
		}
	}

	@After
	public void closeObject() {
		extentReports.flush();
	}

//CAPTURE FAIL PHOTO TESTING
	public String failcaptureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = "C:\\Users\\ACER\\Desktop\\JCCODING\\sqa\\com.test.kerja.sqa.coretcobacoba.sqamobileappiumjavabdd\\src\\test\\resources\\failevidence\\"
				+ getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "-").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
