package org.flipkart.tests;

import org.flipkart.generic.ExtentTestManager;
import org.flipkart.pageObject.LoginPopupPageObject;
import org.flipkart.setup.BaseTest;
import org.testng.annotations.Test;

public class LoginPopupTest extends BaseTest{
	
	@Test(priority = 1)
	public void verifyPresenceOfLoginPopup() {
		LoginPopupPageObject loginPopupPageObject = new LoginPopupPageObject();
		ExtentTestManager.startTest("verifyPresenceOfLoginPopup", "Test1");
		loginPopupPageObject.verifyPresenceOfLoginPopup();
	}
	
	@Test(priority = 2, dependsOnMethods = "verifyPresenceOfLoginPopup")
	public void closeLoginPopup() {
		LoginPopupPageObject loginPopupPageObject = new LoginPopupPageObject();
		ExtentTestManager.startTest("closeLoginPopup", "Test2");
		loginPopupPageObject.closeLoginPopup();
	}

}
