package pages;

import helper.MyActions;
import helper.Logs;
import helper.Waits;
import org.openqa.selenium.WebDriver;

public class PageBase {
    protected   WebDriver driver;
    protected Waits timeToWait ;
    protected MyActions action;
    protected Logs log ;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        timeToWait = new Waits(driver);
        action = new MyActions(driver);
        log = new Logs(driver);
    }

}
