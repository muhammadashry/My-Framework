package purchaseproduct;

import assertions.Assertions;
import basetests.BaseTests;
import helper.Reader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.NewUserHomePage;

import java.io.IOException;

public class PurchaseProduct extends BaseTests {

    private Assertions assertions = new Assertions(driver);

    @DataProvider(name = "Excel")
     public Object[][] getDataExcel() throws IOException {
         Reader usersData = new Reader(driver);
         return usersData.getExcelData(properties.getProperty("excel.data.path"));
     }
    @Test(dataProvider = "Excel")
    public void purchaseProduct(String email,String password) throws IOException, ParseException, InterruptedException {
       NewUserHomePage newUserPage = homePage.clickOnSighnInPage(getLocatorsFromJsonFile("sgininlocator"))
                .enterEmailToLogIn(getLocatorsFromJsonFile("loginemaillocator"),email)
                .enterPasswordToLogIn(getLocatorsFromJsonFile("loginpasswordlocator"),password)
                .clickOnSignIn(getLocatorsFromJsonFile("signinlocator"));
       assertions.assertOnPage(driver,"My account - My Store","Please check your data");
        newUserPage.clickOnBlousesCategory(getLocatorsFromJsonFile("blouseslocator"),getLocatorsFromJsonFile("hoveronwomen"));
    }
}
