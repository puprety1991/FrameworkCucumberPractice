package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
    @When("click on PIM option")
    public void click_on_pim_option() {
     click(dashboard.pimOption);
    }

    @When("click on AddEmployee from menu")
    public void click_on_add_employee_from_menu() {
        click(addEmployee.addEmployeeOption);
    }
    @When("user enter the firstname and lastname")
    public void user_enter_the_firstname_and_lastname() {
        sendText(addEmployee.userNameField, "Harry");
        sendText(addEmployee.lastNameField, "potter");
    }
    @When("click on Save button")
    public void click_on_save_button() {
        click(addEmployee.saveButton);
    }
    @Then("verify the employee info")
    public void verify_the_employee_info() {
        System.out.println("Successfully added");
    }
    @When("user enter the {string} and {string}")
    public void user_enter_the_and(String firstName, String lastName) {
       sendText(addEmployee.userNameField, firstName);
       sendText(addEmployee.lastNameField, lastName);
    }
    @When("user enter the {string} and {string} for multiple employees")
    public void user_enter_the_and_for_multiple_employees(String firstName, String lastName) {
        sendText(addEmployee.userNameField, firstName);
        sendText(addEmployee.lastNameField, lastName);
    }
}
