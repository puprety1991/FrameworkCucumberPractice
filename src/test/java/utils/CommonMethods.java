package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import steps.PageInitializer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");

        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        initializePageObjects();

    }
    public static void tearDown(){
        driver.quit();
    }

    public static void sendText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
        return wait;
    }
    public static void clickWaitForClickAbility(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        clickWaitForClickAbility(element);
        element.click();
    }
    public static JavascriptExecutor getJsExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }
    public static void jsClick(WebElement element){
        getJsExecutor().executeScript("arguments[0].click();",element);
    }
    public static void selectDropDown(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);

    }
    public static SoftAssert getSoftAssertion(){
        SoftAssert soft = new SoftAssert();
        return soft;
    }
    public static void softAssertionEquals(String expectedErrorMessage, String actualErrorMessage){
        getSoftAssertion().assertEquals(actualErrorMessage,expectedErrorMessage);
        getSoftAssertion().assertAll();

    }
    public static void softAssertionDisplay(WebElement element){
        boolean isDisplayed=element.isDisplayed();
         getSoftAssertion().assertTrue(isDisplayed);
        getSoftAssertion().assertAll();
    }
    public static byte[] takeScreenshot(String folderName,String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH +"/"+ folderName +"/"+ fileName
                    + " " + getTimeStamp("yyyy-MM-dd, HH-mm-ss")+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern){
        Date date = new Date();
        //to format the date according to our choice we want to implement in this function
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

}
