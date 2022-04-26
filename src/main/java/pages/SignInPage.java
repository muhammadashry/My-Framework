package pages;

import org.openqa.selenium.WebDriver;

public class SignInPage extends PageBase {

    public SignInPage(WebDriver driver){
        super(driver);
    }

    public SignInPage enterEmail(String id,String email) {
        timeToWait.explicitWaits(driver,20,id,"id");
        action.makeAction("id",id,email);
        log.getLog("Click on SignInPage method");
        return this;
    }
    public CreateAnAccountPage clickOnCreateAnAccount(String id){
        timeToWait.explicitWaits(driver,10,id,"id");
        action.makeAction("id",id,true);
        log.getLog("Click on clickOnCreateAnAccount method");
        return new CreateAnAccountPage(driver);

    }
}
