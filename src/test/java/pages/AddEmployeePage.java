package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(xpath = "//*[text()='Add Employee']")
    public WebElement addEmployeeOption;

    @FindBy(id = "firstName")
    public WebElement userNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }

}
