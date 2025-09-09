package stepdefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.Hooks;

public class PersonalCare_Addtocart_invalid {

    @When("user filters by Brands")
    public void user_filters_by_brands() {
        // Scroll to the brand filter element before clicking
        WebElement brandElement = Hooks.personalcarePage.getBrandElement(); // create getter in Page class
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", brandElement);

        // Click after scrolling
        Hooks.personalcarePage.clickBrand();
    }
    
	@When("user selects Apollo pharmacy")
	public void user_selects_apollo_pharmacy() {
	    Hooks.personalcarePage.clickPharmacy();
	}
	@When("user clicks add in Apollo Pharmacy Premium Aqua Ble Handwash")
	public void user_clicks_add_in_apollo_pharmacy_premium_aqua_ble_handwash() {
	   Hooks.personalcarePage.clickBrandProduct();
	}
	@Then("user validates the skincare page")
	public void user_validates_the_skincare_page() {
	  Hooks.personalcarePage.validateSkincare();
	}
}
