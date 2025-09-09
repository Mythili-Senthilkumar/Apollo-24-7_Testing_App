package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class LoginCommon_stepdef {

    @Given("the user is on main page")
    public void the_user_is_on_main_page() {
        // Reuse driver already initialized in Hooks
        Hooks.driver.get("https://www.apollo247.com/");
    }

    @When("the user clicks on login button")
    public void the_user_clicks_on_login_button() {
        Hooks.loginPage.clickLoginButton();
    }

    @Then("user validates that continue button disabled")
    public void user_validates_that_continue_button_disabled() {
        boolean isDisabled = Hooks.loginPage.continueButtonDisabled();
        if (!isDisabled) {
            throw new AssertionError("Continue button should be disabled");
        }
    }
}
