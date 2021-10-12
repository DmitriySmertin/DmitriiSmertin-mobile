package scenarios;

import org.testng.annotations.Test;

import pageObjects.PageObject;
import setup.BaseTest;

import static pageObjects.NativePageObject.fillAuthorizationFields;
import static pageObjects.NativePageObject.fillRegistrationFields;
import static setup.PropertyReader.*;


public class epamAppNativeTests extends BaseTest {
    @Test(groups = {"native"}, description = "Positive test registration and authorization")
    public void positiveRegistrationAndAuthorizationTest() throws IllegalAccessException, NoSuchFieldException {
        PageObject epamAppPo = (PageObject) getPo();
        fillRegistrationFields(epamAppPo, getEmail(), getName(), getPass());
        fillAuthorizationFields(epamAppPo, getEmail(), getPass());
        assert epamAppPo.getWelement("mainForm").isDisplayed();
    }
}
