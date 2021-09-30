package scenarios;

import org.testng.annotations.Test;
import pageObjects.EpamTestAppPO.HomePageObject;
import pageObjects.PageObject;
import setup.BaseTest;

public class epamTestAppMobileTests extends BaseTest {
    @Test(groups = {"EpamTestApp"}, description = "Test registration and authorization")
    public void registrationAndAuthorizationTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, InterruptedException {
        getPo().getWelement("regBtn").click();
        getPo().getWelement("regEmailField").sendKeys("mitya@mail.ru");
        getPo().getWelement("regUserNameField").sendKeys("mitya");
        getPo().getWelement("regPassField").sendKeys("Qwerty12345");
        getPo().getWelement("regPassConfirmField").sendKeys("Qwerty12345");
        getPo().getWelement("checkBoxAgreements").click();
        getPo().getWelement("regNewAccount").click();
        Thread.sleep(5000);
        getPo().getWelement("loginEmailField").sendKeys("mitya@mail.ru");
        getPo().getWelement("loginPassField").sendKeys("Qwerty12345");
        assert getPo().getWelement("mainForm").isDisplayed();


    }

}
