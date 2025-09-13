package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class PersonalCare_invalid_Step {


	@When("user clicks add in Apollo Pharmacy Premium Aqua Ble Handwash")
	public void user_clicks_add_in_apollo_pharmacy_premium_aqua_ble_handwash() {
		
		   Hooks.personalcarePage.brandProduct();
	}
	@Then("user validates the skincare page")
	public void user_validates_the_skincare_page() {
	  Hooks.personalcarePage.checkAddButtonDisabled();
	}
}
