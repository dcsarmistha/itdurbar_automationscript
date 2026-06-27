package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {
    ProductPage product;
LoginPage login;
    @BeforeMethod
    public void setUpTest(){
        getDriver().get("https://itd-staging.ktm.yetiappcloud.com/");
        product= new ProductPage(getDriver());
    }
    @Test
    public void ProductMethod () throws InterruptedException {
        product.searchProduct("benq monitors");
        Thread.sleep(5000);
        product.productNameSearch();
        String stockMessage= product.setStockStatus();
        Assert.assertEquals(stockMessage, "Add to Cart", "No such visibility");
    }
}
