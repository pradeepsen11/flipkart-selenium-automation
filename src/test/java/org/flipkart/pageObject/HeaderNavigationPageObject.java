package org.flipkart.pageObject;

import org.apache.log4j.Logger;
import org.flipkart.generic.ExtentTestManager;
import org.flipkart.generic.GenericFunctions;
import org.flipkart.page.HeaderNavigationPage;
import org.flipkart.setup.BaseTest;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class HeaderNavigationPageObject extends BaseTest {

	HeaderNavigationPage headerNavigationPage = new HeaderNavigationPage(driver);
	static Logger log = Logger.getLogger(HeaderNavigationPage.class.getName());
	
	public void clickOnFlipkartLogo() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on flipkart logo button");
			headerNavigationPage.flipkartLogo.click();
		} catch (ElementClickInterceptedException e) {
			headerNavigationPage.loginPopupCancelButton.click();
			driver.navigate().refresh();
			GenericFunctions.waitForElementClickable(headerNavigationPage.flipkartLogo);
			headerNavigationPage.flipkartLogo.click();
		} catch  (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while clicking on flipkart logo");
			log.error("Exception in the method clickOnFlipkartLogo");
			Assert.fail("Failed while clicking on flipkart logo");
		}
	}

	public void verifyFlipkartHomeNavigation() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Appliances");
			headerNavigationPage.appliancesIcon.click();

			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Flipkart Logo");
			clickOnFlipkartLogo();

			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyFlipkartHomeNavigation");
			Assert.assertTrue(headerNavigationPage.appliancesIcon.isDisplayed());
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart home Navigation is working fine");
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
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
			clickOnFlipkartLogo();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart plus Navigation is working fine");
		} catch (ElementClickInterceptedException e) {
			headerNavigationPage.loginPopupCancelButton.click();
			driver.navigate().refresh();
			clickOnFlipkartLogo();
			headerNavigationPage.appliancesIcon.click();
			GenericFunctions.waitForElementClickable(headerNavigationPage.plusIcon);
			headerNavigationPage.plusIcon.click();
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().endsWith("/plus"));
			clickOnFlipkartLogo();
		}catch (StaleElementReferenceException e) {
			driver.navigate().back();
			GenericFunctions.waitWebDriver(2000);
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
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
			clickOnFlipkartLogo();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Login Page Navigation is working fine");
		} catch (ElementClickInterceptedException e) {
			headerNavigationPage.loginPopupCancelButton.click();
			driver.navigate().refresh();
			GenericFunctions.waitForElementClickable(headerNavigationPage.loginIcon);
			headerNavigationPage.loginIcon.click();
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/account/login"));
			clickOnFlipkartLogo();
		} catch (StaleElementReferenceException e) {
			driver.navigate().back();
			GenericFunctions.waitWebDriver(2000);
			headerNavigationPage.loginIcon.click();
			Assert.assertTrue(driver.getCurrentUrl().contains("/account/login"));
			clickOnFlipkartLogo();
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
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
			clickOnFlipkartLogo();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Cart Navigation is working fine");
		} catch (ElementClickInterceptedException e) {
			headerNavigationPage.loginPopupCancelButton.click();
			driver.navigate().refresh();
			GenericFunctions.waitForElementClickable(headerNavigationPage.cartIcon);
			headerNavigationPage.cartIcon.click();
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/viewcart"));
			clickOnFlipkartLogo();
		} catch (StaleElementReferenceException e) {
			driver.navigate().back();
			GenericFunctions.waitWebDriver(2000);
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while clicking on Cart");
			log.error("Exception in the method verifyCartNavigation");
			Assert.fail("Failed while clicking on Cart");
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
			clickOnFlipkartLogo();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart become a seller page navigation is working fine");
		} catch (ElementClickInterceptedException e) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Cancle Login Popup and refresh page");
			headerNavigationPage.loginPopupCancelButton.click();
			driver.navigate().refresh();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on BecomeASeller");
			headerNavigationPage.becomeASellerIcon.click();

			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyBecomeASellerNavigation");
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/sell-online"));

			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate back to Flipkart Home");
			driver.navigate().back();
			clickOnFlipkartLogo();
		} catch (StaleElementReferenceException e) {
			driver.navigate().back();
			GenericFunctions.waitWebDriver(2000);
		} catch (Exception e) {
			e.printStackTrace();
			driver.navigate().back();
			clickOnFlipkartLogo();
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
			clickOnFlipkartLogo();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Notification Preference Navigation is working fine");
		} catch (ElementClickInterceptedException e) {
			driver.navigate().refresh();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Hover over more help icon");
			GenericFunctions.hoverOverElement(headerNavigationPage.moreHelpLinksIcon);

			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Notification Preference icon");
			headerNavigationPage.notificationPreferenceIcon.click();

			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate verifyNotificationPreferenceNavigation");
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/communication-preferences/push"));

			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate back to Flipkart Home");
			clickOnFlipkartLogo();
		} catch (StaleElementReferenceException e) {
			driver.navigate().back();
			GenericFunctions.waitWebDriver(2000);
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
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
			clickOnFlipkartLogo();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Customer Care Navigation is working fine");
		} catch (ElementClickInterceptedException e) {
			driver.navigate().refresh();
			GenericFunctions.hoverOverElement(headerNavigationPage.moreHelpLinksIcon);
			GenericFunctions.waitForElementClickable(headerNavigationPage.customerCareIcon);
			headerNavigationPage.customerCareIcon.click();
			clickOnFlipkartLogo();
		} catch (StaleElementReferenceException e) {
			driver.navigate().back();
			GenericFunctions.waitWebDriver(2000);
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
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
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Advertise Navigation is working fine");
		} catch (ElementClickInterceptedException e) {
			driver.navigate().refresh();
			GenericFunctions.hoverOverElement(headerNavigationPage.moreHelpLinksIcon);
			GenericFunctions.waitForElementClickable(headerNavigationPage.advertiseIcon);
			headerNavigationPage.advertiseIcon.click();
			driver.navigate().back();
			clickOnFlipkartLogo();
		} catch (StaleElementReferenceException e) {
			driver.navigate().back();
			GenericFunctions.waitWebDriver(2000);
		} catch (Exception e) {
			e.printStackTrace();
			driver.navigate().back();
			clickOnFlipkartLogo();
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
			clickOnFlipkartLogo();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Flipkart Download App Navigation is working fine");
		} catch (ElementClickInterceptedException e) {
			driver.navigate().refresh();
			GenericFunctions.hoverOverElement(headerNavigationPage.moreHelpLinksIcon);
			GenericFunctions.waitForElementClickable(headerNavigationPage.downloadAppIcon);
			headerNavigationPage.downloadAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/mobile-apps"));
			clickOnFlipkartLogo();
		} catch (StaleElementReferenceException e) {
			driver.navigate().back();
			GenericFunctions.waitWebDriver(2000);
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while navigating to Download App page");
			log.error("Exception in the method verifyDownloadAppPageNavigation");
			Assert.fail("Failed while navigating to Download App page");
		}
	}

}
