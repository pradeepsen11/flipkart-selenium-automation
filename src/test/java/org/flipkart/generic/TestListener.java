package org.flipkart.generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

import org.flipkart.setup.BaseTest;
import org.openqa.selenium.WebDriver;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
        
        // Capture screenshot
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        String base64Screenshot = GenericFunctions.captureScreenshot(driver);
        
        if (base64Screenshot != null) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Screenshot below: " + ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
        }
        
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped");
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test failed but within success percentage");
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
    }
}
