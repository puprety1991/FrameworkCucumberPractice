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

    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "photofile")
    public WebElement photograph;

    @FindBy(id = "chkLogin")
    public WebElement checkBox;

    @FindBy(id = "user_name")
    public WebElement createUserNameField;

    @FindBy(id = "user_password")
    public WebElement createPasswordField;

    @FindBy(id = "re_password")
    public WebElement confirmPasswordField;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }

}
