package pageobject.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;

    @Given("User is on login page")
    public void User_is_on_login_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
    }


    @When("User enters {string} in email input")
    public void userEntersInEmailInput(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    @When("User enters {string} in password input")
    public void userEntersInPasswordInput(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("User clicks login button")
    public void userClicksLoginButton() {
        driver.findElement(By.name("login")).click();
    }

    @Then("Error message appears")
    public void errorMessageAppears() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".notice.errors")).isDisplayed());
    }

    @Then("Error message contains {string} text")
    public void errorMessageContainsText(String expectedText) {
        Assert.assertEquals(driver.findElement(By.cssSelector(".notice.errors")).getText(), expectedText);
    }
}
