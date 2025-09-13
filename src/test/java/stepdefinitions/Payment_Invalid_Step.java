package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Payment_Invalid_Step {


@Given("the user clicks on procced in cart section")
public void the_user_clicks_on_procced_in_cart_section() {
	Hooks.paymentPage.clickProceed();
}
@When("the user selects skip savings")
public void the_user_selects_skip_savings() {
   Hooks.paymentPage.skipSavings();
}
@When("the user clicks on proceed for payment")
public void the_user_clicks_on_proceed_for_payment() {
	Hooks.paymentPage.firstProceed();
	   Hooks.paymentPage.deliveryType();
}
@When("the user again clicks procced in delivery section")
public void the_user_again_clicks_procced_in_delivery_section() {
	 Hooks.paymentPage.secondProceed();
}
@When("the user verifies the payment page with multiple payment options")
public void the_user_verifies_the_payment_page_with_multiple_payment_options() {
	 Hooks.paymentPage.validatePaymentPage();
}
@Then("the user validates that pay later option is not clicable")
public void the_user_validates_that_pay_later_option_is_not_clicable() {
   Hooks.paymentPage.payLater();
}

}
