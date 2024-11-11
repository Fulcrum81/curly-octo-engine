package pageobject.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void methodSetup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void methodTeardown() {
        driver.quit();
    }

    @Test
    public void loginWithCorrectEmailAndWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .loginWithIncorrectCredentials("vadim.zubovich@gmail.com", "kjszhvbsakjhvb")
                .validateThatErrorMessageIsDisplayed()
                .validateErrorMessageText("Wrong password or the account is disabled, or does not exist");
   }
}
