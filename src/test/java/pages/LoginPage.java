package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public LoginFormPage clickSignIn(){
        browser.findElement(By.linkText("Sign in")).click();
        return new LoginFormPage(browser);
    }
}
