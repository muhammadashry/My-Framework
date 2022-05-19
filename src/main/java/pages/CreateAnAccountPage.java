package pages;

import com.epam.healenium.SelfHealingDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CreateAnAccountPage extends PageBase {

    public CreateAnAccountPage(WebDriver driver) throws Exception {
        super(driver);
    }

    public CreateAnAccountPage clickOnTitle(String idElement) throws IOException, ParseException {
        log.getLog("Click on title method");
        timeToWait.explicitWaits(driver, 20, getLocatorsFromJsonFile(idElement), "id");
        action.makeAction("id", getLocatorsFromJsonFile(idElement), true);
        return this;
    }

    public CreateAnAccountPage fillFirstName(String firstNameId, String fName) throws IOException, ParseException {
        log.getLog("Click on fillFirstName method");
        action.makeAction("name", getLocatorsFromJsonFile(firstNameId), fName);
        return this;
    }

    public CreateAnAccountPage fillLastName(String lastNameId, String lName) throws IOException, ParseException {
        log.getLog("Click on fillLastName method");
        action.makeAction("name", getLocatorsFromJsonFile(lastNameId), lName);
        return this;
    }

    public CreateAnAccountPage fillPassword(String passwordId, String password) throws IOException, ParseException {
        log.getLog("Click on fillPassword method");
        action.makeAction("name", getLocatorsFromJsonFile(passwordId), password);
        return this;
    }

    public CreateAnAccountPage choseDateOfBirth(String dayId, String dayValue, String monthId, String monthValue, String yearId, String yearValue) throws IOException, ParseException {
        action.makeAction(getLocatorsFromJsonFile(dayId), dayValue);
        action.makeAction(getLocatorsFromJsonFile(monthId), monthValue);
        action.makeAction(getLocatorsFromJsonFile(yearId), yearValue);
        return this;
    }

    public CreateAnAccountPage fillCompanyName(String companyNameId, String Company) throws IOException, ParseException {
        log.getLog("Click on fillCompanyName method");
        action.makeAction("id", getLocatorsFromJsonFile(companyNameId), Company);
        return this;
    }

    public CreateAnAccountPage fillAddress(String addressId, String address) throws IOException, ParseException {
        log.getLog("Click on fillAddress method");
        action.makeAction("id", getLocatorsFromJsonFile(addressId), address);
        return this;
    }

    public CreateAnAccountPage fillCity(String cityId, String city) throws IOException, ParseException {
        log.getLog("Click on fillCity method");
        action.makeAction("id", getLocatorsFromJsonFile(cityId), city);
        return this;
    }

    public CreateAnAccountPage choseState(String stateId, String value) throws IOException, ParseException {
        action.makeAction(getLocatorsFromJsonFile(stateId), value);
        return this;
    }

    public CreateAnAccountPage fillPostalCode(String postalCodeId, String postalCode) throws IOException, ParseException {
        log.getLog("Click on fillPostalCode method");
        action.makeAction("id", getLocatorsFromJsonFile(postalCodeId), postalCode);
        return this;
    }

    public CreateAnAccountPage choseCountry(String countryId, String Country) throws IOException, ParseException {
        action.makeAction(getLocatorsFromJsonFile(countryId), Country);
        return this;
    }

    public CreateAnAccountPage fillPhoneNumber(String phoneNumberId, String phone) throws IOException, ParseException {
        log.getLog("Click on fillPhoneNumber method");
        action.makeAction("id", getLocatorsFromJsonFile(phoneNumberId), phone);
        return this;
    }

    public CreateAnAccountPage fillAddressAlias(String aliasId, String alias) throws IOException, ParseException {
        log.getLog("Click on fillAddressAlias method");
        action.makeAction("id", getLocatorsFromJsonFile(aliasId), alias);
        return this;
    }

    public CreateAnAccountPage clickOnRigister(String rigisterId) throws IOException, ParseException {
        log.getLog("Click on clickOnRigister method");
        action.makeAction("id", getLocatorsFromJsonFile(rigisterId), true);
        timeToWait.explicitWaits(driver,15,"//h1[@class='page-heading']","xpath");
        return this;
    }
}
