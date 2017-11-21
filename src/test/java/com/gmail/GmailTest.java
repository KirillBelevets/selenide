package com.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GmailTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com/intl/ru/gmail/about/");

    }
    @Test
    public void verifyGmail() {
        String titleActual = driver.getTitle();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(titleActual, "Gmail – электронная почта и бесплатное хранилище от Google");
    }
    @Test(dependsOnMethods = "verifyGmail")
    public void goToSignIn () {
        WebElement signIn = driver.findElement(By.cssSelector("a[class*='sign-in']"));
        signIn.click();
    }
    @Test(dependsOnMethods = "goToSignIn")
    public void enterEmail() {
        WebElement emailField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='identifierId']")));
        emailField.sendKeys("selenideselenium@gmail.com");
        driver.findElement(By.cssSelector("*[id='identifierNext']")).click();
    }
    @Test(dependsOnMethods = "enterEmail")
    public void enterPassword () {
        WebElement passwordField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordField.sendKeys("QAZxsw123---");
        driver.findElement(By.id("passwordNext")).click();
    }
    @Test(dependsOnMethods = "enterPassword")
    public void verifyLoggedInAndEmails() {
        WebElement inbox = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".TN.GLujEb.aHS-bnt")));
        String inboxTest = inbox.getText();
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(inboxTest);
        String inboxLetters="";
        while(m.find()) {
            inboxLetters = m.group(1);
        }
        inbox.click();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://mail.google.com/mail/u/0/#inbox");
        List<WebElement> listEmails = driver.findElements(By.cssSelector("*[class='zF']"));
        Assert.assertTrue(!listEmails.isEmpty());
        Integer actualLetters = listEmails.size()/2;
        String actualLettersString = actualLetters.toString();
        Assert.assertEquals(actualLettersString, inboxLetters);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}