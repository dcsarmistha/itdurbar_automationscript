package listeners;


import com.aventstack.extentreports.*;
import org.testng.*;

import utils.*;

public class TestListener implements ITestListener {


    ExtentTest test;


    public void onTestStart(ITestResult result){

        test = ExtentManager
                .getReport()
                .createTest(result.getName());

    }


    public void onTestSuccess(ITestResult result){

        test.pass("Test Passed");

    }


    public void onTestFailure(ITestResult result){


        test.fail(result.getThrowable());


        String screenshot =
                ScreenshotsUtils.captureScreenshot(
                        result.getName()
                );


        try {

            test.addScreenCaptureFromPath(
                    screenshot
            );

        }catch(Exception e){

            e.printStackTrace();

        }

    }


    public void onFinish(ITestContext context){

        ExtentManager
                .getReport()
                .flush();

    }

}