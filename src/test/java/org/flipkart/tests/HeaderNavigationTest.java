package org.flipkart.tests;

import org.flipkart.generic.ExtentTestManager;
import org.flipkart.pageObject.HeaderNavigationPageObject;
import org.flipkart.setup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class HeaderNavigationTest extends BaseTest {
	
	@Test(priority=1)
	public void verifyFlipkartHomeNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyFlipkartHomeNavigation", "Test3");
		headerNavigationPageObject.verifyFlipkartHomeNavigation();
	}
	
	@Test(priority=2)
	public void verifyFlipkartPlusNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyFlipkartPlusNavigation", "Test4");
		headerNavigationPageObject.verifyFlipkartPlusNavigation();
	}
	
	@Test(priority=3)
	public void verifyLoginPageNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyLoginPageNavigation", "Test5");
		headerNavigationPageObject.clickOnFlipkartLogo();
		headerNavigationPageObject.verifyLoginPageNavigation();
		headerNavigationPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority=4)
	public void verifyCartNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyCartNavigation", "Test6");
		headerNavigationPageObject.clickOnFlipkartLogo();
		headerNavigationPageObject.verifyCartNavigation();
		headerNavigationPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority=5)
	public void verifyBecomeASellerNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyBecomeASellerNavigation", "Test7");
		headerNavigationPageObject.clickOnFlipkartLogo();
		headerNavigationPageObject.verifyBecomeASellerNavigation();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating Back");
		driver.navigate().back();
	}
	
	@Test(priority=6)
	public void verifyNotificationPreferenceNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyNotificationPreferenceNavigation", "Test8");
		headerNavigationPageObject.clickOnFlipkartLogo();
		headerNavigationPageObject.verifyNotificationPreferenceNavigation();
		headerNavigationPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority=7)
	public void verifyCustomerCarePageNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyCustomerCarePageNavigation", "Test9");
		headerNavigationPageObject.clickOnFlipkartLogo();
		headerNavigationPageObject.verifyCustomerCarePageNavigation();
		headerNavigationPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority=8)
	public void verifyAdvertisePageNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyAdvertisePageNavigation", "Test10");
		headerNavigationPageObject.clickOnFlipkartLogo();
		headerNavigationPageObject.verifyAdvertisePageNavigation();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating Back");
		driver.navigate().back();
	}
	
	@Test(priority=9)
	public void verifyDownloadAppPageNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyDownloadAppPageNavigation", "Test11");
		headerNavigationPageObject.clickOnFlipkartLogo();
		headerNavigationPageObject.verifyDownloadAppPageNavigation();
		headerNavigationPageObject.clickOnFlipkartLogo();
	}

}
