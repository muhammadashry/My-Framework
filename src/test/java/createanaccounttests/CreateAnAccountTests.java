package createanaccounttests;

import assertions.Assertions;
import basetests.BaseTests;
import com.opencsv.exceptions.CsvException;
import helper.Reader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateAnAccountTests extends BaseTests {
    private final Assertions assertions = new Assertions(driver);

    @DataProvider(name = "CSV")
    public Object[][] getData() throws IOException, CsvException {
        Reader usersData = new Reader(driver);
        return usersData.getAllUsersCSVData(properties.getProperty("csv.data.path"));
    }

    /* @DataProvider(name = "Excel")
     public Object[][] getDataExcel() throws IOException {
         Reader usersData = new Reader(driver);
         return usersData.getExcelData(properties.getProperty("excel.data.path"));
     }*/
    @Test(dataProvider = "CSV")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create New Account")
    public void createValidAccount(String eMail, String fName,
                                   String lName, String companyName,
                                   String password, String address,
                                   String city, String postalCode,
                                   String phoneNumber, String aliasAddress) throws IOException, ParseException {
        homePage.clickOnSighnInPage(getLocatorsFromJsonFile("sgininlocator"))
                .enterEmail(getLocatorsFromJsonFile("emailtypelocator"), eMail)
                .clickOnCreateAnAccount(getLocatorsFromJsonFile("clickoncreatelocator"))
                .clickOnTitle(getLocatorsFromJsonFile("clickontitlelocator"))
                .fillFirstName(getLocatorsFromJsonFile("customerfirstnamelocator"), fName)
                .fillLastName(getLocatorsFromJsonFile("customerlastnamelocator"), lName)
                .fillPassword(getLocatorsFromJsonFile("passwordlocator"), password)
                .choseDateOfBirth(getLocatorsFromJsonFile("birthdaydayslocator"), "5",
                            getLocatorsFromJsonFile("birthdaymonthlocator"), "5",
                            getLocatorsFromJsonFile("birthdayyearlocator"), "2020")
                .fillCompanyName(getLocatorsFromJsonFile("companylocaotr"), companyName)
                .fillAddress(getLocatorsFromJsonFile("addresslocator"), address)
                .fillCity(getLocatorsFromJsonFile("citylocator"), city)
                .choseState(getLocatorsFromJsonFile("statelocator"), "5")
                .fillPostalCode(getLocatorsFromJsonFile("postalcodelocator"), postalCode)
                .choseCountry(getLocatorsFromJsonFile("countrylocator"), "21")
                .fillPhoneNumber(getLocatorsFromJsonFile("phonenumberlocator"), phoneNumber)
                .fillAddressAlias(getLocatorsFromJsonFile("addressaliaslocator"), aliasAddress)
                .clickOnRigister(getLocatorsFromJsonFile("registerlocator"));
        assertions.assertOnPage(driver,"My account - My Store","The account does't created successfully");
    }

}
