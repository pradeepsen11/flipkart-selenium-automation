package org.flipkart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a//img[@title='Flipkart']")
	public WebElement flipkartLogo;

	@FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
	public WebElement searchBox;

	@FindBy(xpath = "//button[@title='Search for Products, Brands and More']")
	public WebElement searchButton;
}
