package stepdefinitions;

import java.util.Scanner;

import org.testng.Assert;
import io.cucumber.java.en.*;
import setup.Hooks;

public class Login_invalid_Step {


    // ===== Invalid Phone =====
    @Given("the user is on main page")
    public void the_user_is_on_main_page() {
        Hooks.loginPage.navigateToHomePage();
    }

    @When("the user clicks on login button")
    public void the_user_clicks_on_login_button() {
        Hooks.loginPage.clickLoginButton();
    }

    @When("the user enters invalid {string}")
    public void the_user_enters_invalid_phone_number(String phoneNumber) {
       Hooks.loginPage.enterInvalidMobileNumber(phoneNumber);
    }

    @Then("the continue button should be disabled")
    public void the_continue_button_should_be_disabled() {
        boolean disabled = Hooks.loginPage.continueButtonDisabled();
        Assert.assertTrue(disabled, "Expected Continue button to be disabled for invalid phone input");
    }

    // ===== Invalid OTP =====

    @Given("valid number is entered as {string}")
    public void valid_number_is_entered_as(String phoneNumber) {
    	Hooks.loginPage.clickLoginButton();
    	Hooks.loginPage.enterMobileNumber(phoneNumber);
    }

    @When("the user clicks continue button and enters an invalid OTP")
    public void the_user_clicks_continue_and_enters_invalid_otp() {
        Hooks.loginPage.clickContinueButton();
        
        // Take OTP from user input at runtime
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Invalid OTP: ");
        String invalidOtp = scanner.nextLine();

        Hooks.loginPage.enterOtp(invalidOtp);
    }

    @Then("the user sees a validation error")
    public void the_user_sees_validation_error() {
        Hooks.loginPage.validateOtpResult();
    }
}
