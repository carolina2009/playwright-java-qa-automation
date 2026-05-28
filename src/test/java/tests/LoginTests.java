package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    void validUserShouldLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(page);

        loginPage.navigateToLoginPage();
        loginPage.login("tomsmith", "SuperSecretPassword!");

        String successMessage = loginPage.getFlashMessage();

        assertTrue(successMessage.contains("You logged into a secure area!"));
    }

    @Test
    void invalidUserShouldSeeErrorMessage() {
        LoginPage loginPage = new LoginPage(page);

        loginPage.navigateToLoginPage();
        loginPage.login("wrongUser", "wrongPassword");

        String errorMessage = loginPage.getFlashMessage();

        assertTrue(errorMessage.contains("Your username is invalid!"));
    }
}