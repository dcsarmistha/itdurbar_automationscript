package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By loginButton = By.cssSelector("button[type='button']");
    By phone = By.name("phone");
    By password = By.name("password");
    By submit = By.xpath("//button[text()='Submit']");

    By toast = By.xpath("//div[contains (text(),'Welcome back, Sarmistha!')]");
    By phoneError = By.xpath("//span[text()='Invalid phone number.']");
    By passwordError = By.xpath("//div[contains(text(),'Password is required.')]");
    By invalidToast =By.xpath("//div [contains (text (), 'Invalid phone or password')]");
    By invalidPhoneError = By.xpath("//span[text()='Invalid phone number.']");
    By logoutWay = By.xpath("//button[contains(.,'sarmisthadc2@gmail.com')]");
    By logoutBtn= By.xpath("//span[text()='Log Out']");
    By logoutToast= By.xpath("//div[contains (text(),'Logged out successfully')]");
    // Actions
    public void openLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void login(String phoneNum, String pass) {
        driver.findElement(phone).sendKeys(phoneNum);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();
    }

    public String getToastMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(toast)).getText();
    }

    public String getPhoneError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneError)).getText();
    }

    public String getPasswordError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordError)).getText();
    }
    public String getInvalidToast() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidToast)).getText();
    }
    public String getInvalidPhoneNumber(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidPhoneError)).getText();
    }
    public void LogoutWayOut(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutWay)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn)).click();
    }
    public String logoutToastMess() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutToast)).getText();
    }
}