package org.flipkart.tests;

import org.flipkart.generic.ExtentTestManager;
import org.flipkart.pageObject.HomePageObject;
import org.flipkart.setup.BaseTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

	@Test(priority = 1)
	public void closeLoginPopup() {
		HomePageObject homePageObject = new HomePageObject(driver);
		ExtentTestManager.startTest("closeLoginPopup", "Test1");
		homePageObject.closeLoginPopup();
	}

	@Test(priority = 2)
	public void searchProduct() {
		HomePageObject homePageObject = new HomePageObject(driver);
		ExtentTestManager.startTest("searchProduct", "Test2");
		homePageObject.searchProduct("Realme Phone");
	}
	
}
