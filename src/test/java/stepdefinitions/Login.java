package stepdefinitions;

import java.util.Scanner;

import org.testng.Assert;
import io.cucumber.java.en.*;
import setup.Hooks;

public class Login {

    @Given("the user is on main page")
    public void the_user_is_on_main_page() {
        // Reuse existing browser, no new get()
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.apollo247.com/");
    }

    @When("the user clicks on login button")
    public void the_user_clicks_on_login_button() {
        Hooks.loginPage.clickloginbutton();
    }

    @When("the user enters valid {string}")
    public void the_user_enters_valid(String number) {
        Hooks.loginPage.entermobilenumber(number);
    }

    @When("the user clicks continue button")
    public void the_user_clicks_continue_button() {
        Hooks.loginPage.clickcontinuebutton();
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
