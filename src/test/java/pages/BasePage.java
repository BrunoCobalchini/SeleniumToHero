package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver browser;

    public BasePage(WebDriver browser){
        this.browser = browser;
    }

    public String captureTextToast(){
       return browser.findElement(By.id("toast-container")).getText();

    }
}
