package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Personalcare_stepdef {

    @Given("user clicks on personal care")
    public void user_clicks_on_personal_care() {
        Hooks.personalcarePage.clickpersonalCare();
    }
    
    @When("user clicks on skin care")
    public void user_clicks_on_skin_care() {
        Hooks.personalcarePage.skinCare();
    }
    
    @When("user selects apollo life aloe vera skin care gel product")
    public void user_selects_apollo_life_aloe_vera_skin_care_gel_product() {
        Hooks.personalcarePage.productClick();
    }
    
    @When("user clicks add to cart button")
    public void user_clicks_add_to_cart_button() {
        Hooks.personalcarePage.addClick();;
        Hooks.personalcarePage.viewCartclick();
    }
    
    @Then("user validates the cart page")
    public void user_validates_the_cart_page() {
        Hooks.personalcarePage.validateCart();
    }
}
