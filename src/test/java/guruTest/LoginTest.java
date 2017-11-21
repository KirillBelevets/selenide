package guruTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import сontentGuru.ContentGuruBaseClass;
import сontentGuru.ContentGuruHome;

import static сontentGuru.util.PropertiesCacheGuru.getProperty;

public class LoginTest extends ContentGuruBaseClass {

    String email = getProperty("emailzakazchik");
    String password = getProperty("password");
    String emailauthor = getProperty("emailauthor");
    String passwortauthor = getProperty("passwortauthor");


    @Test(dependsOnMethods = "loginPositiveAuthor")
    public void loginPositiveZakazchik() {
        ContentGuruHome guruHome = new ContentGuruHome(driver);
        driver.manage().window().maximize();
        guruHome.sendToEmailField().sendKeys(email);
        guruHome.sendPassword().sendKeys(password);
        guruHome.loginButton().submit();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://content-guru-282f4.firebaseapp.com/customer");
        Assert.assertTrue(driver.findElement(By.className("logo")).isDisplayed());
    }

    //commented because logOut Button is not functional
    /*@AfterMethod
    public void logOut() {
        AfterLoginPage alpage = new AfterLoginPage(driver);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='mediumIcon']")));
        System.out.println("aftermethod");
        alpage.userIconFind().click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='logout']")));
        alpage.logOutUser().click();
    }*/
    @AfterMethod
    public void goToLoginAgain() {
        driver.get("https://content-guru-282f4.firebaseapp.com/home");
    }

    @Test
    public void loginPositiveAuthor() {
        ContentGuruHome guruHome = new ContentGuruHome(driver);
        driver.manage().window().maximize();
        guruHome.sendToEmailField().sendKeys(emailauthor);
        guruHome.sendPassword().sendKeys(passwortauthor);
        guruHome.loginButton().submit();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://content-guru-282f4.firebaseapp.com/author"));
    }
}
