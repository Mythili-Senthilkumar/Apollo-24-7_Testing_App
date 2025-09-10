package stepdefinitions;

import io.cucumber.java.en.Then;
import setup.Hooks;

public class CartPage_remove_stepdef {

	@Then("the user validates that dustbin icon clickable")
	public void the_user_validates_that_dustbin_icon_clickable() {
		 Hooks.cartPage.clickDeleteIcon();
	}  
}

