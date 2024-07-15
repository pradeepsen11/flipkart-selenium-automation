package org.flipkart.pageObject;

import org.apache.log4j.Logger;
import org.flipkart.generic.ExtentTestManager;
import org.flipkart.generic.GenericFunctions;
import org.flipkart.page.SearchPage;
import org.flipkart.setup.BaseTest;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class SearchPageObject extends BaseTest {

	SearchPage searchPage = new SearchPage(driver);
	static Logger log = Logger.getLogger(SearchPage.class.getName());

	public void verifyPresenceOfSearchOptions() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Checking the presence of search box");
			Assert.assertTrue(searchPage.searchBox.isDisplayed());
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Checking the presence of search button");
			Assert.assertTrue(searchPage.searchButton.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while Checking the presence of search Options");
			log.error("Exception in the method verifyPresenceOfSearchOptions");
			Assert.fail("Failed while Checking the presence of search OptionsFailed while searching the product");
		}
	}
	
	public void searchProduct(String productName) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Enter product name");
			searchPage.searchBox.sendKeys(productName);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on search button");
			searchPage.searchButton.click();
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while searching the product");
			log.error("Exception in the method searchProduct");
			Assert.fail("Failed while searching the product");
		}
	}
	
	public void validateSearchResponse(Boolean condition) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validating response");
			Assert.assertTrue(condition);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on flipkart logo button");
			searchPage.flipkartLogo.click();
			GenericFunctions.waitWebDriver(1000);
			//Again clicking on logo so that if login popup appears, it will get closed
			GenericFunctions.clickByCordinates(40, 160);
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while validating search response");
			log.error("Exception in the method validateSearchResponse");
			Assert.fail("Failed while validating search response");
		}
	}

}
