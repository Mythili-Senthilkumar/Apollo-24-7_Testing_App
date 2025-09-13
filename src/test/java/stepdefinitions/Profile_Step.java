package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Profile_Step {


@Given("the user clicks profile")
public void the_user_clicks_profile() {
   Hooks.profilePage.profile();
}
@When("the user cliks on My orders")
public void the_user_cliks_on_my_orders() {
	Hooks.profilePage.myorderClick();
	
}
@When("the user can see payment cancelled products and clicks order details")
public void the_user_can_see_payment_cancelled_products_and_clicks_order_details() {
   Hooks.profilePage.myOrder();
   Hooks.profilePage.orderDetails();
}
@When("the user can see the order details and clicks reorder button")
public void the_user_can_see_the_order_details_and_clicks_reorder_button() {
    Hooks.profilePage.reOrder();
}
@Then("the user validates that the page back to cart")
public void the_user_validates_that_the_page_back_to_cart() {
   Hooks.profilePage.cartPage();
}
}
