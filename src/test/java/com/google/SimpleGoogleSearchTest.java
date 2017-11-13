package com.google;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SimpleGoogleSearchTest {

    private WebDriver webDriver;
    private String searchText = "Selenium";
    private String resultLinkText = "Selenium - Web Browser Automation";

    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com.ua");
    }

    @Test
    public void searchTest() {

        By searchFieldLocator = By.id("lst-ib");
        WebElement searchField = webDriver.findElement(searchFieldLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        By resultLinkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
//        By resultLinkLocator = By.cssSelector("h3.r>a");
        WebElement resultLink = webDriver.findElement(resultLinkLocator);
        assertTrue(resultLink.getText().contains(searchText));
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
}
