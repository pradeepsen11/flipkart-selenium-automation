package org.flipkart.tests;

import org.apache.log4j.Logger;
import org.flipkart.generic.ExtentTestManager;
import org.flipkart.page.SearchPage;
import org.flipkart.pageObject.SearchPageObject;
import org.flipkart.setup.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class SearchTest extends BaseTest{
	static Logger log = Logger.getLogger(SearchPage.class.getName());
	
	@Test(priority = 1)
	public void verifyPresenceOfSearchOptions() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifyPresenceOfSearchOptions", "TC012");
		
		searchPageObject.verifyPresenceOfSearchOptions();
	}
	
	@Test(priority = 2)
	public void verifySearchWithValidInput() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifySearchWithValidInput", "TC013");
		
		searchPageObject.searchProduct("Realme 12x 5G");
		searchPageObject.validateSearchResponse(driver.findElement(By.xpath("//div[text() = 'realme 12x 5G (Twilight Purple, 128 GB)']")).isDisplayed());
		searchPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority = 3)
	public void verifySearchWithInvalidInput() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifySearchWithInvalidInput", "TC014");
		
		searchPageObject.searchProduct("Rolome X12 5G");
		searchPageObject.validateSearchResponse(driver.findElement(By.xpath("//div[text() = 'realme 12x 5G (Twilight Purple, 128 GB)']")).isDisplayed());
		searchPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority = 4)
	public void verifySearchWithSpecialCharacters() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifySearchWithSpecialCharacters", "TC015");
		
		searchPageObject.searchProduct("R@!me X12 5&");
		searchPageObject.validateSearchResponse(driver.findElement(By.xpath("//div[text() = 'realme 12x 5G (Twilight Purple, 128 GB)']")).isDisplayed());
		searchPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority = 5)
	public void verifySearchWithoutInput() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifySearchWithoutInput", "TC016");
		
		searchPageObject.searchProduct("");
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.flipkart.com/"));
		searchPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority = 6)
	public void verifyRecentSearchAvailability() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifySearchWithoutInput", "TC017");
		
		searchPageObject.searchProduct("Realme 12x 5G");
		searchPageObject.clickOnFlipkartLogo();
		searchPageObject.clickOnSearchBox();
		searchPageObject.validateSearchResponse(driver.findElement(By.xpath("//a[contains(@href, '/search?q=Realme+12x+5G')]")).isDisplayed());
		searchPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority = 7)
	public void verifyProductSuggestionWithPartialName() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifyProductSuggestionWithPartialName", "TC018");

		searchPageObject.enterProductName("groc");
		searchPageObject.validateSearchResponse(driver.findElement(By.xpath("//a[contains(@href, '/search?q=grocery')]")).isDisplayed());
		searchPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority = 8)
	public void verifyNavigationToSuggestion() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifyNavigationToSuggestion", "TC019");

		searchPageObject.enterProductName("groc");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on suggestion");
		driver.findElement(By.xpath("//a[contains(@href, '/search?q=grocery')]//div[text()='in Dry Fruit, Nut & Seed']")).click();
		searchPageObject.validateSearchResponse(driver.findElement(By.xpath("//a[contains(text(),'Cashew')]")).isDisplayed());
		searchPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority = 9)
	public void verifySearchResultAfterApplyingFilter() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifySearchResultAfterApplyingFilter", "TC020");

		searchPageObject.searchProduct("Mobiles");
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Motorola')]")).isDisplayed());
		ExtentTestManager.getTest().log(LogStatus.INFO, "Apply filter, brand=samsung");
		driver.findElement(By.xpath("//div[text()='SAMSUNG']")).click();
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Motorola')]")).isDisplayed());
		} catch (NoSuchElementException e) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Search filter applied is working fine");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search filter applied is not working fine");
			Assert.fail("Search filter is not working fine");
		}
	}
	
	@Test(priority = 10, dependsOnMethods = "verifySearchResultAfterApplyingFilter")
	public void verifySearchResultAfterRemovingFilter() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifySearchResultAfterRemovingFilter", "TC021");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Remove all filters");
		driver.findElement(By.xpath("//span[text()='Clear all']")).click();
		searchPageObject.validateSearchResponse(driver.findElement(By.xpath("//div[contains(text(), 'Motorola')]")).isDisplayed());
		searchPageObject.clickOnFlipkartLogo();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Removed search filter is working fine");
	}
	
	@Test(priority = 11)
	public void verifySearchResultAfterApplyingSort() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifySearchResultAfterApplyingSort", "TC022");
		
		searchPageObject.searchProduct("Mobiles");
		searchPageObject.sortProductByPriceLowToHight();
		searchPageObject.clickOnFlipkartLogo();
	}
	
	@Test(priority = 12)
	public void verifyNavigationToMultiplePagesForSearchItems() {
		SearchPageObject searchPageObject = new SearchPageObject();
		ExtentTestManager.startTest("verifyNavigationToMultiplePagesForSearchItems", "TC023");

		searchPageObject.searchProduct("Mobiles");
		searchPageObject.navigationToDifferentPagesInSearchResult();
		searchPageObject.clickOnFlipkartLogo();
	}
	
	
	

}
