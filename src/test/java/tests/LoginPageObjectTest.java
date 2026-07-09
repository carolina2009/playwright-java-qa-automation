package tests;

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
        loginPage.login("tomsmith", "SuperSecretPassword!");

        assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area!"));
    }

    @Test
    public void failedLoginUsingPageObjectTest() {
        LoginPage loginPage = new LoginPage(page);

        loginPage.navigateToLoginPage();
        loginPage.login("tomsmith", "WrongPassword");

        assertTrue(loginPage.getFlashMessage().contains("Your password is invalid!"));
    }
}