package com.test.kerja.sqa.absglobalmobileappium.scenariopage;

import org.openqa.selenium.support.PageFactory;

import com.test.kerja.sqa.absglobalmobileappium.driver.DriverSingleton;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FungsiApp {

	private AppiumDriver<MobileElement> driver;

	public FungsiApp() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.android.contacts:id/menu_search")
	private MobileElement btnSrc;
	@AndroidFindBy(id = "com.android.contacts:id/search_view")
	private MobileElement formInputName;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup")
	private MobileElement selectContact;
	@AndroidFindBy(xpath = "t.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	private MobileElement mainContactTitle;
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Irsyad Gw\"]")
	private MobileElement selectedContactTitle;
	
	public String getselectedContactTitleTitle() {
		return selectedContactTitle.getText();
	}
	public String getmainContactTitle() {
		return mainContactTitle.getText();
	}
	public void formClick() {
		btnSrc.click();
	}
	public void formInputNameContact(String name) {
		formInputName.sendKeys(name);
	}
	public void selectedContactClick() {
		selectContact.click();
	}
//    @AndroidFindBy(id = "com.android.calculator2:id/digit_1")
//    private MobileElement btnSatu;
//    @AndroidFindBy(id = "com.android.calculator2:id/digit_2")
//    private MobileElement btnDua;
//    @AndroidFindBy(id = "com.android.calculator2:id/op_add")
//    private MobileElement btnTambah;
//    @AndroidFindBy(id = "com.android.calculator2:id/eq")
//    private MobileElement btnSamaDengan;
//    @AndroidFindBy(id = "com.android.calculator2:id/result")
//    private MobileElement hasil;
//    @AndroidFindBy(id = "com.android.calculator2:id/digit_3")
//    private MobileElement btnTiga;
//    @AndroidFindBy(id = "com.android.calculator2:id/digit_4")
//    private MobileElement btnEmpat;
//    @AndroidFindBy(id = "com.android.calculator2:id/op_mul")
//    private MobileElement btnKali;
//
//    
//	public void pertambahan() {
//		btnSatu.click();
//		btnTambah.click();
//		btnDua.click();
//		btnSamaDengan.click();
//	}
//
//	public void perkalian() {
//
//		btnTiga.click();
//		btnKali.click();
//		btnEmpat.click();
//		btnSamaDengan.click();
//	}

}
