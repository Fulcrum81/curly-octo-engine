package pageobject.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class LoginPage {

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(css = ".notice.errors")
    private WebElement errorMessageLabel;

    @FindAll({@FindBy(css="zdfsdfh"), @FindBy(id = "myId")})
    List<WebElement> allElements;

    @FindBys({@FindBy(id = "afd")})
    WebElement someElement;

    public void typeEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void typePassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void loginWithCredentials(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }

    public boolean errorMessageIsDisplayed() {
        return errorMessageLabel.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMessageLabel.getText();
    }
}