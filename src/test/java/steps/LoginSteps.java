package steps;

import assertions.Assertions;
import basetests.BaseTests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import pages.HomePage;
import pages.SignInPage;

import java.io.IOException;

public class LoginSteps extends BaseTests {
    private HomePage page;
    private SignInPage sign;
    private Assertions assertOn;

    @Given("I am in the home page and I click on sign in")
    public void i_am_in_the_home_page_and_i_click_on_sign_in() throws IOException, ParseException {
        page = new HomePage(driver);
        sign = new SignInPage(driver);
        sign = page.clickOnSighnInPage("sgininlocator");
    }

    @When("I enter valid {string} , {string}")
    public void i_enter_valid(String string, String string2) throws IOException, ParseException, InterruptedException {
        sign.enterEmailToLogIn("loginemaillocator", string)
                .enterPasswordToLogIn("loginpasswordlocator", string2)
                .clickOnSignIn("signinlocator");
    }

    @Then("The user home page displayed successfully")
    public void the_user_home_page_displayed_successfully() {
        assertOn = new Assertions(driver);
        assertOn.assertOnPage(driver, "My account - My Store", "You are not in the user home page");
    }
}
