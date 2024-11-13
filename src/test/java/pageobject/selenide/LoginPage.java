package pageobject.selenide;

import com.codeborne.selenide.Condition;
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

    public static void loginWithCredentials(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }

    public static void validateErrorMessageIsDisplayed() {
        $(errorMessageLabel).shouldBe(visible);
        $(errorMessageLabel).should(disappear);
    }

    public static void validateErrorMessageText(String expectedText) {
        $(errorMessageLabel).shouldHave(text(expectedText));
    }

    public static void useActions() {
        actions().keyDown(Keys.CONTROL).click().release().perform();
    }
}