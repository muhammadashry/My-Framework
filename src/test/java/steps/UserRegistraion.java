package steps;

import basetests.BaseTests;
import com.opencsv.exceptions.CsvException;
import helper.Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import pages.SignInPage;

import java.io.IOException;

public class UserRegistraion extends BaseTests {
    SignInPage signInPage;
    HomePage homePage;
    @Given("The user in the home page")
    public void the_user_in_the_home_page() {
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        signInPage= homePage.clickOnSighnInPage("//a[@class='login']");
    }
    @When("I click on Sighin link")
    public void i_click_on_sighin_link() throws IOException, ParseException {

    }
    @When("I enter my {string}")
    public void i_enter_my(String string) {

        signInPage.enterEmail("email_create",string);
    }

    @When("click On Create an account")
    public void click_on_create_an_account() throws IOException, ParseException {

    }
    @Then("I should go to the registration form")
    public void i_should_go_to_the_registration_form() {

    }

}
