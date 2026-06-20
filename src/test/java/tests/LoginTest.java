package tests;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private static final Logger log =
            LoggerFactory.getLogger(LoginTest.class);

    LoginPage login;

    @BeforeMethod
    public void setUpPage() {

        driver.get("https://itd-staging.ktm.yetiappcloud.com/");

        login = new LoginPage(driver);
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

    @Test
    public void validLoginTest() {

        login.openLogin();

        login.login("9809776188",
                "9809776188");

        String msg = login.getToastMessage();

        Assert.assertEquals(msg,
                "Welcome back, Sarmistha!");
    }

    @Test
    public void logout() {

        login.openLogin();

        login.login("9809776188",
                "9809776188");

        login.LogoutWayOut();

        String mess = login.logoutToastMess();

        Assert.assertEquals(mess,
                "Logged out successfully",
                "No such message");
    }
    @Test(dataProvider = "invalidLoginData")
    public void invalidLoginTest(String phone,
                                 String password) {

        login.openLogin();

        login.login(phone, password);

        String msg = login.getInvalidToast();

        Assert.assertEquals(msg,
                "Invalid phone or password");
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidData() {

        return new Object[][] {
                {"9809776188", "wrongpass"},
                {"9809776188", "test123"},
                {"9809776188", "abc123"},
                {"9809776188", "pass"}

        };
    }
}