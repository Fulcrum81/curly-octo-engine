package pageobject.selenide;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");
    private static By errorMessageLabel = By.cssSelector(".notice.errors");

    public static void typeEmail(String email) {
        $(emailInput).sendKeys(email);
    }

    public static void typePassword(String password) {
        $(passwordInput).sendKeys(password);
    }

    public static void clickLoginButton() {
        $(loginButton).click();
    }

//    @Step("Login with defined credentials")
    public static void loginWithCredentials(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }

//    @Step("Validate that the error message is displayed")
    public static void validateErrorMessageIsDisplayed() {
        $(errorMessageLabel).shouldBe(visible);
        $(errorMessageLabel).should(disappear);
    }

//    @Step("Validate that the error message text matches expectation")
    public static void validateErrorMessageText(String expectedText) {
        $(errorMessageLabel).shouldHave(text(expectedText));
    }

    public static void useActions() {
        actions().keyDown(Keys.CONTROL).click().release().perform();
    }
}