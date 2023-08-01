package com.test.kerja.sqa.absglobalmobileappium.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverSingleton {
	
	private static DriverSingleton instance = null;
	private static AppiumDriver<MobileElement> driver;
	
	public DriverSingleton() {
		intantiate("android");
	}
	
	public AppiumDriver<MobileElement> intantiate (String strategy) {
		DriverStrategy driverStrategy = DriverStrategyImplementor.chooseStrategy(strategy);
		try {
			driver=driverStrategy.setStrategy();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver;
	}
	
	public static DriverSingleton getInstance() {
		if (instance==null) {
			instance =  new DriverSingleton();
		}
		
		return instance;
		
	}
	
	public static void closeObjectInstance() {
		instance=null;
		driver.quit();
	}
	
	public static AppiumDriver<MobileElement> getDriver() {
		return driver;
	}
	
}
