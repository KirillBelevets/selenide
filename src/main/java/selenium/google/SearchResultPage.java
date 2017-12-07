package selenium.google;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.pages.AbstractPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage extends AbstractPage {

    private By linkResultLocators = By.cssSelector("#ires .g");
    private List<WebElement> linkResults;

    public SearchResultPage (WebDriver webDriver) {
        super(webDriver);
    }



    public List<WebElement> getLinkResults () {
        linkResults = webDriver.findElements(linkResultLocators);
        return linkResults;
    }
}
