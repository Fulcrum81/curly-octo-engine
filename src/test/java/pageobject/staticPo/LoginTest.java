package pageobject.staticPo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTest extends TestBase {

    @Test
    public void loginWithCorrectEmailAndWrongPassword() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Thread.sleep(10000);

        LoginPage.loginWithCredentials(driver, "vadim.zubovich@gmail.com", "kjszhvbsakjhvb");
        softAssert.assertTrue(LoginPage.errorMessageIsDisplayed(driver), "Error message is not displayed");
        softAssert.assertEquals(LoginPage.getErrorMessageText(driver), "Wrong password or the account is disabled, or does not exist");
        softAssert.assertAll();
    }
}
