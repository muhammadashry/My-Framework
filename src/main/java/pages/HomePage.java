package pages;

import org.openqa.selenium.WebDriver;


public class HomePage extends PageBase {
    public HomePage(WebDriver driver) throws Exception {
        super(driver);
    }

    public SignInPage clickOnSighnInPage(String xpath) throws Exception {
        log.getLog("Clicked on clickonsiginpage method");
        timeToWait.explicitWaits(driver, 20, getLocatorsFromJsonFile(xpath), "xpath");
        action.makeAction("xpath", getLocatorsFromJsonFile(xpath), true);
        return new SignInPage(driver);
    }
}
