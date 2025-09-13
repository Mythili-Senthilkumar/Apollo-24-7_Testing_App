package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Payment_Step {

@Given("the user clicks proceed")
public void the_user_clicks_proceed() {
   Hooks.paymentPage.clickProceed();
   Hooks.paymentPage.addressProceed();
}
@When("the user clicks add plan")
public void the_user_clicks_add_plan() {
    Hooks.paymentPage.clickAddPlan();
}
@When("the user validates benefits applied in cart section")
public void the_user_validates_benefits_applied_in_cart_section() {
    Hooks.paymentPage.validateBenefitsApplied();
}
@When("the user clicks proceed button for payment and validates delivery type")
public void the_user_clicks_proceed_button_for_payment_and_validates_delivery_type() {
   Hooks.paymentPage.firstProceed();
   Hooks.paymentPage.deliveryType();
}

@When("the user clicks proceed in delivery type and validates payment page")
public void the_user_clicks_proceed_in_delivery_type_and_validates_payment_page() {
   Hooks.paymentPage.secondProceed();
   Hooks.paymentPage.validatePaymentPage();
}

@When("the user clicks on show QR code")
public void the_user_clicks_on_show_qr_code() {
    Hooks.paymentPage.qrCodePayment();
}

@Then("the user clicks on cancel for canceling payment")
public void the_user_clicks_on_cancel_for_canceling_payment() {
    Hooks.paymentPage.cancelQR();
}

}
