package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Address_invalid_flatno_Step {


@Given("user clicks add address in change")
public void user_clicks_add_address_in_change() {
    Hooks.addressPage.textField();
    Hooks.addressPage.suggLocation();
    Hooks.addressPage.validateEnterDetailsPage();
}
@When("user enter single character flat number")
public void user_enter_single_character_flat_number() {
   Hooks.addressPage.flatNo();
   Hooks.addressPage.saveNextBtn();
}
@Then("user validates that minimum two characters required")
public void user_validates_that_minimum_two_characters_required() {
    Hooks.addressPage.reqMsg();
}
}
