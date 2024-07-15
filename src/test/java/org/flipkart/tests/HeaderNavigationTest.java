package org.flipkart.tests;

import org.flipkart.generic.ExtentTestManager;
import org.flipkart.pageObject.HeaderNavigationPageObject;
import org.flipkart.setup.BaseTest;
import org.testng.annotations.Test;

public class HeaderNavigationTest extends BaseTest {
	
	@Test(priority=1)
	public void verifyFlipkartHomeNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyFlipkartHomeNavigation", "Test1");
		headerNavigationPageObject.verifyFlipkartHomeNavigation();
	}
	
	@Test(priority=2)
	public void verifyFlipkartPlusNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyFlipkartPlusNavigation", "Test2");
		headerNavigationPageObject.verifyFlipkartPlusNavigation();
	}
	
	@Test(priority=3)
	public void verifyLoginPageNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyLoginPageNavigation", "Test3");
		headerNavigationPageObject.verifyLoginPageNavigation();
	}
	
	@Test(priority=4)
	public void verifyCartNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyCartNavigation", "Test4");
		headerNavigationPageObject.verifyCartNavigation();
	}
	
	@Test(priority=5)
	public void verifyBecomeASellerNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyBecomeASellerNavigation", "Test5");
		headerNavigationPageObject.verifyBecomeASellerNavigation();
	}
	
	@Test(priority=6)
	public void verifyNotificationPreferenceNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyNotificationPreferenceNavigation", "Test6");
		headerNavigationPageObject.verifyNotificationPreferenceNavigation();
	}
	
	@Test(priority=7)
	public void verifyCustomerCarePageNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyCustomerCarePageNavigation", "Test7");
		headerNavigationPageObject.verifyCustomerCarePageNavigation();
	}
	
	@Test(priority=8)
	public void verifyAdvertisePageNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyAdvertisePageNavigation", "Test8");
		headerNavigationPageObject.verifyAdvertisePageNavigation();
	}
	
	@Test(priority=9)
	public void verifyDownloadAppPageNavigation() {
		HeaderNavigationPageObject headerNavigationPageObject = new HeaderNavigationPageObject();
		ExtentTestManager.startTest("verifyDownloadAppPageNavigation", "Test9");
		headerNavigationPageObject.verifyDownloadAppPageNavigation();
	}

}
