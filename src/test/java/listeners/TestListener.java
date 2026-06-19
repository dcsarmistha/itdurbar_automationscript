package listeners;

import base.BaseTest;
import com.aventstack.extentreports.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;
import utils.ScreenshotsUtil;
//to listen to test events like start, pass, fail
public class TestListener implements ITestListener {
//full html report
    ExtentReports extent = ExtentManager.getExtentReports();
    //one test case inside the report
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        //new test entry with name same as method name
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //on test pass success message
        test.pass("Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
//throws actual error and exception
        test.fail(result.getThrowable());
        //current test class object cast into base test to access the driver
        BaseTest base = (BaseTest) result.getInstance();
        //take ss using webdriver and save file with test name
        String path = ScreenshotsUtil.captureScreenshot(
                base.getDriver(),
                result.getMethod().getMethodName()
        );
// ss added to the report
        test.addScreenCaptureFromPath(path);
    }
    @Override
    public void onFinish(ITestContext context) {
        //write everything into the html file , finalizes report and saves it to the disk
        extent.flush();
    }
}