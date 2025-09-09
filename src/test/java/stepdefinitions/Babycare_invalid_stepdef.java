package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Babycare_invalid_stepdef {

	@When("user click on baby foods")
	public void user_click_on_baby_foods() {
	   Hooks.babycarePage.babyFoodClick();
	}
	@When("user clicks baby cereals")
	public void user_clicks_baby_cereals() {
	   Hooks.babycarePage.babyCerealClick();
	}
	@When("user sort with low to high in dropdown")
	public void user_sort_with_low_to_high_in_dropdown() {
	   Hooks.babycarePage.lowtohighClick();
	}
	@Then("user selects the product and validate the page")
	public void user_selects_the_product_and_validate_the_page() {
	   Hooks.babycarePage.babyProductClick();
	   Hooks.babycarePage.validateBabyPage();
	}
}
