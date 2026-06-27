package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.LoginPage;

public class CartTest extends BaseTest {
    AddToCartPage page1;
    LoginPage login;
    @BeforeMethod
    public void setup3(){
        getDriver().get("https://itd-staging.ktm.yetiappcloud.com/");
        page1= new AddToCartPage(getDriver());
        login= new LoginPage(getDriver());
    }
    @Test
    public void AddToCartTest() {

        login.openLogin();
        login.login("9809776188", "9809776188");

        page1.CartPage();
            page1.SelectAll();
            page1.ProceedToCheckOutFirst();
            page1.superCoinSmall();
            page1.DeliverHere();
            page1.superCoinPopup();
            page1.ProceedToCheckOutSecond();
            page1.superCoinSmall();
//            page1.setKhaltiBtn();
//            page1.setConfirmPayment();
//            String khaltiMessage= page1.khaltiFailedToast();
//            Assert.assertEquals(khaltiMessage, "An error occurred while initiating the payment",
//                    "khalti toast failure mismatch");
            page1.setCodBtn();
            page1.setConfirmPayment();
         String orderMessage= page1.orderSuccessToast();
         Assert.assertEquals(orderMessage, "Order Placed Successfully", "Order not placed");
         System.out.println("order placed succesfully");
        }
        @Test
    public void emptyCartTest(){
            login.openLogin();
            login.login("9809776188", "9809776188");
            page1.CartPage();
            page1.cartEmpty();
            page1.superCoinPopup();
            String emptyMessage= page1.cartEmpty();
            Assert.assertEquals(emptyMessage, "Your Cart Feels Lonely");

          //  page1.searchProduct();
          //  System.out.println("Landed in the product detail page");
         //   page1.superCoinSmall();
//            String stockMessage= page1.setStockOut();
//            Assert.assertEquals(stockMessage, "Out of Stock", "in stock");
        }
}

