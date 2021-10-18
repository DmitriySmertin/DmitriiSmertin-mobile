package scenarios;

import org.testng.annotations.Test;

import pageObjects.PageObject;
import setup.BaseTest;

import static pageObjects.NativePageObject.fillAuthorizationFields;
import static pageObjects.NativePageObject.fillRegistrationFields;
import static setup.PropertyReader.*;


public class EpamAppNativeAndroidTests extends BaseTest {
    @Test(groups = {"native"}, description = "Positive test registration and authorization Android device")
    public void positiveRegistrationAndAuthorizationTestAndroid() throws IllegalAccessException, NoSuchFieldException {
        PageObject epamAppPo = (PageObject) getPo();
        fillRegistrationFields(epamAppPo, getEmail(), getName(), getPass());
        epamAppPo.getWebElement("checkBoxAgreements").click();
        fillAuthorizationFields(epamAppPo, getEmail(), getPass());
        assert epamAppPo.getWebElement("mainForm").isDisplayed();
        assert (epamAppPo.getWebElement("pageTitle").getText().equals(getPageTitleAndroid()));
    }
}
