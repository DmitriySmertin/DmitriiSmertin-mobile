package scenarios;

import org.testng.annotations.Test;

import pageObjects.PageObject;
import setup.BaseTest;

import static pageObjects.NativePageObject.fillAuthorizationFields;
import static pageObjects.NativePageObject.fillRegistrationFields;


public class epamTestAppMobileTests extends BaseTest {
    @Test(groups = {"EpamTestApp"}, description = "Positive test registration and authorization")
    public void positiveRegistrationAndAuthorizationTest() throws IllegalAccessException, NoSuchFieldException {
        PageObject epamAppPo = (PageObject) getPo();
        fillRegistrationFields(epamAppPo, getEmail(), getName(), getPass());
        fillAuthorizationFields(epamAppPo, getEmail(), getPass());
        assert epamAppPo.getWelement("mainForm").isDisplayed();
    }
}
