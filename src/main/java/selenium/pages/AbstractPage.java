package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public AbstractPage (WebDriver webDriver) {
        this.webDriver=webDriver;
        webDriverWait = new WebDriverWait(this.webDriver, 10);
    }
    public WebElement waitFor(ExpectedCondition<WebElement> expectedCondition) {
        return webDriverWait.until(expectedCondition);
    }

}
