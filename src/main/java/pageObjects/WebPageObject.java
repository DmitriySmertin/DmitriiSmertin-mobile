package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject extends PageObject  {

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }
//    @FindBy(css = "input[title='Поиск']")
//    WebElement searchBar;
//
//    @FindBy(css = "input[name='btnK']")
//    WebElement searchBtn;
//

//    public static void openPage(AppiumDriver driver, String url)
//    {
//        driver.get(url);
//    }


}
