package pageobject.fluent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ErrorPage {
    private By errorMessageLabel = By.cssSelector(".notice.errors");

    private WebDriver driver;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public ErrorPage validateThatErrorMessageIsDisplayed() {
        Assert.assertTrue(driver.findElement(errorMessageLabel).isDisplayed());
        return this;
    }

    public ErrorPage validateErrorMessageText(String expectedErrorMessage) {
        Assert.assertEquals(driver.findElement(errorMessageLabel).getText(), expectedErrorMessage);
        return this;
    }
}
