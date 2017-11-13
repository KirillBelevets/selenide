package com.google;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideGoogleSearchTest {
    private String searchText = "Selenium";
    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = WebDriverRunner.CHROME;
        open("https://www.google.com.ua");

    }
    @Test
    public void searchTest() {
        $(By.name("q")).val(searchText).submit();
//        $(By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a")).should(visible, text(searchText));
        $$("#ires .srg .g").shouldHave(size(10));
    }

}
