package createanaccounttests;

import assertions.Assertions;
import basetests.BaseTests;
import com.opencsv.exceptions.CsvException;
import helper.Reader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.SignInPage;

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
    public void createValidAccount(String eMail, String fName,
                                   String lName, String companyName,
                                   String password, String address,
                                   String city, String postalCode,
                                   String phoneNumber, String aliasAddress) throws IOException, ParseException {
        SignInPage signUp = homePage.clickOnSighnInPage(getDataFromJsonFile("sgininlocator", 0));
        signUp.enterEmail(getDataFromJsonFile("emailtypelocator", 0), eMail);
        assertions.assertOnPage(driver, "Login - My Store", "you are not in a login page");
        CreateAnAccountPage createAnAccountPage = signUp.clickOnCreateAnAccount(getDataFromJsonFile("clickoncreatelocator", 0));
        createAnAccountPage.clickOnTitle(getDataFromJsonFile("clickontitlelocator", 0));
        createAnAccountPage.fillFirstName(getDataFromJsonFile("customerfirstnamelocator", 0), fName);
        createAnAccountPage.fillLastName(getDataFromJsonFile("customerlastnamelocator", 0), lName);
        createAnAccountPage.fillPassword(getDataFromJsonFile("passwordlocator", 0), password);
        createAnAccountPage.choseDateOfBirth(getDataFromJsonFile("birthdaydayslocator", 0), "5",
                getDataFromJsonFile("birthdaymonthlocator", 0), "5",
                getDataFromJsonFile("birthdayyearlocator", 0), "2020");
        createAnAccountPage.fillCompanyName(getDataFromJsonFile("companylocaotr", 0), companyName);
        createAnAccountPage.fillAddress(getDataFromJsonFile("addresslocator", 0), address);
        createAnAccountPage.fillCity(getDataFromJsonFile("citylocator", 0), city);
        createAnAccountPage.choseState(getDataFromJsonFile("statelocator", 0), "5");
        createAnAccountPage.fillPostalCode(getDataFromJsonFile("postalcodelocator", 0), postalCode);
        createAnAccountPage.choseCountry(getDataFromJsonFile("countrylocator", 0), "21");
        createAnAccountPage.fillPhoneNumber(getDataFromJsonFile("phonenumberlocator", 0), phoneNumber);
        createAnAccountPage.fillAddressAlias(getDataFromJsonFile("addressaliaslocator", 0), aliasAddress);
        createAnAccountPage.clickOnRigister(getDataFromJsonFile("registerlocator", 0));

    }

}
