package selenium.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import selenium.SeleniumWebDriverBase;


public class SelectTest extends SeleniumWebDriverBase {

    @Test
    public void select () {
        webDriver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        WebElement frame = webDriver.findElement(By.id("iframe"));
        webDriver.switchTo().frame("iframeResult");
        WebElement selectInFrame = webDriver.findElement(By.cssSelector("select"));
        Select select1 = new Select(selectInFrame);
        select1.selectByValue("audi");
        webDriver.switchTo().defaultContent();
        System.out.println(select1.isMultiple());


    }
}
