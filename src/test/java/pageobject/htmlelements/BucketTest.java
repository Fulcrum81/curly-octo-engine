package pageobject.htmlelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.htmlelements.pages.HomePage;

import java.time.Duration;

public class BucketTest {
    String baseUrl = "https://litecart.stqa.ru/en/";

    @Test
    public void bucketQuantityTest() {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);

        Assert.assertEquals(homePage.bucketControl.getTotalAmount(), 0);
    }
}
