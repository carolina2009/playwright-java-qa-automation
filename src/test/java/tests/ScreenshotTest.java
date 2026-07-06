package tests;

import base.BaseTest;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;





public class ScreenshotTest  extends BaseTest {

    @Test
    public void successfulLoginScreenshotTest() {
        page.navigate("https://practicetestautomation.com/practice-test-login/");

        page.locator("#username").fill("student");
        page.locator("#password").fill("Password123");
        page.locator("#submit").click();

        page.waitForURL("**/logged-in-successfully/");
        assertTrue(page.locator("text=Logged In Successfully").isVisible());

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/successful-login.png")));
    }

    @Test
    public void failedLoginScreenshotTest() {
        page.navigate("https://practicetestautomation.com/practice-test-login/");

        page.locator("#username").fill("student");
        page.locator("#password").fill("WrongPassword");
        page.locator("#submit").click();

        assertTrue(page.locator("#error").isVisible());

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/failed-login.png")));
    }
    
}
