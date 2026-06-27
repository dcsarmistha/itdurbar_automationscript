package utils;

import base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotsUtils {


    public static String captureScreenshot(String testName){

        String path = "screenshots/" + testName + ".png";


        try {

            File source = ((TakesScreenshot) BaseTest.getDriver())
                    .getScreenshotAs(OutputType.FILE);


            File destination = new File(path);


            Files.copy(
                    source.toPath(),
                    destination.toPath()
            );


        } catch(Exception e){

            e.printStackTrace();

        }


        return path;
    }
}