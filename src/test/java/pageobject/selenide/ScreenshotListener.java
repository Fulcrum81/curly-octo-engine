package pageobject.selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.service.ReportPortal;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshot = ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Allure.addAttachment("screenshot" + result.getMethod().getMethodName(), new FileInputStream(screenshot));
        } catch(FileNotFoundException e) {
            System.out.println("Couldn't take screenshot\n" + e.getMessage());
        }
        ReportPortal.emitLog("Failure", "ERROR", Calendar.getInstance().getTime(), screenshot);
    }
}
