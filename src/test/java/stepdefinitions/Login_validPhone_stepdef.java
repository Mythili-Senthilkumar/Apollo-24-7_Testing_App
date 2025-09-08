package stepdefinitions;

import java.util.Scanner;

import io.cucumber.java.en.*;
import setup.Hooks;

public class Login_validPhone_stepdef {

 
    @When("the user enters valid {string}")
    public void the_user_enters_valid(String number) {
    	Hooks.loginPage.clickLoginButton();
        Hooks.loginPage.enterMobileNumber(number);
    }

    @When("the user clicks continue button")
    public void the_user_clicks_continue_button() {
        Hooks.loginPage.clickContinueButton();
    }

    @When("the user enters the otp")
    public void the_user_enters_the_otp() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter OTP: ");
        String otp=scanner.nextLine();
   
        Hooks.loginPage.enterOtp(otp);
        Hooks.loginPage.validateOtpResult();
        	
    }
    
    @Then("the user validates profile created")
    public void the_user_validates_profile_created() {
       Hooks.loginPage.validateProfilePage();
  }
    
}
