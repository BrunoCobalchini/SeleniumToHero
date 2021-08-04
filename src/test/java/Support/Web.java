package Support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();

        // Open the browser
        browser.get("http://www.juliodelima.com.br/taskit");
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return browser;
    }
}
