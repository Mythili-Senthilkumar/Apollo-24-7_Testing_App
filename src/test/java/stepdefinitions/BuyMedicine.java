package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import setup.Hooks;

public class BuyMedicine {

	@Given("user clicks buy medicines")
	public void user_clicks_buy_medicines() {
	    Hooks.buymedicinePage.buyMedicine();
	}
	@Then("user validates the page is in buy medicine page")
	public void user_validates_the_page_is_in_buy_medicine_page() {
	   Hooks.buymedicinePage.validateBuyMedicine(); 
	}

}
