package pages;

import org.openqa.selenium.WebDriver;

public class SignInPage extends PageBase {

    public SignInPage(WebDriver driver){
        super(driver);
    }

    public void enterEmail(String id,String email) {
        timeToWait.explicitWaits(driver,20,id,"id");
        makeAction.makeAction("id",id,email);
        log.getLog("Click on SignInPage method");

    }
    public CreateAnAccountPage clickOnCreateAnAccount(String id){
        timeToWait.explicitWaits(driver,10,id,"id");
        makeAction.makeAction("id",id,true);
        log.getLog("Click on clickOnCreateAnAccount method");
        return new CreateAnAccountPage(driver);

    }
}
