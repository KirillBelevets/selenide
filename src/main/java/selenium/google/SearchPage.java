package selenium.google;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.pages.AbstractPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class SearchPage extends AbstractPage {

    private By searchLocator = (By.name("q"));
    private WebElement search;

    public SearchPage (WebDriver webDriver) {
        super(webDriver);
    }

    public SearchPage searchFor (String searchText) {
        search  = waitFor(presenceOfElementLocated(searchLocator));
        search.sendKeys(searchText);
        search.submit();
        return this;
    }

}
