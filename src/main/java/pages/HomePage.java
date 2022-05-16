package pages;

import com.epam.healenium.SelfHealingDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class HomePage extends PageBase {
    public HomePage(WebDriver driver) throws IOException {
        super(driver);
    }

    public SignInPage clickOnSighnInPage(String xpath) throws IOException, ParseException {
        log.getLog("Clicked on clickonsiginpage method");
        timeToWait.explicitWaits(driver, 20, getLocatorsFromJsonFile(xpath), "xpath");
        action.makeAction("xpath", getLocatorsFromJsonFile(xpath), true);
        return new SignInPage(driver);
    }
}
