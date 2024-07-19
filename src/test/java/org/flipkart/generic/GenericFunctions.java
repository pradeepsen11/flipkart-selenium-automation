package org.flipkart.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.flipkart.setup.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericFunctions extends BaseTest{
	public static String currentDateAndTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return sdf.format(new Date());
	}

	public static String formatTime(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(millis));
	}

	public static String overallExecutionTime(long startTime, long endTime) {
		long duration = endTime - startTime;
		long seconds = (duration / 1000) % 60;
		long minutes = (duration / (1000 * 60)) % 60;
		long hours = (duration / (1000 * 60 * 60)) % 24;
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}

	public static void clickByCordinates(int x, int y){
			Actions actions = new Actions(driver);
            actions.moveByOffset(x,y).click().perform();
	}
	
	public static void waitWebDriver(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread was interrupted, Failed to complete operation");
        }
    }
	
	public static void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
	
	public static void waitForElementClickable(WebElement element){
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new TimeoutException("Timeout waiting for element to be clickable: " + e.getMessage());
        }
    }
	
	public static void waitForElementPresent(WebElement element){
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new TimeoutException("Timeout waiting for element to be present: " + e.getMessage());
        }
    }
	
	public static void scrollToElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean isElementInView = false;
        int maxScrollAttempts = 10;
        int scrollAttempts = 0;

        while (!isElementInView && scrollAttempts < maxScrollAttempts) {
            // Scroll to the element
            jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            
            // Check if the element is in view using JavaScript
            isElementInView = (Boolean) jsExecutor.executeScript(
                "var elem = arguments[0],                 " +
                "  box = elem.getBoundingClientRect(),    " +
                "  cx = box.left + box.width / 2,         " +
                "  cy = box.top + box.height / 2,         " +
                "  e = document.elementFromPoint(cx, cy); " +
                "for (; e; e = e.parentElement) {          " +
                "  if (e === elem)                        " +
                "    return true;                         " +
                "}                                        " +
                "return false;                            ", element);
            
            // Increment the scroll attempts
            scrollAttempts++;
        }

        // Log if element was not found in the maximum attempts
        if (!isElementInView) {
            System.out.println("Element not found within the maximum scroll attempts.");
        }
    
    }

}
