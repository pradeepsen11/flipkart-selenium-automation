package org.flipkart.pageObject;

import org.apache.log4j.Logger;
import org.flipkart.generic.ExtentTestManager;
import org.flipkart.page.LoginPopupPage;
import org.flipkart.setup.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class LoginPopupPageObject extends BaseTest{
	
	LoginPopupPage loginPopupPage = new LoginPopupPage(driver);
	static Logger log = Logger.getLogger(LoginPopupPage.class.getName());
	
	public void verifyPresenceOfLoginPopup() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Checking the presence of Login Popup");
			loginPopupPage.loginPopup.isDisplayed();
		} catch (NoSuchElementException e) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Login popup did not appear");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while Checking the presence of Login Popup");
			log.error("Exception in the method verifyPresenceOfLoginPopup");
			Assert.fail("Failed while Checking the presence of Login Popup");
		}
	}
	
	public void closeLoginPopup() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Close login popup if appeared");
			loginPopupPage.loginPopupCancelButton.click();
		} catch (NoSuchElementException e) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Login popup did not appear");
//			Assert.fail("Failed while closing the login popup");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while closing the login popup");
			log.error("Exception in the method closeLoginPopup");
			Assert.fail("Failed while closing the login popup");
		}
	}

}
