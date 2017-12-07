package com.google;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideRosetkaIPhone8 {
    private String searchText = "iphone";
    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = WebDriverRunner.CHROME;
        open("https://rozetka.com.ua/");
    }
    @Test
    public void searchForIphone() {
        $(By.name("text")).val(searchText).submit();
        $(By.xpath(".//*[@id='catalog_goods_block']/div/div[1]/div[1]/div/div[1]")).should(visible, text("Apple iPhone 8 64GB Gold"));
    }

}
