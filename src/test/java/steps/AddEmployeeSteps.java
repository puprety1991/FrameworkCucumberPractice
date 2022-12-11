package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    @When("user add multiple employees from excel using {string} and verify it")
    public void user_add_multiple_employees_from_excel_using_and_verify_it(String sheetName) throws InterruptedException {
        List<Map<String, String>> empFromExcel = ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH, sheetName);
        Iterator<Map<String, String>> iterator = empFromExcel.iterator();
        while(iterator.hasNext()){
            Map<String, String> individualEmployee = iterator.next();
            sendText(addEmployee.userNameField,individualEmployee.get("firstName"));
            sendText(addEmployee.middleNameField,individualEmployee.get("middleName"));
            sendText(addEmployee.lastNameField,individualEmployee.get("lastName"));
            sendText(addEmployee.photograph,individualEmployee.get("photograph"));
            if(!addEmployee.checkBox.isSelected()){
                click(addEmployee.checkBox);
            }
            sendText(addEmployee.createUserNameField, individualEmployee.get("username"));
            sendText(addEmployee.createPasswordField, individualEmployee.get("password"));
            sendText(addEmployee.confirmPasswordField,individualEmployee.get("confirmPassword"));
            click(addEmployee.saveButton);

            Thread.sleep(2000);

            click(addEmployee.addEmployeeOption);
            Thread.sleep(2000);

        }



    }

}
