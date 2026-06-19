package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPageFilter {
    WebDriver driver;
    WebDriverWait wait;
    By categoryType= By.xpath("//a[text()='Computer Accessories']");
    By mouse=By.xpath("//a[text()='Mouse']");
    By productName= By.xpath("//a[contains(text(),'Vartex 430WL Wireless Mouse – 2.4GHz')]");
    public ProductPageFilter(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
    }
public void categorySearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryType)).click();
}
public void setCategoryType(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mouse)).click();
}
public String productNameConfirm(){
        return wait.until(ExpectedConditions.elementToBeClickable(productName)).getText();
}
}
