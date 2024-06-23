package org.flipkart.pageObject;

import org.flipkart.generic.ExtentTestManager;
import org.flipkart.page.HomePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
<<<<<<< Updated upstream
import org.testng.log4testng.Logger;
=======
>>>>>>> Stashed changes

import com.relevantcodes.extentreports.LogStatus;

public class HomePageObject{

	WebDriver driver;
	HomePage homePage;
	static Logger log = Logger.getLogger(HomePage.class.getNestHost());

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		homePage=new HomePage(driver);;
	}

<<<<<<< Updated upstream
	public void closeLoginPopup() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Close login popup if appeared");
			homePage.loginPopupCancelButton.click();
		} catch (NoSuchElementException e) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Login popup did not appear");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while closing the login popup");
			log.error("Exception in the method closeLoginPopup");
			Assert.fail("Failed while closing the login popup");
		}
	}

	public void searchProduct(String productName) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Enter product name");
			homePage.searchBox.sendKeys(productName);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on search button");
			homePage.searchButton.click();
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while searching the product");
			log.error("Exception in the method searchProduct");
			Assert.fail("Failed while searching the product");
		}
	}
=======
    public void closeLoginPopup() {
    	//click on cancle button on login pop-up if displayed
    	try {
			if(homePage.loginPopupCancelButton.isDisplayed()) {
				homePage.loginPopupCancelButton.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Popup did not appear");
		}
    }

    public void searchProduct(String productName) {
    	try {
			//send search value
			homePage.searchBox.sendKeys(productName);
			//click on search button
			homePage.searchButton.click();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Failed while searching the product");
		}
    }
>>>>>>> Stashed changes
}
