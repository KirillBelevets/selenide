package selenide.pages.google;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

    private ElementsCollection linkResults = $$ ("#ires .g");

    public ElementsCollection getLinkResults () {
        return linkResults;
    }
}
