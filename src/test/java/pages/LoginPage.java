package pages;

import com.microsoft.playwright.Page;
import config.TestConfig;

public class LoginPage {

    private final Page page;

    private final String loginUrl =TestConfig.LOGIN_URL;
    private final String usernameInput = "#username";
    private final String passwordInput = "#password";
    private final String loginButton = "button[type='submit']";
    private final String flashMessage = "#flash";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLoginPage() {
        page.navigate(loginUrl);
    }

    public void enterUsername(String username) {
        page.locator(usernameInput).fill(username);
    }

    public void enterPassword(String password) {
        page.locator(passwordInput).fill(password);
    }

    public void clickLoginButton() {
        page.locator(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getFlashMessage() {
        return page.locator(flashMessage).innerText();
    }

    public boolean isFlashMessageVisible() {
        return page.locator(flashMessage).isVisible();
    }
}