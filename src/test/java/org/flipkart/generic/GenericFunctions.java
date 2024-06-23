package org.flipkart.generic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericFunctions {
	public static String currentDateAndTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return sdf.format(new Date());
	}

	public static String formatTime(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(millis));
	}

	public static String captureScreenshot(WebDriver driver) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			byte[] fileContent = Files.readAllBytes(source.toPath());
			return "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}