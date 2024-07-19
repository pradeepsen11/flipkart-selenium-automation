package org.flipkart.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.flipkart.generic.ExtentTestManager;
import org.flipkart.generic.GenericFunctions;
import org.flipkart.page.SearchPage;
import org.flipkart.setup.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.google.common.collect.Ordering;
import com.relevantcodes.extentreports.LogStatus;

public class SearchPageObject extends BaseTest {

	SearchPage searchPage = new SearchPage(driver);
	static Logger log = Logger.getLogger(SearchPage.class.getName());
	
	public void clickOnSearchBox() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on search box");
			searchPage.searchBox.click();
		} catch (ElementClickInterceptedException e) {
			searchPage.loginPopupCancelButton.click();
			driver.navigate().refresh();
			GenericFunctions.waitForElementClickable(searchPage.flipkartLogo);
			searchPage.searchBox.click();
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while clicking on search box");
			log.error("Exception in the method clickOnSearchBox");
			Assert.fail("Failed while clicking on search box");
		}
	}
	
	public void clickOnFlipkartLogo() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on flipkart logo button");
			searchPage.flipkartLogo.click();
		} catch (ElementClickInterceptedException e) {
			searchPage.loginPopupCancelButton.click();
			driver.navigate().refresh();
			GenericFunctions.waitForElementClickable(searchPage.flipkartLogo);
			searchPage.flipkartLogo.click();
		} catch (NoSuchElementException e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Flipkart logo not found on current screen");;
		} catch  (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while clicking on flipkart logo");
			log.error("Exception in the method clickOnFlipkartLogo");
			Assert.fail("Failed while clicking on flipkart logo");
		}
	}

	public void verifyPresenceOfSearchOptions() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Checking the presence of search box");
			Assert.assertTrue(searchPage.searchBox.isDisplayed());
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Checking the presence of search button");
			Assert.assertTrue(searchPage.searchButton.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while Checking the presence of search Options");
			log.error("Exception in the method verifyPresenceOfSearchOptions");
			Assert.fail("Failed while Checking the presence of search OptionsFailed while searching the product");
		}
	}
	
	public void enterProductName(String productName) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Enter product name");
			searchPage.searchBox.clear();
			searchPage.searchBox.sendKeys(productName);
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while entering the product name");
			log.error("Exception in the method enterProductName");
			Assert.fail("Failed while entering the product name");
		}
	}
	
	public void searchProduct(String productName) {
		try {
			enterProductName(productName);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on search button");
			GenericFunctions.waitForElementClickable(searchPage.searchButton);
			searchPage.searchButton.click();
		} catch (ElementClickInterceptedException e) {
			searchPage.loginPopupCancelButton.click();
			driver.navigate().refresh();
			GenericFunctions.waitForElementClickable(searchPage.searchBox);
			searchPage.searchBox.sendKeys(productName);
			GenericFunctions.waitForElementClickable(searchPage.searchButton);
			searchPage.searchButton.click();
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while searching the product");
			log.error("Exception in the method searchProduct");
			Assert.fail("Failed while searching the product");
		}
	}
	
	public void validateSearchResponse(Boolean condition) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validating response");
			Assert.assertTrue(condition);
		} catch (ElementClickInterceptedException e) {
			searchPage.loginPopupCancelButton.click();
			driver.navigate().refresh();
			GenericFunctions.waitForElementClickable(searchPage.flipkartLogo);
			searchPage.flipkartLogo.click();
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while validating search response");
			log.error("Exception in the method validateSearchResponse");
			Assert.fail("Failed while validating search response");
		}
	}
	
	public void sortProductByPriceLowToHight() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Price -- Low to High sorting option");
			GenericFunctions.waitForElementClickable(driver.findElement(By.xpath("//div[text()='Price -- Low to High']")));
			driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
			GenericFunctions.waitWebDriver(3000);
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Wait for the sorted results to load");
			GenericFunctions.waitForElementPresent(driver.findElement(By.xpath("//div[contains(@class, 'Nx9bqj _4b5DiR')]")));
 
			ExtentTestManager.getTest().log(LogStatus.INFO, "Get the list of prices");
			List<WebElement> priceElements = driver.findElements(By.xpath("//div[contains(@class, 'Nx9bqj _4b5DiR')]"));

			ExtentTestManager.getTest().log(LogStatus.INFO, "Iterate over the first 24 price elements");
			List<Integer> prices = new ArrayList<>();
			int retryCount = 3;  // Maximum number of retries
			for (int i = 0; i < 15 && i < priceElements.size(); i++) {
	            boolean success = false;
	            for (int retry = 0; retry < retryCount; retry++) {
	                try {
	                    WebElement priceElement = priceElements.get(i);
	                    String priceText = priceElement.getText().replaceAll("[^0-9]", "");
	                    prices.add(Integer.parseInt(priceText));
	                    success = true;
	                    break;  // Break out of the retry loop if successful
	                } catch (StaleElementReferenceException e) {
	                    // Re-fetch the list of elements
	                    priceElements = driver.findElements(By.xpath("//div[contains(@class, 'Nx9bqj _4b5DiR')]"));
	                }
	            }
	            if (!success) {
	                throw new RuntimeException("Failed to retrieve element text after multiple retries.");
	            }
	        }
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate the sorting");
			boolean isSorted = Ordering.natural().isOrdered(prices); //will sort in ascending order
			// Ordering.natural().reverse().isOrdered() //will sort in descending order

			if (isSorted) {
				System.out.println("done");
				ExtentTestManager.getTest().log(LogStatus.PASS, "The products are correctly sorted by price from low to high.");
			} else {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "The products are not sorted correctly by price.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while sorting search result");
			log.error("Exception in the method sortProductByPriceLowToHight");
			Assert.fail("Failed while sorting search result");
		}
	}
	
	public void navigationToDifferentPagesInSearchResult() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Check the presence of Page 1 of text");
			Assert.assertTrue(searchPage.page_1_OfButton.isDisplayed(), "Page 1 of, text is not present");
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scroll and Click on Next Page button");
			GenericFunctions.scrollToElement(searchPage.nextPageButton);
			GenericFunctions.waitWebDriver(3000);
			searchPage.nextPageButton.click();
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate the presence of Page 1 of text");
			Assert.assertTrue(searchPage.page_2_OfButton.isDisplayed(), "Page 2 of, text is not present");
		} catch (Exception e) {
			e.printStackTrace();
			clickOnFlipkartLogo();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed while navigating to search result pages");
			log.error("Exception in the method navigationToDifferentPagesInSearchResult");
			Assert.fail("Failed while navigating to search result pages");
		}
	}
}
