package pages;

import org.openqa.selenium.WebDriver;

public class CreateAnAccountPage extends PageBase{

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }
    public CreateAnAccountPage clickOnTitle(String idElement) {
        log.getLog("Click on title method");
        timeToWait.explicitWaits(driver,20,idElement,"id");
        action.makeAction("id",idElement,true);
        return  this;
    }
    public CreateAnAccountPage fillFirstName(String firstNameId,String fName){
        log.getLog("Click on fillFirstName method");
        action.makeAction("name",firstNameId,fName);
        return  this;
    }
    public CreateAnAccountPage fillLastName(String lastNameId,String lName){
        log.getLog("Click on fillLastName method");
        action.makeAction("name",lastNameId,lName);
        return  this;
    }
    public CreateAnAccountPage fillPassword(String passwordId,String password){
        log.getLog("Click on fillPassword method");
        action.makeAction("name",passwordId,password);
        return  this;
    }
    public CreateAnAccountPage choseDateOfBirth(String dayId,String dayValue,String monthId,String monthValue,String yearId,String yearValue){
        action.makeAction(dayId,dayValue);
        action.makeAction(monthId,monthValue);
        action.makeAction(yearId,yearValue);
        return  this;
    }
    public CreateAnAccountPage fillCompanyName(String companyNameId,String Company){
        log.getLog("Click on fillCompanyName method");
        action.makeAction("id",companyNameId,Company);
        return  this;
    }
    public CreateAnAccountPage fillAddress(String addressId,String address){
        log.getLog("Click on fillAddress method");
        action.makeAction("id",addressId,address);
        return  this;
    }
    public CreateAnAccountPage fillCity(String cityId,String city){
        log.getLog("Click on fillCity method");
        action.makeAction("id",cityId,city);
        return  this;
    }
    public CreateAnAccountPage choseState(String stateId,String value){
        action.makeAction(stateId,value);
        return  this;
    }
    public CreateAnAccountPage fillPostalCode(String postalCodeId,String postalCode){
        log.getLog("Click on fillPostalCode method");
        action.makeAction("id",postalCodeId,postalCode);
        return  this;
    }
    public CreateAnAccountPage choseCountry(String countryId,String Country){
        action.makeAction(countryId,Country);
        return  this;
    }
    public CreateAnAccountPage fillPhoneNumber(String phoneNumberId,String phone){
        log.getLog("Click on fillPhoneNumber method");
        action.makeAction("id",phoneNumberId,phone);
        return  this;
    }
    public CreateAnAccountPage fillAddressAlias(String aliasId,String alias){
        log.getLog("Click on fillAddressAlias method");
        action.makeAction("id",aliasId,alias);
        return  this;
    }
    public CreateAnAccountPage clickOnRigister(String rigisterId){
        log.getLog("Click on clickOnRigister method");
        action.makeAction("id",rigisterId,true);
        return  this;
    }
}
