package pageobject.staticPo;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Browsers.CHROME;

public class TestBase {

    WebDriver driver;
    String baseUrl = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public void methodSetup() throws MalformedURLException {

        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName("Linux");
        browserOptions.setBrowserVersion("131");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-ubuntutranslate-cf8f2");
        sauceOptions.put("accessKey", "be2d1bfa-0b9e-4ef1-8686-d12a3e20071c");
        sauceOptions.put("build", "Build nr 12345");
        sauceOptions.put("name", "Regression");
        browserOptions.setCapability("sauce:options", sauceOptions);

// start the session
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);
//        String browser = System.getProperty("browser", "chrome");
//        Platform platform = Platform.valueOf(System.getProperty("os", "WINDOWS"));
//
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setBrowserName(browser);
//        caps.setVersion("120");
//        caps.setPlatform(platform);
//
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

//        driver = switch (browser) {
//            case "chrome" -> new ChromeDriver();
//            case "firefox" -> new FirefoxDriver();
//            case "safari" -> new SafariDriver();
//            case "edge" -> new EdgeDriver();
//            default -> new ChromeDriver();
//        };

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get(baseUrl);
    }

    @AfterMethod
    public void methodTeardown() {
        driver.quit();
    }
}
