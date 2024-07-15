package org.flipkart.tests;

import org.apache.log4j.Logger;
import org.flipkart.generic.ExtentTestManager;
import org.flipkart.page.SearchPage;
import org.flipkart.pageObject.SearchPageObject;
import org.flipkart.setup.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
	SearchPage searchPage = new SearchPage(driver);
	static Logger log = Logger.getLogger(SearchPage.class.getName());
	
	@Test(priority = 1)
	public void verifyPresenceOfSearchOptions() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifyPresenceOfSearchOptions", "Test");
		searchPageObject.verifyPresenceOfSearchOptions();
		
	}
	
	@Test(priority = 2)
	public void verifySearchWithValidInput() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifySearchWithValidInput", "Test");
		searchPageObject.searchProduct("Realme 12x 5G");
		searchPageObject.validateSearchResponse(driver.findElement(By.xpath("//div[text() = 'realme 12x 5G (Twilight Purple, 128 GB)']")).isDisplayed());
	}
	
	@Test(priority = 3)
	public void verifySearchWithInvalidInput() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifySearchWithInvalidInput", "Test");
		searchPageObject.searchProduct("Rolome X12 5G");
		searchPageObject.validateSearchResponse(driver.findElement(By.xpath("//div[text() = 'realme 12x 5G (Twilight Purple, 128 GB)']")).isDisplayed());
	}

}
