package pageobject.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;

@Listeners({ReportPortalTestNGListener.class, ScreenshotListener.class})
public class TestBase {

    String baseUrl = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public void methodSetup() {
        String browser = System.getProperty("browser", "chrome");
        String platform = System.getProperty("os", "linux");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browser);
//        caps.setVersion("120");

        switch(platform) {
            case "win" -> caps.setPlatform(Platform.WINDOWS);
            case "linux" -> caps.setPlatform(Platform.LINUX);
            case "mac" -> caps.setPlatform(Platform.MAC);
        }

        Configuration.remote = "http://192.168.249.1:4444/wd/hub";
        Configuration.browserCapabilities = caps;
        Configuration.browser = browser;
        Configuration.pageLoadTimeout = 5000;
//        Configuration.browserSize = "1920x1080";

        open("http://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void methodTeardown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
            try {
                Allure.addAttachment("screenshot" + result.getMethod().getMethodName(), new FileInputStream(screenshot));
            } catch(FileNotFoundException e) {
                System.out.println("Couldn't take screenshot\n" + e.getMessage());
            }
        }

    }
}
