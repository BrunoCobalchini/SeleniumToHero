package tests;


import Support.Generator;
import Support.Screenshot;
import Support.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "UserFillTestData.csv")
public class UserFillTest {
        private WebDriver browser;

    @Rule
    public TestName test = new TestName();
    @Before
    public void setUp(){
        browser = Web.createChrome();

        //Click on Sign in Button
        browser.findElement(By.linkText("Sign in")).click();

        //Use the Sign In Box
        WebElement formSignInBox = browser.findElement(By.id("signinbox"));

        //Send the login info
        formSignInBox.findElement(By.name("login")).sendKeys("TestingSE");

        //Send the password info
        formSignInBox.findElement(By.name("password")).sendKeys("testingSelenium");

        //Click on sign in text link
        formSignInBox.findElement(By.linkText("SIGN IN")).click();

        //Click on sign in text link
        browser.findElement(By.className("me")).click();

        browser.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

    }

    @Test
    public void testAddSomeInfo(@Param(name="type")String type,@Param(name="contact")String contact,@Param(name="message")String message){
        // Add more data button
        browser.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();

        WebElement popupAddMoreData = browser.findElement(By.id("addmoredata"));

        WebElement comboBox = popupAddMoreData.findElement(By.name("type"));
        new Select(comboBox).selectByVisibleText(type);

        popupAddMoreData.findElement(By.name("contact")).sendKeys(contact);

        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        WebElement popMsg = browser.findElement(By.id("toast-container"));
        String msg = popMsg.getText();
        Assert.assertEquals(message, msg);

    }

    @Test
    public void removeSomeInfo(){
        // Remove the number 5599999999999
        browser.findElement(By.xpath("//*[@id=\"moredata\"]/div[1]/ul/li/a")).click();
        //Check the deletion message "Rest in peace, dear phone!"
        browser.switchTo().alert().accept();

        WebElement popMsg = browser.findElement(By.id("toast-container"));
        String msg = popMsg.getText();
        Assert.assertEquals("Rest in peace, dear phone!", msg);
        String shotFile = "C:\\TestReport\\prints\\" + Generator.dateTimeForFile() + test.getMethodName() + ".png";
        Screenshot.takeShot(browser, shotFile);

        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.stalenessOf(popMsg));

        browser.findElement(By.linkText("Logout")).click();
    }
    @After
    public void tearDown(){
        browser.quit();
    }
}