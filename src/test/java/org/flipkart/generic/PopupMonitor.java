package org.flipkart.generic;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PopupMonitor implements Runnable {

    private WebDriver driver;
    private boolean running = true;

    public PopupMonitor(WebDriver driver) {
        this.driver = driver;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                WebElement popup = driver.findElement(By.xpath("//span[@role='button' and @class='_30XB9F']"));
                if (popup.isDisplayed()) {
                    popup.click();
                }
            } catch (NoSuchElementException e) {}
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
