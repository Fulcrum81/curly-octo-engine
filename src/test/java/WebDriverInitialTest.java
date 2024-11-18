import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class WebDriverInitialTest {

    @Test
    public void startBrowserTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


        driver.get("https://litecart.stqa.ru/en/");

        WebElement siteMenu = driver.findElement(By.id("site-menu"));


        List<WebElement> elementsWithRubberDucksText = driver.findElements(By.xpath(".//a[text()='Rubber Ducks']"));

        System.out.println(elementsWithRubberDucksText.size());

//
//        WebElement purpleDuckLink = driver.findElement(By.cssSelector("[alt='Purple Duck']"));
//        purpleDuckLink.click();
//
//        WebElement addToCartButton = driver.findElement(By.cssSelector("[name='add_cart_product'][type='submit']"));
//        addToCartButton.click();
//
//        By cartQuantityLabelLocator = By.cssSelector("span[class='quantity']");
//        WebElement cartQuantityLabel = driver.findElement(cartQuantityLabelLocator);
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        wait.until(ExpectedConditions.textToBe(By.cssSelector("span[class='quantity']"), "1"));
//


//        Assert.assertEquals(cartQuantityLabel.getText(), "1");

        driver.quit();
    }

    @Test
    public void dblClickTesst() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleClickButton = driver.findElement(By.tagName("button"));

        Actions actions = new Actions(driver);

        actions.doubleClick(doubleClickButton).perform();

    }

    @Test
    public void goalTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://learn.javascript.ru/article/mouse-drag-and-drop/ball4/");

        WebElement ball = driver.findElement(By.id("ball"));
        WebElement goal = driver.findElement(By.id("gate"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(ball, goal).perform();
    }

    @Test
    public void ballTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://learn.javascript.ru/article/mouse-drag-and-drop/ball4/");

        WebElement ball = driver.findElement(By.id("ball"));

        Actions actions = new Actions(driver);

        actions.dragAndDropBy(ball, -100, -50).perform();
    }

    @Test
    public void alertsTest() {
        String expectedAlertText = "I am a JS Alert";
        String expectedResultText = "You clicked: Ok";
        SoftAssert softAssert = new SoftAssert();


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();

        Alert alert = driver.switchTo().alert();
        softAssert.assertEquals(alert.getText(), expectedAlertText);
        alert.accept();

        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        alert = driver.switchTo().alert();
        alert.accept();
        softAssert.assertEquals(driver.findElement(By.id("result")).getText(), expectedResultText);

        softAssert.assertAll();

    }

    @Test
    public void selectTest() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByValue("2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");
    }

    public void waitForJquery(WebDriver driver, int waitSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(waitSeconds)).pollingEvery(Duration.ofMillis(10))
                .until((ExpectedCondition<Boolean>) d -> (Boolean)(((JavascriptExecutor)d).executeScript("return jQuery.active === 0")));
    }

    @Test
    public void framesTest() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");

        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.quit();
    }

    @Test
    public void shadowDomTest() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://apearce.github.io/react-shadow-root/");

        WebElement focusDemo = driver.findElement(By.cssSelector(".output>focus-demo"));
        SearchContext focusDemoShadowDom = focusDemo.getShadowRoot();

        focusDemoShadowDom.findElement(By.cssSelector("input[placeholder='Input inside shadow dom']")).sendKeys("Hello World!");

    }

}
