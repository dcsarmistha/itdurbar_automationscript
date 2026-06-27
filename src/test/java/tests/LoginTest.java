package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {



    LoginPage login;

    @BeforeMethod
    public void setUpPage() {

        getDriver().get("https://itd-staging.ktm.yetiappcloud.com/");
        login = new LoginPage(getDriver());
    }
    @Test
    public void validLoginTest() {

        login.openLogin();

        login.login("9809776188",
                "9809776188");

        String msg = login.getToastMessage();

        Assert.assertEquals(msg,
                "Welcome back, Sarmi!", "no such toast message displayed");
        login.superCoinPopup();
    }
    @Test
    public void emptyFieldsTest() {

        login.openLogin();

        login.login("", "");

        String phoneMsg = login.getPhoneError();
        String passMsg = login.getPasswordError();

        Assert.assertEquals(phoneMsg,
                "Invalid phone number.");

        Assert.assertEquals(passMsg,
                "Password is required.");
    }

    @Test
    public void invalidPhoneTest() {

        login.openLogin();

        login.login("12345", "wrongpass");

        String invalidPhoneMess =
                login.getInvalidPhoneNumber();

        Assert.assertEquals(invalidPhoneMess,
                "Invalid phone number.");
    }



//    @Test
//    public void logout() {
//        login.openLogin();
//        login.login("9809776188", "9809776188");
//        login.superCoinPopup();
//        login.LogoutWayOut();
//        String mess = login.logoutToastMess();
//        Assert.assertEquals(mess,
//                "Logged out successfully",
//                "No such message");
//    }
}