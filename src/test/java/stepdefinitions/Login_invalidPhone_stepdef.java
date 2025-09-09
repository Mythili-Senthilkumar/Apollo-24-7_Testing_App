package stepdefinitions;

import io.cucumber.java.en.When;
import pages.LoginPage;
import setup.Hooks;

public class Login_invalidPhone_stepdef {

    LoginPage loginPage;

    public Login_invalidPhone_stepdef() {
        loginPage = new LoginPage(Hooks.driver, Hooks.extTest);
    }

    @When("the user enters invalid {string}")
    public void the_user_enters_invalid_phone_number(String phoneNumber) {
        loginPage.enterInvalidMobileNumber(phoneNumber);
    }
}
