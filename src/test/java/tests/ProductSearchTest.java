package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.ProductPageFilter;

public class ProductSearchTest extends BaseTest {
ProductPageFilter filter;
@BeforeMethod
public void setTest(){

    driver.get("https://itd-staging.ktm.yetiappcloud.com/");
    filter= new ProductPageFilter(driver);
}
@Test
public void searchCategory(){
filter.categorySearch();
System.out.println("category opened successfully");
filter.setCategoryType();
System.out.println("Category type selected successfully");
String productConfirm= filter.productNameConfirm();
Assert.assertEquals(productConfirm, "Vartex 430WL Wireless Mouse – 2.4GHz", "No such product");

}
}
