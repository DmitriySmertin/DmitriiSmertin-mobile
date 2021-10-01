package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.IPageObject;

public class NativePageObject extends PageObject {
    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    protected final String APP_PACK_NAME = "platkovsky.alexey.epamtestapp";
    String email = "mitya@mail.ru";
    String name = "mitya";
    String pass = "12345678";

    @AndroidFindBy(id = APP_PACK_NAME + ":id/email_sign_in_button")
    WebElement signInBtn;
    @AndroidFindBy(id = APP_PACK_NAME + ":id/register_button")
    WebElement regBtn;
    @AndroidFindBy(id = APP_PACK_NAME + ":id/registration_email")
    WebElement regEmailField;
    @AndroidFindBy(id = APP_PACK_NAME + ":id/registration_username")
    WebElement regUserNameField;
    @AndroidFindBy(id = APP_PACK_NAME + ":id/registration_password")
    WebElement regPassField;
    @AndroidFindBy(id = APP_PACK_NAME + ":id/registration_confirm_password")
    WebElement regPassConfirmField;
    @AndroidFindBy(className = "android.widget.CheckedTextView")
    WebElement checkBoxAgreements;
    @AndroidFindBy(id = APP_PACK_NAME + ":id/register_new_account_button")
    WebElement regNewAccount;
    @AndroidFindBy(id= APP_PACK_NAME + ":id/login_email")
    WebElement loginEmailField;
    @AndroidFindBy(id= APP_PACK_NAME + ":id/login_pwd")
    WebElement loginPassField;
    @AndroidFindBy(id= APP_PACK_NAME + ":id/main_content")
    WebElement mainForm;




    public static void fillRegistrationFields(PageObject po, String email, String userName, String pass) throws NoSuchFieldException, IllegalAccessException
    {
        po.getWelement("regBtn").click();
        po.getWelement("regEmailField").sendKeys(email);
        po.getWelement("regUserNameField").sendKeys(userName);
        po.getWelement("regPassField").sendKeys(pass);
        po.getWelement("regPassConfirmField").sendKeys(pass);
        po.getWelement("checkBoxAgreements").click();
        po.getWelement("regNewAccount").click();
    }
    public static void fillAuthorizationFields(PageObject po,String email,String pass) throws NoSuchFieldException, IllegalAccessException {
        po.getWelement("loginEmailField").sendKeys(email);
        po.getWelement("loginPassField").sendKeys(pass);
        po.getWelement("signInBtn").click();
    }

}
