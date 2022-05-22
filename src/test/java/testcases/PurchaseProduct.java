package testcases;

import basetests.BaseTests;
import helper.Assertions;
import helper.Reader;
import helper.RetryFailedTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.NewUserHomePage;

import java.io.IOException;

public class PurchaseProduct extends BaseTests {

    private Assertions assertions = new Assertions(driver);

    @DataProvider(name = "Excel")
    public Object[][] getDataExcel() throws IOException {
        Reader usersData = new Reader();
        return usersData.getExcelData(properties.getProperty("excel.data.path"));
    }

    @Test(dataProvider = "Excel", retryAnalyzer = RetryFailedTests.class)
    public void purchaseProduct(String email, String password) throws Exception {
        NewUserHomePage newUserPage = homePage.clickOnSighnInPage("sgininlocator")
                .enterEmailToLogIn("loginemaillocator", email)
                .enterPasswordToLogIn("loginpasswordlocator", password)
                .clickOnSignIn("signinlocator");
        assertions.assertOnPage(driver, "My account - My Store", "Please check your data");
        newUserPage.clickOnBlousesCategory("blouseslocator", "hoveronwomen");
    }
}
