package org.flipkart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPopupPage {

	WebDriver driver;

	public LoginPopupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='_1UxRD8' and text()='Login']")
	public WebElement loginPopup;
	
	@FindBy(xpath = "//span[@role='button' and @class='_30XB9F']")
	public WebElement loginPopupCancelButton;
}
