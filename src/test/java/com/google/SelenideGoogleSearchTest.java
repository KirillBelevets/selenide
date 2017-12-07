package com.google;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.google.SearchPage;
import selenide.pages.google.SearchResultPage;
import selenium.SeleniumWebDriverBase;

import static com.codeborne.selenide.CollectionCondition.size;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static selenide.util.PropertiesCache.getProperty;

@Feature("Search Test")
@Story("STORY-111")
public class SelenideGoogleSearchTest extends SeleniumWebDriverBase {
    private String searchText = getProperty("searchtext");
    private String url = getProperty("url");
    private int sizeList = Integer.parseInt(getProperty("size"));
    private SearchPage searchPage = new SearchPage();

    @Test(enabled=false)
    public void searchTest() {
        $(By.name("q")).val(searchText).submit();
        $$("#ires .srg .g").shouldHave(size(10));
    }


    @Test
    public void pageObjectSearchTest () {
        open(url);
        searchPage.searchFor(searchText);
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.getLinkResults().shouldHaveSize(sizeList).first().shouldHave(text(searchText));
    }

}
