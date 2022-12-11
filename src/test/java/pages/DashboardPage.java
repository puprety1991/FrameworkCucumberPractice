package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.DashboardSteps;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {
    @FindBy(xpath = "//h1[text()='Dashboard']")
    public WebElement dashboardText;

    @FindBy(xpath = "//*[text()='PIM']")
    public WebElement pimOption;


    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
}
