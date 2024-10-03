package org.flipkart.setup;

import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

import org.flipkart.generic.PopupMonitor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

public class BaseTest {

	public static WebDriver driver;
	static PopupMonitor popupMonitor;
    static Thread popupMonitorThread;

	@BeforeSuite
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
//		options.addArguments("--headless");
//        options.addArguments("--disable-gpu"); // Applicable to Windows OS only
//        options.addArguments("--window-size=1920,1080");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		// Initialize and start the popup monitor
//        popupMonitor = new PopupMonitor(driver);
//        popupMonitorThread = new Thread(popupMonitor);
//        popupMonitorThread.start();
	}

	@AfterSuite
	public void afterClass() {
		// Stop the popup monitor
//        popupMonitor.stop();
//        try {
//            popupMonitorThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        
        //Quit driver
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
}
