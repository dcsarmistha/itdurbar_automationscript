package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Map;

public class BaseTest {

    // ThreadLocal — each test gets its own driver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Listener needs this to take screenshots
    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setUp() {

        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();

        // disable Chrome password warning popup
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");

        options.addArguments("--disable-dev-shm-usage");

        options.addArguments("--window-size=1920,1080");
        options.setExperimentalOption(
                "prefs",
                Map.of(
                        "credentials_enable_service", false,
                        "profile.password_manager_enabled", false
                )
        );

        driver.set(new EdgeDriver(options));
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}