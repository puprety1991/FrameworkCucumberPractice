package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class SearchEmployeePage extends CommonMethods {
    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    @FindBy(id = "empsearch_id")
    public WebElement employeeIdTextField;

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement employeeNameTextField;

    @FindBy(id = "searchBtn")
    public WebElement searchButton;

    public SearchEmployeePage(){
        PageFactory.initElements(driver,this);
    }




}
