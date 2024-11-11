package pageobject.staticPo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");
    private static By errorMessageLabel = By.cssSelector(".notice.errors");

    public static void typeEmail(WebDriver driver, String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public static void typePassword(WebDriver driver, String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public static void clickLoginButton(WebDriver driver) {
        driver.findElement(loginButton).click();
    }

    public static void loginWithCredentials(WebDriver driver, String email, String password) {
        typeEmail(driver, email);
        typePassword(driver, password);
        clickLoginButton(driver);
    }

    public static boolean errorMessageIsDisplayed(WebDriver driver) {
        return driver.findElement(errorMessageLabel).isDisplayed();
    }

    public static String getErrorMessageText(WebDriver driver) {
        return driver.findElement(errorMessageLabel).getText();
    }
}