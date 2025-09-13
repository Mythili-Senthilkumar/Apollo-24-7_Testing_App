package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Address_Step {


@Given("user clicks on change in my cart")
public void user_clicks_on_change_in_my_cart() {
    Hooks.addressPage.changeClick();
}
@When("user see the deliverto and click add new address")
public void user_see_the_deliverto_and_click_add_new_address() {
   Hooks.addressPage.newaddressClick();
}
@When("user selects the address by typing in the textarea")
public void user_selects_the_address_by_typing_in_the_textarea() {
   Hooks.addressPage.textArea();
}
@When("user validates the enter address details page")
public void user_validates_the_enter_address_details_page() {
    Hooks.addressPage.suggestedLocation();
    Hooks.addressPage.validateEnterDetails();
}
@When("user enters house number and and click save and next")
public void user_enters_house_number_and_and_click_save_and_next() {
   Hooks.addressPage.flatNumber();
   Hooks.addressPage.savenext();
}
@When("user choose radio button and choose save the address as")
public void user_choose_radio_button_and_choose_save_the_address_as() {
    Hooks.addressPage.radioBtn();
    Hooks.addressPage.otherClick();
}
@When("user enters recipient and click save address")
public void user_enters_recipient_and_click_save_address() {
    Hooks.addressPage.recipient();
    Hooks.addressPage.savebtn();
}
@Then("user validates after clicking the page returned to cart page")
public void user_validates_after_clicking_the_page_returned_to_cart_page() {
  Hooks.addressPage.validateCartPage();
}

}
