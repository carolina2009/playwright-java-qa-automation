package tests;

import base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataDrivenLoginTests extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "wrongUser, wrongPassword, Your username is invalid!",
            "tomsmith, wrongPassword, Your password is invalid!",
            "invalidUser, SuperSecretPassword!, Your username is invalid!"
    })
    void invalidLoginShouldShowExpectedErrorMessage(String username, String password, String expectedMessage) {
        LoginPage loginPage = new LoginPage(page);

        loginPage.navigateToLoginPage();
        loginPage.login(username, password);

        String actualMessage = loginPage.getFlashMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}