package org.flipkart.setup;

import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

public class BaseTest {

	public static WebDriver driver;

	@BeforeSuite
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
	}

<<<<<<< Updated upstream
	@AfterSuite
=======
//	@AfterClass
>>>>>>> Stashed changes
	public void afterClass() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}
<<<<<<< Updated upstream

	public WebDriver getDriver() {
		return driver;
	}
=======
	
	public WebDriver getDriver() {
        return driver;
    }
>>>>>>> Stashed changes
}
