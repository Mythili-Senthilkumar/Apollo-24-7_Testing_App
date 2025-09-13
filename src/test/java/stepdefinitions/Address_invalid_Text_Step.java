package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Address_invalid_Text_Step {

	@Given("user clicks on change")
	public void user_clicks_on_change() {
	    Hooks.addressPage.changeClick();
	}
	@When("user validates that the new sidebar opens")
	public void user_validates_that_the_new_sidebar_opens() {
	   Hooks.addressPage.deliverTo();
	}
	@When("user clicks on add button")
	public void user_clicks_on_add_button() {
	   Hooks.addressPage.newaddressClick();
	}
	@Then("user types the address and validates that no results found")
	public void user_types_the_address_and_validates_that_no_results_found() {
		Hooks.addressPage.textArea();
	    Hooks.addressPage.validateNoResult();
	  
	}

}
