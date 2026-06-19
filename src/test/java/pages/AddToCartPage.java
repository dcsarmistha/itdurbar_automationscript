package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IExpectedExceptionsHolder;

import javax.swing.*;
import java.time.Duration;
import java.util.List;


public class AddToCartPage {
    WebDriver driver;
    WebDriverWait wait;
    By cart = By.xpath("//p[contains(text(),'Cart')]");
    By selectAll = By.xpath("//span[normalize-space()='Select All']");
    By checkout = By.xpath("//button[contains(@class,'bg-primary') and contains(.,'Proceed to Checkout')]");
    By deliverHere = By.xpath("//button[contains(.,'Deliver Here')]");
    By proceedToPayment = By.xpath("//button[normalize-space()='Proceed To Payment']");
    By confirmPayment = By.xpath("//button[contains(.,'Confirm Payment')]");
    By cartEmptyMess = By.xpath("//h2[contains(text(),'Your Cart Feels Lonely')]");
    By supercoinCloseBtn = By.cssSelector("button.absolute.top-4.right-4");
    By khaltiBtn = By.xpath("//button[.//span[normalize-space()='Khalti']]");
    By codBtn = By.xpath("//button[.//span[normalize-space()='Cash on Delivery']]");
    By successToast = By.xpath("//*[text()='Order Placed Successfully']");
    By khaltiMessage= By.xpath("//div[contains(text(),'An error occurred while initiating the payment')]");
    By closeButton = By.cssSelector("button svg.lucide-x");
    By emptyCart= By.xpath("//button[normalize-space()='Continue Shopping']");
    By productOne= By.xpath("//h3[normalize-space(text())='BenQ SW270 27″ WQXGA IPS Professio" +
            "nal Monitor – 99% Adobe RGB, USB-C 60W, Hardware Calibration - BLACK']");
    By stockOut= By.xpath("//h3[normalize-space()='Out of Stock']");
    By notifyBtn= By.xpath("//button[normalize-space()='Notify When Available']");
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void CartPage() {
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
    }

    public String getEmptyCartMessage() {
        return driver.findElement(cartEmptyMess).getText();
    }

    public void SelectAll() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectAll)).click();
    }

    public void ProceedToCheckOutFirst() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkout)).click();
    }

    public void DeliverHere() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliverHere)).click();
    }

    public void ProceedToCheckOutSecond() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToPayment)).click();
    }

    public void setKhaltiBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(khaltiBtn)).click();
    }

    public void setCodBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(codBtn)).click();
    }

    public void setConfirmPayment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPayment)).click();
    }

    public void superCoinPopup() {
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(supercoinCloseBtn));
            closeButton.click();
            System.out.println("Supercoin popup dismissed successfully.");
        } catch (TimeoutException e) {
            System.out.println("Supercoin popup did not appear. Proceeding with the test flow.");
        }
    }

    public String orderSuccessToast() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successToast)).getText();
    }
    public String khaltiFailedToast() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(khaltiMessage)).getText();
    }
    public void superCoinSmall() {
        try {
            WebElement closeSupercoinSmall = wait.until(ExpectedConditions.elementToBeClickable(closeButton));
            closeSupercoinSmall.click();
            System.out.println("Box dismissed successfully.");
        } catch (TimeoutException e) {
            System.out.println("Box did not appear. Proceeding with the rest of the flow.");
        }
    }
    public void cartEmpty(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCart)).click();
    }
    public void searchProduct(){
      WebElement product= wait.until(ExpectedConditions.presenceOfElementLocated(productOne));
      Actions actions= new Actions(driver);
      actions.scrollToElement(product).perform();
     wait.until(ExpectedConditions.elementToBeClickable(product)).click();
    }
    public String setStockOut(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(stockOut)).getText();
    }
    public void setNotifyBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(notifyBtn)).click();
    }

}