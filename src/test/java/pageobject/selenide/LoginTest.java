package pageobject.selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Login functionality implementation [CBR-12345]")
@Feature("Login")
public class LoginTest extends TestBase {

    @Description("This test attempts to login with correct email and incorrect password and verifies error message")
    @Test(testName = "Login with correct email and incorrect password")
    public void loginWithCorrectEmailAndWrongPassword() {
        LoginPage.loginWithCredentials("vadim.zubovich@gmail.com", "kjszhvbsakjhvb");
        LoginPage.validateErrorMessageIsDisplayed();
        LoginPage.validateErrorMessageText("Wrong password or the account is disabled, or does not exist");
    }

    @Description("This test attempts to login with correct email and password and verifies success message")
    @Test(testName = "Login with correct credentials")
    public void loginWithCorrectCredentials() {
        LoginPage.loginWithCredentials("vadim.zubovich@gmail.com", "Test1234!");
    }
}
