package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    void validUserShouldLoginSuccessfully() {
        page.navigate("https://the-internet.herokuapp.com/login");

        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator("button[type='submit']").click();

        String successMessage = page.locator("#flash").innerText();

        assertTrue(successMessage.contains("You logged into a secure area!"));
    }

    @Test
    void invalidUserShouldSeeErrorMessage() {
        page.navigate("https://the-internet.herokuapp.com/login");

        page.locator("#username").fill("wrongUser");
        page.locator("#password").fill("wrongPassword");
        page.locator("button[type='submit']").click();

        String errorMessage = page.locator("#flash").innerText();

        assertTrue(errorMessage.contains("Your username is invalid!"));
    }
}