package pages;

import helper.Actions;
import helper.Logs;
import helper.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage extends PageBase{

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnTitle(String idElement) {
        log.getLog("Click on title method");
        timeToWait.explicitWaits(driver,20,idElement,"id");
        makeAction.makeAction("id",idElement,true);
    }
    public void fillFirstName(String firstNameId,String fName){
        log.getLog("Click on fillFirstName method");
        makeAction.makeAction("name",firstNameId,fName);
    }
    public void fillLastName(String lastNameId,String lName){
        log.getLog("Click on fillLastName method");
        makeAction.makeAction("name",lastNameId,lName);
    }
    public void fillPassword(String passwordId,String password){
        log.getLog("Click on fillPassword method");
        makeAction.makeAction("name",passwordId,password);
    }
    public void choseDateOfBirth(String dayId,String dayValue,String monthId,String monthValue,String yearId,String yearValue){
        makeAction.makeAction(dayId,dayValue);
        makeAction.makeAction(monthId,monthValue);
        makeAction.makeAction(yearId,yearValue);
    }
    public void fillCompanyName(String companyNameId,String Company){
        log.getLog("Click on fillCompanyName method");
        makeAction.makeAction("id",companyNameId,Company);
    }
    public void fillAddress(String addressId,String address){
        log.getLog("Click on fillAddress method");
        makeAction.makeAction("id",addressId,address);
    }
    public void fillCity(String cityId,String city){
        log.getLog("Click on fillCity method");
        makeAction.makeAction("id",cityId,city);
    }
    public void choseState(String stateId,String value){
        makeAction.makeAction(stateId,value);
    }
    public void fillPostalCode(String postalCodeId,String postalCode){
        log.getLog("Click on fillPostalCode method");
        makeAction.makeAction("id",postalCodeId,postalCode);
    }
    public void choseCountry(String countryId,String Country){
        makeAction.makeAction(countryId,Country);
    }
    public void fillPhoneNumber(String phoneNumberId,String phone){
        log.getLog("Click on fillPhoneNumber method");
        makeAction.makeAction("id",phoneNumberId,phone);
    }
    public void fillAddressAlias(String aliasId,String alias){
        log.getLog("Click on fillAddressAlias method");
        makeAction.makeAction("id",aliasId,alias);
    }
    public void clickOnRigister(String rigisterId){
        log.getLog("Click on clickOnRigister method");
        makeAction.makeAction("id",rigisterId,true);
    }
}
