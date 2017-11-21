package selenide.core;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.FIREFOX;
import static com.codeborne.selenide.WebDriverRunner.CHROME;

public class SelenideTestBase {
    private String browser = System.getProperty("browser", CHROME);
    @BeforeClass
    public void setUp() {
        Configuration.browser = browser.toUpperCase();
        Configuration.holdBrowserOpen = true;
        switch (browser) {
         case CHROME:
            ChromeDriverManager.getInstance().setup();
            open("https://www.google.com.ua");
            break;
         case FIREFOX:
             FirefoxDriverManager.getInstance().setup();
             break;
        }

    }
    @AfterClass
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }
}