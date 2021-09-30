package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("signInBtn").click();
        System.out.println("Simplest Android native test done");
    }

    @Test(groups = {"native"}, description = "Test registration and authorization")
    public void registrationAndAuthorizationTest() throws IllegalAccessException,NoSuchFieldException,InstantiationException{

    }

}
