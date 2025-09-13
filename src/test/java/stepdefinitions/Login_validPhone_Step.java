package stepdefinitions;

import java.util.Scanner;
import io.cucumber.java.en.*;
import setup.Hooks;

public class Login_validPhone_Step {

    @When("the user enters valid {string}")
    public void the_user_enters_valid(String number) {
        // Reuse common login button click
        Hooks.loginPage.clickLoginButton();
        Hooks.loginPage.enterMobileNumber(number);
    }

    @When("the user clicks continue button")
    public void the_user_clicks_continue_button() {
        Hooks.loginPage.clickContinueButton();
    }
    @When("the user enters the correct OTP")
    public void the_user_enters_the_correct_otp() {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Enter OTP (you have 45 sec): ");

        String otp = "";
        long startTime = System.currentTimeMillis();

        // Wait up to 45 sec for OTP input
        while ((System.currentTimeMillis() - startTime) < 45000 && otp.isEmpty()) {
            try {
                if (System.in.available() > 0) {  // User typed something
                    otp = scanner.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // If no OTP entered within 45 sec, click resend
        if (otp.isEmpty()) {
            System.out.println("OTP not entered. Clicking Resend OTP...");
            Hooks.loginPage.resendOtp(otp);
            System.out.print("Enter OTP after resend: ");
            otp = scanner.nextLine();
        }
        Hooks.loginPage.enterOtp(otp);
        Hooks.loginPage.validateOtpResult();
    }
    @Then("the user should see that the profile created")
    public void the_user_should_see_that_the_profile_created() {
    	Hooks.loginPage.validateProfilePage();
    }
}
