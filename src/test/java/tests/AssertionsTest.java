package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


import base.BaseTest;

public class AssertionsTest extends BaseTest {

        @Test
    public void validateLoginPageTitleTest() {
        page.navigate("https://practicetestautomation.com/practice-test-login/");

        assertThat(page).hasTitle("Test Login | Practice Test Automation");
    }

    @Test
    public void validateUsernameInputIsVisibleTest() {
        page.navigate("https://practicetestautomation.com/practice-test-login/");

        assertThat(page.locator("#username")).isVisible();
    }

    @Test
    public void validateSuccessfulLoginWithPlaywrightAssertionsTest() {
        page.navigate("https://practicetestautomation.com/practice-test-login/");

        page.locator("#username").fill("student");
        page.locator("#password").fill("Password123");
        page.locator("#submit").click();

        assertThat(page).hasURL("https://practicetestautomation.com/logged-in-successfully/");
        assertThat(page.locator("text=Logged In Successfully")).isVisible();
        assertThat(page.locator("h1")).containsText("Logged In Successfully");
    }

    @Test
    public void validateFailedLoginWithPlaywrightAssertionsTest() {
        page.navigate("https://practicetestautomation.com/practice-test-login/");

        page.locator("#username").fill("student");
        page.locator("#password").fill("WrongPassword");
        page.locator("#submit").click();

        assertThat(page.locator("#error")).isVisible();
        assertThat(page.locator("#error")).containsText("Your password is invalid!");
    }
}
