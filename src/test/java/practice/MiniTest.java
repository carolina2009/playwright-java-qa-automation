package practice;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.nio.file.Paths;



public class MiniTest extends BaseTest {

@Test

public void loginTest() {
    page.navigate("https://practicetestautomation.com/practice-test-login/");

    page.locator("#username").fill("student");
    page.locator("#password").fill("Password123");
    page.locator("#submit").click();

    page.waitForURL("**/logged-in-successfully/");
    page.locator("text=Logged In Successfully").waitFor();

    assertTrue(page.locator("text=Logged In Successfully").isVisible());
    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/loginSuccess.png")));
    }



@Test

    public void LoginFailedTest() {
    page.navigate("https://practicetestautomation.com/practice-test-login/");

    page.locator("#username").fill("student");
    page.locator("#password").fill("Password1");
    page.locator("#submit").click();

    String actualMessage=page.locator("#error").textContent();

    assertEquals("Your password is invalid!",actualMessage);
    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("LoginFailed.png")));
}
@Test
    public void checkboxTest() {
    page.navigate("https://the-internet.herokuapp.com/checkboxes");

   Locator checkbox1 =  page.locator("input[type='checkbox']").nth(0);
   Locator checkbox2 =  page.locator("input[type='checkbox']").nth(1);

   checkbox1.click();
   checkbox2.uncheck();


   assertTrue(checkbox1.isChecked());
    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Checkbox1.png")));
   assertFalse(checkbox2.isChecked());
    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Checkbox2.png")));

}
@Test

    public void dropdownTest(){

    page.navigate("https://the-internet.herokuapp.com/dropdown");

    page.locator("#dropdown").selectOption("1");


    String selectedValue = page.locator("#dropdown").inputValue();

    assertEquals("1", selectedValue);
    page.waitForTimeout(1000);
    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Dropdown.png")));

}
}


