package org.flipkart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@role='button' and @class='_30XB9F']")
	public WebElement loginPopupCancelButton;

	@FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
	public WebElement searchBox;

	@FindBy(xpath = "//button[@title='Search for Products, Brands and More']")
	public WebElement searchButton;
}
