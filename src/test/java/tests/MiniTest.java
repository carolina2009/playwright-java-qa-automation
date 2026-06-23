package tests;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.Page.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MiniTest extends BaseTest {

@Test

public void loginTest() {
    page.navigate("https://practicetestautomation.com/practice-test-login/");

    page.locator("#username").fill("student");
    page.locator("#password").fill("Password123");
    page.locator("#submit").click();

    assertTrue(page.locator("text=Logged In successfully").isVisible());
    }
@Test
    public void LoginFailedTest() {
    page.navigate("https://practicetestautomation.com/practice-test-login/");

    page.locator("#username").fill("student");
    page.locator("#password").fill("Password1");
    page.locator("#submit").click();

    String actualMessage=page.locator("#error").textContent();

    assertEquals("Your password is invalid!",actualMessage);
}
@Test
    public void checkboxTest() {
    page.navigate("https://the-internet.herokuapp.com/checkboxes");

   Locator checkbox1 =  page.locator("input[type='checkbox']").nth(0);
   Locator checkbox2 =  page.locator("input[type='checkbox']").nth(1);

   checkbox1.click();
   checkbox2.uncheck();


   assertTrue(checkbox1.isChecked());
   assertFalse(checkbox2.isChecked());

}

}


