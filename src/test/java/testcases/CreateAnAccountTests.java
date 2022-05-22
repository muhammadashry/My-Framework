package testcases;

import basetests.BaseTests;
import com.epam.healenium.annotation.DisableHealing;
import com.opencsv.exceptions.CsvException;
import helper.Assertions;
import helper.Reader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateAnAccountTests extends BaseTests {
    private final Assertions assertions = new Assertions(driver);

    @DataProvider(name = "CSV")
    public Object[][] getData() throws IOException, CsvException {
        Reader usersData = new Reader();
        return usersData.getAllUsersCSVData(properties.getProperty("csv.data.path"));
    }

    @Test(dataProvider = "CSV")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create New Account")
    @DisableHealing
    public void createValidAccount(String eMail, String fName,
                                   String lName, String companyName,
                                   String password, String address,
                                   String city, String postalCode,
                                   String phoneNumber, String aliasAddress) throws Exception {
        homePage.clickOnSighnInPage("sgininlocator")
                .enterEmailToCreateNewAccount("emailtypelocator", eMail)
                .clickOnCreateAnAccount("clickoncreatelocator")
                .clickOnTitle("clickontitlelocator")
                .fillFirstName("customerfirstnamelocator", fName)
                .fillLastName("customerlastnamelocator", lName)
                .fillPassword("passwordlocator", password)
                .choseDateOfBirth("birthdaydayslocator", "5",
                        "birthdaymonthlocator", "5",
                        "birthdayyearlocator", "2020")
                .fillCompanyName("companylocaotr", companyName)
                .fillAddress("addresslocator", address)
                .fillCity("citylocator", city)
                .choseState("statelocator", "5")
                .fillPostalCode("postalcodelocator", postalCode)
                .choseCountry("countrylocator", "21")
                .fillPhoneNumber("phonenumberlocator", phoneNumber)
                .fillAddressAlias("addressaliaslocator", aliasAddress)
                .clickOnRigister("registerlocator");
        assertions.assertOnPage(driver, "My account - My Store", "The account does't created successfully");
    }

}
