package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Cartpage_quantity_stepdef {

	@Given("user moves to cart page")
	public void user_moves_to_cart_page() {
	   Hooks.cartPage.cartIcon();
	   Hooks.cartPage.validateCartPage();
	}
	@When("user clicks quanity dropdown")
	public void user_clicks_quanity_dropdown() {
	   Hooks.cartPage.changeQuantity();
	}
	@Then("choose any quantity and validates the page")
	public void choose_any_quantity_and_validates_the_page() {
	   Hooks.cartPage.validateUpdatedQuantity();
	}

}
