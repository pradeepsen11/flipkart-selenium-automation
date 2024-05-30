package org.flipkart.pageObject;

import org.flipkart.page.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageObject {

	WebDriver driver;
    HomePage homePage;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver); // Ensure HomePage elements are initialized
    }

    public void closeLoginPopup() {
        homePage.loginPopupCancelButton.click();
    }

    public void searchProduct(String productName) {
        homePage.searchBox.sendKeys(productName);
        homePage.searchButton.click();
        System.out.println("Clicked on search button");
    }
}
