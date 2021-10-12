package setup;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface IDriver {

    MobileDriver<? extends WebElement> getDriver();

}
