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
	
	@FindBy(xpath = "//span[@role='button' and @class='_30XB9F']")
	public WebElement loginPopupCancelButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Page 1 of')]")
	public WebElement page_1_OfButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Page 2 of')]")
	public WebElement page_2_OfButton;
	
	@FindBy(xpath = "//span[text()= 'Next']")
	public WebElement nextPageButton;
}
