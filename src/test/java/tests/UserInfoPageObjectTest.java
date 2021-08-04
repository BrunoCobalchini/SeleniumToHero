package tests;

import Support.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "UserInfoPageObjectTest.csv")
public class UserInfoPageObjectTest {
    private WebDriver browser;

    @Before
    public void setUp(){

        browser = Web.createChrome();
    }

    @Test
    public void AddSomeInfoTest(@Param(name="login")String login,
                                @Param(name="password")String password,
                                @Param(name="type")String type,
                                @Param(name="contact")String contact,
                                @Param(name="message")String message){

        String toastText = new LoginPage(browser)
                .clickSignIn()
                .doLogin(login, password)
                .meClick()
                .clickMoreDataAboutYou()
                .clickButtonMoreDataAboutYou()
                .addContact(type, contact)
                .captureTextToast();

        Assert.assertEquals(message, toastText);
    }

    @After
    public void tearDown(){

    }
}
