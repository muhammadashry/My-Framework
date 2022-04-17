package pages;

import helper.Actions;
import helper.Logs;
import helper.Waits;
import org.openqa.selenium.WebDriver;

public class PageBase {
    protected   WebDriver driver;
    protected Waits timeToWait ;
    protected Actions makeAction ;
    protected Logs log ;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        timeToWait = new Waits(driver);
        makeAction = new Actions(driver);
        log = new Logs(driver);
    }

}
