package com.test.kerja.sqa.absglobalmobileappium.driver;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Android implements DriverStrategy{

	public AppiumDriver<MobileElement> setStrategy() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Pixel_2_API_27");
		capabilities.setCapability("uuid", "emulator-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "8.1.0");
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
//		capabilities.setCapability("appActivity", "com.android.contacts.activities.ContactSelectionActivity");
//		capabilities.setCapability("appActivity", "com.android.contacts.activities.ContactsFrontDoor");
//		capabilities.setCapability("appActivity", "com.android.contacts.activities.LicenseFrontDoor");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(url, capabilities);
		
		return driver;
	}

}
