package selenium.google;

import org.testng.annotations.Test;
import selenium.SeleniumWebDriverBase;
import static org.testng.Assert.assertTrue;

public class SeleniumGoogleSearchTest extends SeleniumWebDriverBase {

    private String selenium = "Selenium";
    private SearchPage searchPage = new SearchPage(webDriver);

    @Test
    public void search() {
        webDriver.get("https://www.google.com.ua");
        searchPage.searchFor(selenium);
        SearchResultPage searchResultPage = new SearchResultPage(webDriver);
        searchResultPage.getLinkResults()
                .forEach(webElement ->
                assertTrue(webElement.getText().contains(selenium)));
    }
}
