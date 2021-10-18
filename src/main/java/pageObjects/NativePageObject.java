package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject {

    public NativePageObject(AppiumDriver<? extends WebElement> appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    protected final String APP_PACK_NAME = "platkovsky.alexey.epamtestapp:";

    @AndroidFindBy(id = APP_PACK_NAME + "id/email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    WebElement signInBtn;

    @AndroidFindBy(id = APP_PACK_NAME + "id/register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    WebElement regBtn;

    @AndroidFindBy(id = APP_PACK_NAME + "id/registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement regEmailField;

    @AndroidFindBy(id = APP_PACK_NAME + "id/registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    WebElement regUserNameField;

    @AndroidFindBy(id = APP_PACK_NAME + "id/registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement regPassField;

    @AndroidFindBy(id = APP_PACK_NAME + "id/registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    WebElement regPassConfirmField;

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    WebElement checkBoxAgreements;

    @AndroidFindBy(id = APP_PACK_NAME + "id/register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    WebElement regNewAccount;

    @AndroidFindBy(id = APP_PACK_NAME + "id/login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement loginEmailField;

    @AndroidFindBy(id = APP_PACK_NAME + "id/login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement loginPassField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BudgetActivity']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Budget']")
    WebElement pageTitle;


    public static void fillRegistrationFields(PageObject po, String email, String userName, String pass) throws NoSuchFieldException, IllegalAccessException {
        po.getWebElement("regBtn").click();
        po.getWebElement("regEmailField").sendKeys(email);
        po.getWebElement("regUserNameField").sendKeys(userName);
        po.getWebElement("regPassField").sendKeys(pass);
        po.getWebElement("regPassConfirmField").sendKeys(pass);
        po.getWebElement("checkBoxAgreements").click();
        po.getWebElement("regNewAccount").click();
    }

    public static void fillAuthorizationFields(PageObject po, String email, String pass) throws NoSuchFieldException, IllegalAccessException {
        po.getWebElement("loginEmailField").sendKeys(email);
        po.getWebElement("loginPassField").sendKeys(pass);
        po.getWebElement("signInBtn").click();
    }
}
