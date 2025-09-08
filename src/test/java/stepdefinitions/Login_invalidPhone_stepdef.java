package stepdefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import setup.Hooks;

public class Login_invalidPhone_stepdef {

    @Given("the user is on main page")
    public void the_user_is_on_main_page() {
        // Reuse existing browser, no new get()
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.apollo247.com/");
    }

    @When("the user clicks on login button")
    public void the_user_clicks_on_login_button() {
        Hooks.loginPage.clickLoginButton();
    }

    @When("the user enters invalid {string}")
    public void the_user_enters_invalid(String number) {
        Hooks.loginPage.enterInvalidMobileNumber(number);
    }
}
