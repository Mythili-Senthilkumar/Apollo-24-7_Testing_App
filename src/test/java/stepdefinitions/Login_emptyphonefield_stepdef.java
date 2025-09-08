package stepdefinitions;

import io.cucumber.java.en.When;
import setup.Hooks;

public class Login_emptyphonefield_stepdef {

    @When("phone number field is empty")
    public void phone_number_field_is_empty() {
        Hooks.loginPage.emptyMobileNumberField();
    }
}
