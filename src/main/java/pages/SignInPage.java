package pages;

import org.openqa.selenium.WebDriver;

public class SignInPage extends PageBase {

    public SignInPage(WebDriver driver){
        super(driver);
    }

    public SignInPage enterEmailToCreateNewAccount(String id, String email) {
        timeToWait.explicitWaits(driver,20,id,"id");
        action.makeAction("id",id,email);
        log.getLog("Click on SignInPage method");
        return this;
    }
    public SignInPage enterEmailToLogIn(String id, String email) {
        timeToWait.explicitWaits(driver,20,id,"id");
        action.makeAction("id",id,email);
        log.getLog("Enter your Email");
        return this;
    }
    public SignInPage enterPasswordToLogIn(String id, String password) {
        action.makeAction("id",id,password);
        log.getLog("Enter your Email");
        return this;
    }
    public CreateAnAccountPage clickOnCreateAnAccount(String id){
        timeToWait.explicitWaits(driver,10,id,"id");
        action.makeAction("id",id,true);
        log.getLog("Click on clickOnCreateAnAccount");
        return new CreateAnAccountPage(driver);

    }
    public NewUserHomePage clickOnSignIn(String id){
        timeToWait.explicitWaits(driver,10,id,"id");
        action.makeAction("id",id,true);
        log.getLog("Click on signin");
        return new NewUserHomePage(driver);

    }
}
