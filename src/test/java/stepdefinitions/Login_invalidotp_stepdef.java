package stepdefinitions;

import java.util.Scanner;

import io.cucumber.java.en.Then;
import pages.LoginPage;
import setup.Hooks;

public class Login_invalidotp_stepdef {

    LoginPage loginPage;

    public Login_invalidotp_stepdef() {
        this.loginPage = new LoginPage(Hooks.driver, Hooks.extTest);
    }

    @Then("the user enters and validates wrong otp")
    public void the_user_validates_wrong_otp() {
    	
    	 Scanner scanner=new Scanner(System.in);
         System.out.println("Enter OTP: ");
         String otp=scanner.nextLine();
         
        loginPage.enterOtp(otp);  
        loginPage.validateOtpResult();
    }
}
