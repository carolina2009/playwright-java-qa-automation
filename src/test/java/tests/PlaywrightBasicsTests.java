package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaywrightBasicsTests extends BaseTest {

    @Test
    void openPageAndValidateTitle() {
        page.navigate("https://example.com");

        String title = page.title();

        System.out.println("Page title is: " + title);

        assertTrue(title.contains("Example"));
    }

    @Test
    void validateTextIsVisible() {
        page.navigate("https://example.com");

        boolean headingIsVisible = page.locator("h1").isVisible();

        assertTrue(headingIsVisible);
    }

    @Test
    void readTextFromPage() {
        page.navigate("https://example.com");

        String headingText = page.locator("h1").innerText();

        System.out.println("Heading text is: " + headingText);

        assertTrue(headingText.contains("Example Domain"));
    }

    @Test
    void fillLoginFormFields() {
        page.navigate("https://the-internet.herokuapp.com/login");

        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");

        String usernameValue = page.locator("#username").inputValue();
        String passwordValue = page.locator("#password").inputValue();

        assertTrue(usernameValue.equals("tomsmith"));
        assertTrue(passwordValue.equals("SuperSecretPassword!"));
    }

    @Test
    void clickLoginButtonAndValidateMessage() {
        page.navigate("https://the-internet.herokuapp.com/login");

        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator("button[type='submit']").click();

        String message = page.locator("#flash").innerText();

        assertTrue(message.contains("You logged into a secure area!"));
    }
}