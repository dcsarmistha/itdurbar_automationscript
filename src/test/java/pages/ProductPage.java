package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    By searchBar = By.xpath("//input[@aria-label='Search for Product, Brand, or Category']");
    By productName= By.xpath("//h3[text()='BenQ PD2506Q 25″ QHD IPS Professional Monitor – 100% sRGB, USB-C 65W, HDR10 - BLACK']");
    By stockStatus= By.xpath("//button[text()='Add to Cart']");
    public ProductPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchProduct(String productName) {
        WebElement search = wait.until(
                ExpectedConditions.elementToBeClickable(searchBar)
        );
        Actions actions = new Actions(driver);
        actions.moveToElement(search)
                .click()
                .pause(Duration.ofMillis(1000))
                .sendKeys(productName)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }
   public void productNameSearch(){
       WebElement product = wait.until(ExpectedConditions.elementToBeClickable(productName));
       product.click();
   }
   public String setStockStatus(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(stockStatus)).getText();
   }
}