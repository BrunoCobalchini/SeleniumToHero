package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretPage extends BasePage {

    public SecretPage(WebDriver browser) {
        super(browser);
    }

    public MePage meClick(){
        browser.findElement(By.className("me")).click();
        return new MePage(browser);
    }
}
