
package utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
public class ScreenshotsUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {
// cast driver into screenshot capable object
        TakesScreenshot ts = (TakesScreenshot) driver;
//take screenshots and store temporarily as a file : project-foler/screenshots/testname.png
        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")
                + "/screenshots/" + testName + ".png";
//physically copy screenshots to project folder
        File dest = new File(path);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}