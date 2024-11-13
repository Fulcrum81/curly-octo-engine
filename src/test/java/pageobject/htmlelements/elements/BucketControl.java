package pageobject.htmlelements.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(id = "cart")
public class BucketControl extends HtmlElement {
    @FindBy(className = "image")
    private WebElement cartImage;

    @FindBy(className = "content")
    private WebElement cartLabel;

    @FindBy(className = "quantity")
    private WebElement itemsQuantity;

    @FindBy(className = "formatted_value")
    private WebElement amount;

    @FindBy(className = "link")
    private WebElement checkoutLink;

    public int getItemsQuantity() {
        return Integer.parseInt(itemsQuantity.getText());
    }

    public char getCurrency() {
        return amount.getText().replaceAll("\\d.\\d", "")
                .replaceAll("\\d,\\d", "")
                .replaceAll(" ", "").toCharArray()[0];
    }

    public double getTotalAmount() {
        return Double.parseDouble(amount.getText().replaceAll("\\$", "").replaceAll("€", ""));
    }

    public void clickCheckoutLink() {
        checkoutLink.click();
    }
}
