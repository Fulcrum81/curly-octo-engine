package pageobject.selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Do nothing")
@Feature("Lazy @$$")
public class AddToCartTest extends TestBase {


    @Description("This is a lazy test that doesn't do anything... just like me")
    @Test(testName = "I don't do much really")
    public void doNothingTest() {

    }
}
