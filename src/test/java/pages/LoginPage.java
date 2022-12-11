package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    @FindBy(id = "txtUsername")
    public WebElement userNameField;

    @FindBy(id = "txtPassword")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@name = 'Submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[text()='Welcome Admin']")
    public WebElement welcomeMsg;

    @FindBy(xpath = "//*[text()='Invalid credentials']")
    public WebElement errorMessage;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
}
