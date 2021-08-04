package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {

    public MePage(WebDriver browser) {
        super(browser);
    }

    public MePage clickMoreDataAboutYou(){
        browser.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        return this;
    }

    public AddContactPage clickButtonMoreDataAboutYou(){
        browser.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();
        return new AddContactPage(browser);
    }
}
