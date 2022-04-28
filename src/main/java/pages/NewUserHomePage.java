package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NewUserHomePage extends PageBase{
    public NewUserHomePage(WebDriver driver) {
        super(driver);
    }
    public NewUserHomePage clickOnBlousesCategory(String linktext,String hoverElement) throws InterruptedException {
        action.makeHoverAction(hoverElement);
        timeToWait.explicitWaits(driver,20,linktext,"linktext");
        action.makeAction("linktext",linktext,true);
        log.getLog("Click on SignInPage method");
        return this;
    }
}
