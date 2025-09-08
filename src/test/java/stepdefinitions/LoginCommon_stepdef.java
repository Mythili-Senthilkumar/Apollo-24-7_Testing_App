package stepdefinitions;

	import org.testng.Assert;
	import io.cucumber.java.en.Then;
	import setup.Hooks;


    public class LoginCommon_stepdef {

	    @Then("user validates that continue button disabled")
	    public void user_validates_that_continue_button_disabled() {
	        boolean isDisabled = Hooks.loginPage.continueButtonDisabled();
	        Assert.assertTrue(isDisabled, "Continue button should be disabled");
	    }
	}

