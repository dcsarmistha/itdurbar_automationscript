package listeners;

import base.BaseTest;
import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import utils.ExtentManager;
import utils.ScreenshotsUtil;

public class TestListener implements ITestListener {


    ExtentReports extent = ExtentManager.getExtentReports();


    // ThreadLocal helps when running tests parallel
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);


        test.get().info("Test execution started");
    }



    @Override
    public void onTestSuccess(ITestResult result) {

        test.get()
                .log(Status.PASS,
                        "Test Passed Successfully");

    }



    @Override
    public void onTestFailure(ITestResult result) {


        test.get()
                .log(Status.FAIL,
                        "Test Failed");


        // capture actual error message
        test.get()
                .fail(result.getThrowable());


        // get driver from test class
        Object currentClass =
                result.getInstance();


        WebDriver driver =
                ((BaseTest) currentClass).getDriver();



        String screenshotPath =
                ScreenshotsUtil.captureScreenshot(
                        driver,
                        result.getName()
                );


        test.get()
                .addScreenCaptureFromPath(screenshotPath);


        test.get()
                .info("Screenshot captured: "
                        + screenshotPath);

    }



    @Override
    public void onTestSkipped(ITestResult result) {


        test.get()
                .log(Status.SKIP,
                        "Test skipped");


        test.get()
                .skip(result.getThrowable());

    }



    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

    }

}