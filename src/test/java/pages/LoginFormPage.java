package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {

    public LoginFormPage(WebDriver browser) {
        super(browser);
    }

    public LoginFormPage typeLogin(String login){
        browser.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("TestingSE");
        return this;

    }
    public LoginFormPage typePassword(String password) {
        browser.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
        return this;
    }
    public SecretPage clickLogin() {
        browser.findElement(By.linkText("SIGN IN")).click();
        return new SecretPage(browser);
    }

    public SecretPage doLogin(String login, String password){
        typeLogin(login);
        typePassword(password);
        clickLogin();
        return new SecretPage(browser);
    }

}
