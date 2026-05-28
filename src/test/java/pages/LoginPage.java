package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    private final String loginUrl = "https://the-internet.herokuapp.com/login";
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

    public void login(String username, String password) {
        page.locator(usernameInput).fill(username);
        page.locator(passwordInput).fill(password);
        page.locator(loginButton).click();
    }

    public String getFlashMessage() {
        return page.locator(flashMessage).innerText();
    }
}