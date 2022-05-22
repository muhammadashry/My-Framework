package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class NewUserHomePage extends PageBase {
    public NewUserHomePage(WebDriver driver) throws Exception {
        super(driver);
    }

    public NewUserHomePage clickOnBlousesCategory(String linktext, String hoverElement) throws InterruptedException, IOException, ParseException {
        action.makeHoverAction(getLocatorsFromJsonFile(hoverElement));
        timeToWait.explicitWaits(driver, 20, getLocatorsFromJsonFile(linktext), "linktext");
        action.makeAction("linktext", getLocatorsFromJsonFile(linktext), true);
        log.getLog("Click on SignInPage method");
        return this;
    }
}
