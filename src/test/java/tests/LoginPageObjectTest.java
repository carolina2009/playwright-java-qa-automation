package tests;

import data.LoginTestData;
import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageObjectTest extends BaseTest {

    @Test
    public void successfulLoginUsingPageObjectTest() {
        LoginPage loginPage = new LoginPage(page);

        loginPage.navigateToLoginPage();
        loginPage.login(LoginTestData.VALID_USERNAME, LoginTestData.VALID_PASSWORD);

        assertTrue(loginPage.getFlashMessage().contains(LoginTestData.SUCCESS_LOGIN_MESSAGE));
    }

    @Test
    public void failedLoginUsingPageObjectTest() {
        LoginPage loginPage = new LoginPage(page);

        loginPage.navigateToLoginPage();
        loginPage.login(LoginTestData.VALID_USERNAME, LoginTestData.INVALID_PASSWORD);

        assertTrue(loginPage.getFlashMessage().contains(LoginTestData.INVALID_PASSWORD_MESSAGE));
    }
}