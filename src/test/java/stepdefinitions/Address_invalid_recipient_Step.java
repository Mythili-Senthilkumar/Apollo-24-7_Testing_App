package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Address_invalid_recipient_Step {

	@Given("user is on address details page")
	public void user_is_on_address_details_page() {
	    Hooks.addressPage.flatNumber();
	    Hooks.addressPage.savenext();
	}
	@When("user enter invalid name in the textfield")
	public void user_enter_invalid_name_in_the_textfield() {
	  Hooks.addressPage.textArea();
	  Hooks.addressPage.recipientName();
	}
	@Then("user can save the address")
	public void user_can_save_the_address() {
		Hooks.addressPage.savebtn();
	    Hooks.addressPage.validateCartPage();
	   
	}

}
