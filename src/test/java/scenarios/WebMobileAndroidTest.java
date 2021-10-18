package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;

import java.util.List;

public class WebMobileAndroidTest extends BaseTest {

    @Test(groups = {"web"}, description = "Check that emulator find keyword in Android device"
            , dataProviderClass = DataProvider.class, dataProvider = "webData")
    public void searchKeywordEpamTestAndroid(String url, String keyword) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        getDriver().get(url);

        new WebDriverWait(getDriver(), 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        WebPageObject webApp = new WebPageObject(getDriver());
        getPo().getWebElement("searchBar").click();
        getPo().getWebElement("searchBar").sendKeys(keyword);
        getPo().getWebElement("searchBar").sendKeys(Keys.ENTER);

        List<WebElement> listResult = webApp.getSearchList();
        Assert.assertFalse(listResult.isEmpty());

        for (int i = 0; i < listResult.size(); i++) {
            Assert.assertTrue(webApp.checkIfSearchResultContainsText(keyword),
                    "Search not correct");
        }
    }
}
