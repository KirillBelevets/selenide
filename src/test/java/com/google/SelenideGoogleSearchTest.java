package com.google;

import org.openqa.selenium.By;

import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.google.SearchPage;
import selenide.pages.google.SearchResultPage;

import static com.codeborne.selenide.CollectionCondition.size;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static selenide.util.PropertiesCache.getProperty;


public class SelenideGoogleSearchTest extends SelenideTestBase {
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
