package selenium.core;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import selenium.SeleniumWebDriverBase;

import java.io.File;

import static com.google.common.io.Files.toByteArray;
import static selenium.util.PropertiesCache.getProperty;

public class ITestListenerClass implements ITestListener {
    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Attachment(value = "{0}", type = "image/png")
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        driver = ((SeleniumWebDriverBase) iTestResult.getInstance()).webDriver;
        saveScreenshot(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        driver = ((SeleniumWebDriverBase) iTestResult.getInstance()).webDriver;
        saveScreenshot(iTestResult.getMethod().getMethodName());
    }

    @Attachment(value = "{0}", type = "image/png")
    public void saveScreenshot(String screenshotName) {
        try {
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File scrFile = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile,
                    new File("C:\\Screenshots\\" + screenshotName + ".png"));
//            return toByteArray(scrFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return new byte[0];
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}