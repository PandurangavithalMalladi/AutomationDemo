package AutomationQA.AutomationDemoOrangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    // Define elements using @FindBy annotation
    @FindBy(xpath="//input[@name ='username']") 
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name ='password']") 
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']") 
    private WebElement loginButton;

    @FindBy(id = "errorMessage") 
    private WebElement errorMessage;
    private WebDriverWait wait;
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with the page
    public void enterUsername(String username) throws InterruptedException {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
    /*
    public HomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new HomePage(driver);
    }*/
}
