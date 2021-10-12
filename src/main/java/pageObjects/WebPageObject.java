package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebPageObject extends PageObject {

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }

    @FindBy(css = "input[title='Поиск']")
    WebElement searchBar;
    @FindBy(css = "div[id='rso'] div[role='heading'][aria-level='3']")
    private List<WebElement> searchResults;

    public WebElement getSearchField() {
        return searchBar;
    }

    public List<WebElement> getSearchList() {
        return searchResults;
    }

    public Boolean checkIfSearchResultContainsText(String searchTeem) {
        for (WebElement searchItem : getSearchList()) {
            if (searchItem.getText().contains(searchTeem)) {
                return true;
            }
        }
        return false;
    }


}
