package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import setup.Hooks;

public class Address_invalid_option_Step {

	@Given("user is on enter address details page")
	public void user_is_on_enter_address_details_page() {
		 Hooks.addressPage.flatNumber();
		    Hooks.addressPage.savenext();
	}
	@Then("user cannot select any option it shows an information that select any one")
	public void user_cannot_select_any_option_it_shows_an_information_that_select_any_one() {
		Hooks.addressPage.recipient();
		Hooks.addressPage.savebtn();
	}
}
