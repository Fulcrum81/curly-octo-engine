package pageobject.htmlelements.pages;

import org.openqa.selenium.WebDriver;
import pageobject.htmlelements.elements.BucketControl;
import pageobject.htmlelements.elements.FooterMenu;
import pageobject.htmlelements.elements.HeaderMenu;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class HomePage {

    public BucketControl bucketControl;
    public HeaderMenu headerMenu;
    public FooterMenu footerMenu;

    public HomePage(WebDriver driver) {
        HtmlElementLoader.populate(this, driver);
    }
}
