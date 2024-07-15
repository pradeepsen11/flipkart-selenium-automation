package org.flipkart.pageObject;

import org.apache.log4j.Logger;
import org.flipkart.generic.ExtentTestManager;
import org.flipkart.generic.GenericFunctions;
import org.flipkart.page.HeaderNavigationPage;
import org.flipkart.setup.BaseTest;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class HeaderNavigationPageObject extends BaseTest {

	HeaderNavigationPage headerNavigationPage = new HeaderNavigationPage(driver);
	static Logger log = Logger.getLogger(HeaderNavigationPage.class.getName());

	public void verifyFlipkartHomeNavigation() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Appliances");
			headerNavigationPage.appliancesIcon.click();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Flipkart Logo");
			headerNavigationPage.flipkartLogo.click();
			GenericFunctions.waitWebDriver(1000);
			//Again clicking on logo so that if login popup appears, it will get closed
			GenericFunctions.clickByCordinates(40, 160);
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyFlipkartHomeNavigation");
			Assert.assertTrue(headerNavigationPage.appliancesIcon.isDisplayed());
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart home Navigation is working fine");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while clicking on Flipkart Logo");
			log.error("Exception in the method verifyFlipkartHomeNavigation");
			Assert.fail("Failed while clicking on Flipkart Logo");
		}
	}
	
	public void verifyFlipkartPlusNavigation() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Appliances");
			headerNavigationPage.appliancesIcon.click();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Flipkart Plus Icon");
			headerNavigationPage.plusIcon.click();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyFlipkartPlusNavigation");
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().endsWith("/plus"));
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate back to Flipkart Home");
			headerNavigationPage.flipkartLogo.click();
			GenericFunctions.waitWebDriver(1000);
			//Again clicking on logo so that if login popup appears, it will get closed
			GenericFunctions.clickByCordinates(40, 160);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart plus Navigation is working fine");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while clicking on Flipkart Plus Icon");
			log.error("Exception in the method verifyFlipkartPlusNavigation");
			Assert.fail("Failed while clicking on Flipkart Plus Icon");
		}
	}
	
	public void verifyLoginPageNavigation() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on login icon");
			headerNavigationPage.loginIcon.click();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyLoginPageNavigation");
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/account/login"));
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate back to Flipkart Home");
			headerNavigationPage.flipkartLogo.click();
			GenericFunctions.waitWebDriver(1000);
			//Again clicking on logo so that if login popup appears, it will get closed
			GenericFunctions.clickByCordinates(40, 160);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Login Page Navigation is working fine");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while navigating to login page");
			log.error("Exception in the method verifyLoginPageNavigation");
			Assert.fail("Failed while navigating to login page");
		}
	}
	
	public void verifyCartNavigation() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Cart");
			headerNavigationPage.cartIcon.click();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyCartNavigation");
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/viewcart"));
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate back to Flipkart Home");
			headerNavigationPage.flipkartLogo.click();
			GenericFunctions.waitWebDriver(1000);
			//Again clicking on logo so that if login popup appears, it will get closed
			GenericFunctions.clickByCordinates(40, 160);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Cart Navigation is working fine");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while clicking on Flipkart Plus Icon");
			log.error("Exception in the method verifyCartNavigation");
			Assert.fail("Failed while clicking on Flipkart Plus Icon");
		}
	}
	
	public void verifyBecomeASellerNavigation() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on BecomeASeller");
			headerNavigationPage.becomeASellerIcon.click();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyBecomeASellerNavigation");
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/sell-online"));
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate back to Flipkart Home");
			driver.navigate().back();
			GenericFunctions.waitWebDriver(1000);
			//Again clicking on logo so that if login popup appears, it will get closed
			GenericFunctions.clickByCordinates(40, 160);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart become a seller page navigation is working fine");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while navigating to become a seller page");
			log.error("Exception in the method verifyBecomeASellerNavigation");
			Assert.fail("Failed while navigating to become a seller page");
		}
	}
	
	public void verifyNotificationPreferenceNavigation() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Hover over more help icon");
			GenericFunctions.hoverOverElement(headerNavigationPage.moreHelpLinksIcon);
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Notification Preference icon");
			headerNavigationPage.notificationPreferenceIcon.click();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyNotificationPreferenceNavigation");
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/communication-preferences/push"));
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate back to Flipkart Home");
			headerNavigationPage.flipkartLogo.click();
			GenericFunctions.waitWebDriver(1000);
			//Again clicking on logo so that if login popup appears, it will get closed
			GenericFunctions.clickByCordinates(40, 160);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Notification Preference Navigation is working fine");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while navigating to Notification Preference page");
			log.error("Exception in the method verifyNotificationPreferenceNavigation");
			Assert.fail("Failed while navigating to Notification Preference page");
		}
	}
	
	public void verifyCustomerCarePageNavigation() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Hover over more help icon");
			GenericFunctions.hoverOverElement(headerNavigationPage.moreHelpLinksIcon);
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Customer Care icon");
			headerNavigationPage.customerCareIcon.click();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyCustomerCarePageNavigation");
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().endsWith("/helpcentre"));
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate back to Flipkart Home");
			headerNavigationPage.flipkartLogo.click();
			GenericFunctions.waitWebDriver(1000);
			//Again clicking on logo so that if login popup appears, it will get closed
			GenericFunctions.clickByCordinates(40, 160);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Customer Care Navigation is working fine");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while navigating to Customer Care page");
			log.error("Exception in the method verifyCustomerCarePageNavigation");
			Assert.fail("Failed while navigating to Customer Care page");
		}
	}
	
	public void verifyAdvertisePageNavigation() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Hover over more help icon");
			GenericFunctions.hoverOverElement(headerNavigationPage.moreHelpLinksIcon);
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Advertise icon");
			headerNavigationPage.advertiseIcon.click();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyAdvertisePageNavigation");
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().startsWith("https://advertising.flipkart.com/login"));
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate back to Flipkart Home");
			driver.navigate().back();
			GenericFunctions.waitWebDriver(1000);
			//Again clicking on logo so that if login popup appears, it will get closed
			GenericFunctions.clickByCordinates(40, 160);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Advertise Navigation is working fine");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while navigating to Advertise page");
			log.error("Exception in the method verifyAdvertisePageNavigation");
			Assert.fail("Failed while navigating to Advertise page");
		}
	}
	
	public void verifyDownloadAppPageNavigation() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Hover over more help icon");
			GenericFunctions.hoverOverElement(headerNavigationPage.moreHelpLinksIcon);
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Download App icon");
			headerNavigationPage.downloadAppIcon.click();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyDownloadAppPageNavigation");
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/mobile-apps"));
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate back to Flipkart Home");
			headerNavigationPage.flipkartLogo.click();
			GenericFunctions.waitWebDriver(1000);
			//Again clicking on logo so that if login popup appears, it will get closed
			GenericFunctions.clickByCordinates(40, 160);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Download App Navigation is working fine");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while navigating to Download App page");
			log.error("Exception in the method verifyDownloadAppPageNavigation");
			Assert.fail("Failed while navigating to Download App page");
		}
	}

}
