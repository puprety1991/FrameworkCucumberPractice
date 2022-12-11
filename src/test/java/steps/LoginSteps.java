package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

import static utils.CommonMethods.openBrowserAndLaunchApplication;


public class LoginSteps extends CommonMethods {
    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_HRMS_application() {
        openBrowserAndLaunchApplication();
    }

    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        sendText(login.userNameField,ConfigReader.getPropertyValue("username"));
        sendText(login.passwordField,ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(login.loginBtn);
    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        if(login.welcomeMsg.isDisplayed()){
            System.out.println("Test case is Passed.");
        }else{
            System.out.println("Test case is Failed.");
        }
    }
    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        sendText(login.userNameField, ConfigReader.getPropertyValue("invalidUsername"));
        sendText(login.passwordField, ConfigReader.getPropertyValue("invalidPassword"));

    }
    @Then("verify the error message")
    public void verify_the_error_message() {
        softAssertionEquals(login.errorMessage.getText(),ConfigReader.getPropertyValue("expectedErrorMessage"));
        screenShot();
    }
}

