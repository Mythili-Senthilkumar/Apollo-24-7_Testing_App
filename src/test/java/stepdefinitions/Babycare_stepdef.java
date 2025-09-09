package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Babycare_stepdef {


@Given("user clicks on baby care")
public void user_clicks_on_baby_care() {
    Hooks.babycarePage.babyCareClick();
}
@When("user click on baby skin")
public void user_click_on_baby_skin() {
  Hooks.babycarePage.babySkinClick();
}
@When("user sort the product by better discount")
public void user_sort_the_product_by_better_discount() {
    Hooks.babycarePage.betterdiscountClick();
}
@When("user clicks Himalaya Baby pH {double} Cream with Pure Cow Ghee, {int} ml")
public void user_clicks_himalaya_baby_p_h_cream_with_pure_cow_ghee_ml(Double double1, Integer int1) {
    Hooks.babycarePage.himalayaproductClick();
}
@When("user changes the pack")
public void user_changes_the_pack() {
    Hooks.babycarePage.packChangeClick();
}
@Then("user clicks add to cart and validates the page")
public void user_clicks_add_to_cart() {
    Hooks.babycarePage.productAddClick();
    Hooks.babycarePage.viewcartClick();
    Hooks.babycarePage.validateBabycarePage();
    
 }
}
