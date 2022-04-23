package pages;

import org.openqa.selenium.WebDriver;


public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignInPage clickOnSighnInPage(String xpath){
        log.getLog("Clicked on clickonsiginpage method");
        timeToWait.explicitWaits(driver,20,xpath,"xpath");
        action.makeAction("xpath",xpath,true);
        return new SignInPage(driver);
    }
}
