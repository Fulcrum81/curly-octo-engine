package pageobject.selenide;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginWithCorrectEmailAndWrongPassword() {
        LoginPage.loginWithCredentials("vadim.zubovich@gmail.com", "kjszhvbsakjhvb");
        LoginPage.validateErrorMessageIsDisplayed();
        LoginPage.validateErrorMessageText("Wrong password or the account is disabled, or does not exist");
    }

    @Test
    public void loginWithCorrectCredentials() {
        LoginPage.loginWithCredentials("vadim.zubovich@gmail.com", "Test1234!");
    }
}
