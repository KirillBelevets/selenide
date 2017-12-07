package selenium.google;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.SeleniumWebDriverBase;

public class AlertTest extends SeleniumWebDriverBase {

    String url = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";

    @Test
    public void alertHandle () {
        webDriver.get(url);
        webDriver.switchTo().frame("iframeResult");
        WebElement button = webDriver.findElement(By.cssSelector("button"));
        button.click();
        Alert al = webDriver.switchTo().alert();
        System.out.println(al.getText());
        al.accept();
    }
}
