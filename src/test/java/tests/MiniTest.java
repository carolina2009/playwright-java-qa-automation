package tests;

import base.BaseTest;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.Page.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MiniTest extends BaseTest {

@Test

public void loginTest() {
    page.navigate("https://practicetestautomation.com/practice-test-login/");

    page.locator("#username").fill("student");
    page.locator("#password").fill("Password123");
    page.locator("#submit").click();

    assertTrue(page.locator("text=Logged In successfully").isVisible());
    }

}


