package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;

import java.util.List;

public class WebMobileIOsTest extends BaseTest {


    @Test(groups = {"web"}, description = "Check that emulator find keyword in IOs device"
            , dataProviderClass = DataProvider.class, dataProvider = "webData")
    public void searchKeywordEpamTestIOS(String url, String keyword) throws Exception {

        getDriver().get(url);

        new WebDriverWait(getDriver(), 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        WebPageObject webApp = new WebPageObject(getDriver());

        getPo().getWebElement("searchBar").sendKeys(keyword);
        getPo().getWebElement("searchBar").submit();


        List<WebElement> listResult = webApp.getSearchList();
        Assert.assertFalse(listResult.isEmpty());

        new WebDriverWait(getDriver(), 40).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        assert (getPo().getWebElements("searchBar").get(1).getText().contains(keyword));
    }
}
