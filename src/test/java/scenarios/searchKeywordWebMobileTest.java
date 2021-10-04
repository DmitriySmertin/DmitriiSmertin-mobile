package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import setup.BaseTest;

import java.util.List;

public class searchKeywordWebMobileTest extends BaseTest {

    @Test(groups = {"web"}, description = "Check that emulator find key word"
            , dataProviderClass = DataProvider.class, dataProvider = "webData")
    public void searchEpamTest(String url, String keyWord) throws NoSuchFieldException, IllegalAccessException {

        getDriver().get(url);
        new WebDriverWait(getDriver(), 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        PageObject webApp = (PageObject) getPo();
        webApp.getWelement("searchBar").click();
        webApp.getWelement("searchBar").sendKeys(keyWord);
        webApp.getWelement("searchBar").sendKeys(Keys.ENTER);

        List<WebElement> listResult = webApp.getSearchList();
        Assert.assertFalse(listResult.isEmpty());

        for (int i = 0; i < listResult.size(); i++) {
            Assert.assertTrue(webApp.checkIfSearchResultContainsText(keyWord),
                    "Search not correct");
        }

    }
}
