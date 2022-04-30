package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SignInPage extends PageBase {

    public SignInPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public SignInPage enterEmailToCreateNewAccount(String id, String email) throws IOException, ParseException {
        timeToWait.explicitWaits(driver, 20, getLocatorsFromJsonFile(id), "id");
        action.makeAction("id", getLocatorsFromJsonFile(id), email);
        log.getLog("Click on SignInPage method");
        return this;
    }

    public SignInPage enterEmailToLogIn(String id, String email) throws IOException, ParseException {
        timeToWait.explicitWaits(driver, 20, getLocatorsFromJsonFile(id), "id");
        action.makeAction("id", getLocatorsFromJsonFile(id), email);
        log.getLog("Enter your Email");
        return this;
    }

    public SignInPage enterPasswordToLogIn(String id, String password) throws IOException, ParseException, InterruptedException {
        action.makeAction("id", getLocatorsFromJsonFile(id), password);
        log.getLog("Enter your Email");
        Thread.sleep(5000);
        return this;
    }

    public CreateAnAccountPage clickOnCreateAnAccount(String id) throws IOException, ParseException {
        timeToWait.explicitWaits(driver, 10, getLocatorsFromJsonFile(id), "id");
        action.makeAction("id", getLocatorsFromJsonFile(id), true);
        log.getLog("Click on clickOnCreateAnAccount");
        return new CreateAnAccountPage(driver);

    }

    public NewUserHomePage clickOnSignIn(String id) throws IOException, ParseException {
        timeToWait.explicitWaits(driver, 20, getLocatorsFromJsonFile(id), "id");
        action.makeAction("id", getLocatorsFromJsonFile(id), true);
        log.getLog("Click on signin");
        return new NewUserHomePage(driver);

    }
}
