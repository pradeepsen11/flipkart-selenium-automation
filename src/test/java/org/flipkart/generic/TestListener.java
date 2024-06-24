package org.flipkart.generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import org.flipkart.setup.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestListener extends BaseTest implements ITestListener {
	
	@Override
    public void onTestStart(ITestResult result) {
        System.out.println("Execution started for test method " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	System.out.println("Execution is successful for test method " + result.getMethod().getMethodName());
        ExtentTestManager.getTest().log(LogStatus.PASS, "Execution is successful for test method " + result.getMethod().getMethodName());
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("Execution has failed for test method " + result.getMethod().getMethodName());
        ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
        
        // Capture screenshot
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        
        if (base64Screenshot != null) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Screenshot below: " + ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
        }
        
        String screenPath = ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot);
        Reporter.log(screenPath);
     
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	System.out.println("Execution is skipped for test method " + result.getMethod().getMethodName());
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Execution is skipped for test method " + result.getMethod().getMethodName());
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    	System.out.println("Execution is failed but within success percentage for test method " + result.getMethod().getMethodName());
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Execution is failed but within success percentage for test method " + result.getMethod().getMethodName());
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite started!");
    }

    @Override
    public void onFinish(ITestContext context) {
		System.out.println("Test Suite finished!");
        ExtentManager.endReporter();
    }
}
