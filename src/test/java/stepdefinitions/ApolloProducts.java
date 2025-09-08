package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import setup.Hooks;

public class ApolloProducts {

	@Given("user clicks apollo products")
	public void user_clicks_apollo_products() {
	    Hooks.apolloProductsPage.apolloProducts();
	    }
	
	@Then("user validates the apollo products page")
	public void user_validates_the_apollo_products_page() {
	   Hooks.apolloProductsPage.validateApolloProducts();
	}
}
