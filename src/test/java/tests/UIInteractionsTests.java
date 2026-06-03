package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UIInteractionsTests extends BaseTest {

    @Test
    void userShouldBeAbleToCheckAndUncheckCheckbox() {
        page.navigate("https://the-internet.herokuapp.com/checkboxes");

        page.locator("input[type='checkbox']").first().check();

        boolean firstCheckboxIsChecked = page.locator("input[type='checkbox']").first().isChecked();

        assertTrue(firstCheckboxIsChecked);

        page.locator("input[type='checkbox']").first().uncheck();

        boolean firstCheckboxIsUnchecked = page.locator("input[type='checkbox']").first().isChecked();

        assertFalse(firstCheckboxIsUnchecked);
    }

    @Test
    void userShouldBeAbleToSelectDropdownOption() {
        page.navigate("https://the-internet.herokuapp.com/dropdown");

        page.locator("#dropdown").selectOption("1");

        String selectedOption = page.locator("#dropdown").inputValue();

        assertEquals("1", selectedOption);
    }

    @Test
    void pageHeadingShouldBeVisible() {
        page.navigate("https://the-internet.herokuapp.com/dropdown");

        boolean headingIsVisible = page.locator("h3").isVisible();

        assertTrue(headingIsVisible);
    }

    @Test
    void userShouldBeAbleToAcceptAlert() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        page.onDialog(dialog -> {
            System.out.println("Alert message is: " + dialog.message());
            dialog.accept();
        });

        page.locator("button", new com.microsoft.playwright.Page.LocatorOptions()
                .setHasText("Click for JS Alert")).click();

        String resultText = page.locator("#result").innerText();

        assertTrue(resultText.contains("You successfully clicked an alert"));
    }
}