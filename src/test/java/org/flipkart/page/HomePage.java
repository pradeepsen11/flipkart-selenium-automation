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

	@FindBy(css = "button._2KpZ6l._2doB4z")
	public WebElement loginPopupCancelButton;

<<<<<<< Updated upstream
	@FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
	public WebElement searchBox;

	@FindBy(xpath = "//*/form/div/button")
	public WebElement searchButton;

=======
	    @FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
	    public WebElement searchBox;

	    @FindBy(xpath = "//*/form/div/button")
	    public WebElement searchButton;
	    
>>>>>>> Stashed changes
}
