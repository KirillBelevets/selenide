package сontentGuru;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AfterLoginPage {

    WebDriver driver;

    public AfterLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userIcon = By.cssSelector("*[class*='mediumIcon']");
    By logOutIcon = By.className("logout");

    public WebElement userIconFind () {
        return driver.findElement(userIcon);
    }
    public WebElement logOutUser () {
        return driver.findElement(logOutIcon);
    }

}
