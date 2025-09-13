package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Cart_Step {

@Given("user moves to cart page")
public void user_moves_to_cart_page() {
   Hooks.cartPage.validateCartPage();
}
@When("user clicks quanity dropdown and choose quantity")
public void user_clicks_quanity_dropdown_and_choose_quantity() {
   Hooks.cartPage.dropdownClick();
   Hooks.cartPage.quantityClick();
}

@Then("user clicks change in top")
public void user_clicks_change_in_top() {
    Hooks.addressPage.changeClick();
}



}
