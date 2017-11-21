package сontentGuru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContentGuruHome  {
     WebDriver driver;
    public ContentGuruHome (WebDriver driver) {
        this.driver = driver;
    }


    By emailField = By.id("mat-input-0");
    By password = By.id("mat-input-1");
    By buttonSubmitLogin = By.cssSelector("[type='submit']");

    public WebElement sendToEmailField () {
        return driver.findElement(emailField);
    }
    public WebElement sendPassword() {
        return driver.findElement(password);
    }
    public WebElement loginButton() {
        return driver.findElement(buttonSubmitLogin);
    }
}
