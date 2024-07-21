package org.flipkart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderNavigationPage {

	WebDriver driver;

	public HeaderNavigationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a//img[@title='Flipkart']")
	public WebElement flipkartLogo;
	
	@FindBy(xpath = "//a[@href='/plus']//span[text()='Plus']")
	public WebElement plusIcon;
	
	@FindBy(xpath = "//a[@title='Login']//span[text()='Login']")
	public WebElement loginIcon;
	
	@FindBy(xpath = "//span[contains(text(), 'Appliances')]")
	public WebElement appliancesIcon;
	
	@FindBy(xpath = "//a[@title='Cart']//img[@alt='Cart']")
	public WebElement cartIcon;
	
	@FindBy(xpath = "//a[@title='Become a Seller']//img[@alt='Become a Seller']")
	public WebElement becomeASellerIcon;
	
	@FindBy(xpath = "//a[@title='Dropdown with more help links']//img[@alt='Dropdown with more help links']")
	public WebElement moreHelpLinksIcon;
	
	@FindBy(xpath = "//a[@title='Notification Preferences']")
	public WebElement notificationPreferenceIcon;
	
	@FindBy(xpath = "//a[@title='24x7 Customer Care']")
	public WebElement customerCareIcon;
	
	@FindBy(xpath = "//a[@title='Advertise']")
	public WebElement advertiseIcon;
	
	@FindBy(xpath = "//a[@title='Download App']")
	public WebElement downloadAppIcon;
	
	@FindBy(xpath = "//span[@role='button' and @class='_30XB9F']")
	public WebElement loginPopupCancelButton;
	
}
