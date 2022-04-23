package pages;

import org.openqa.selenium.WebDriver;

public class CreateAnAccountPage extends PageBase{

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnTitle(String idElement) {
        log.getLog("Click on title method");
        timeToWait.explicitWaits(driver,20,idElement,"id");
        action.makeAction("id",idElement,true);
    }
    public void fillFirstName(String firstNameId,String fName){
        log.getLog("Click on fillFirstName method");
        action.makeAction("name",firstNameId,fName);
    }
    public void fillLastName(String lastNameId,String lName){
        log.getLog("Click on fillLastName method");
        action.makeAction("name",lastNameId,lName);
    }
    public void fillPassword(String passwordId,String password){
        log.getLog("Click on fillPassword method");
        action.makeAction("name",passwordId,password);
    }
    public void choseDateOfBirth(String dayId,String dayValue,String monthId,String monthValue,String yearId,String yearValue){
        action.makeAction(dayId,dayValue);
        action.makeAction(monthId,monthValue);
        action.makeAction(yearId,yearValue);
    }
    public void fillCompanyName(String companyNameId,String Company){
        log.getLog("Click on fillCompanyName method");
        action.makeAction("id",companyNameId,Company);
    }
    public void fillAddress(String addressId,String address){
        log.getLog("Click on fillAddress method");
        action.makeAction("id",addressId,address);
    }
    public void fillCity(String cityId,String city){
        log.getLog("Click on fillCity method");
        action.makeAction("id",cityId,city);
    }
    public void choseState(String stateId,String value){
        action.makeAction(stateId,value);
    }
    public void fillPostalCode(String postalCodeId,String postalCode){
        log.getLog("Click on fillPostalCode method");
        action.makeAction("id",postalCodeId,postalCode);
    }
    public void choseCountry(String countryId,String Country){
        action.makeAction(countryId,Country);
    }
    public void fillPhoneNumber(String phoneNumberId,String phone){
        log.getLog("Click on fillPhoneNumber method");
        action.makeAction("id",phoneNumberId,phone);
    }
    public void fillAddressAlias(String aliasId,String alias){
        log.getLog("Click on fillAddressAlias method");
        action.makeAction("id",aliasId,alias);
    }
    public void clickOnRigister(String rigisterId){
        log.getLog("Click on clickOnRigister method");
        action.makeAction("id",rigisterId,true);
    }
}
