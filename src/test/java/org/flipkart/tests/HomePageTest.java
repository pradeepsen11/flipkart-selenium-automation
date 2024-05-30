package org.flipkart.tests;

import org.flipkart.pageObject.HomePageObject;
import org.flipkart.setup.BaseTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
	

	@Test
    public void test() {
        HomePageObject homePageObject = new HomePageObject(driver);
//        homePageObject.closeLoginPopup();
        homePageObject.searchProduct("Realme Phone");
    }

}
