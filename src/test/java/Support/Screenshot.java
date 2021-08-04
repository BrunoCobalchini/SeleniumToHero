package Support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {
    public static void takeShot(WebDriver browser, String file) {
        File screenshot = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(file));
        }catch (Exception e){
            System.out.println("There's a problem!!" + e.getMessage());
        }
    }
}
