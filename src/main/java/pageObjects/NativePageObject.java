package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject {
    protected final String APP_PACK_NAME = "platkovsky.alexey.epamtestapp";

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

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

}
