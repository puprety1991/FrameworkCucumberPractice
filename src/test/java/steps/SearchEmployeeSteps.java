package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.ConfigReader;

public class SearchEmployeeSteps extends CommonMethods {
    @When("click on Employee List from menu")
    public void click_on_employee_list_from_menu() {
        click(searchEmployee.employeeListOption);
    }
    @When("user enter the id of this employee")
    public void user_enter_the_id_of_this_employee() {
       sendText(searchEmployee.employeeIdTextField, ConfigReader.getPropertyValue("empId"));
    }
    @When("click on search button")
    public void click_on_search_button() {
        click(searchEmployee.searchButton);
    }
    @Then("verify the employee")
    public void verify_the_employee() {
        System.out.println("search successfully.");
    }
    @When("user enter the name of this employee")
    public void user_enter_the_name_of_this_employee() {
        sendText(searchEmployee.employeeNameTextField,ConfigReader.getPropertyValue("employeeName"));
    }

}
