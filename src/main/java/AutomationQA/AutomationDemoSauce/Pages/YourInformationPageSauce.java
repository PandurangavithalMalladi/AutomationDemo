package AutomationQA.AutomationDemoSauce.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourInformationPageSauce {
    WebDriver driver;
    String Text;
    // Define elements using @FindBy annotation
    @FindBy(xpath="//span[contains(text(),'Your Information')]") 
    private WebElement YourInformation;

    @FindBy(xpath = "//input[@name ='firstName']") 
    private WebElement firstName;
    
    @FindBy(xpath = "//input[@name ='lastName']") 
    private WebElement lastName;
    
    @FindBy(xpath = "//input[@name ='postalCode']") 
    private WebElement postalCode;

    @FindBy(xpath = "//input[@type='submit']") 
	private WebElement loginButton;

    @FindBy(id = "errorMessage") 
    private WebElement errorMessage;
    private WebDriverWait wait;
    // Constructor
    public YourInformationPageSauce(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String WelcomeToYourInformationPage() {

		 
	    try {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
	        wait.until(ExpectedConditions.visibilityOf(YourInformation)); // Wait for the element to be visible
	        System.out.println("welcomeProductsPage Element found: " + YourInformation.isDisplayed()); // Debug log
	        Text = YourInformation.getText();
	        System.out.println("Text retrieved: " + Text); // Debug log
	        if (Text == null) { // Handle null text
	            Text = " (Default Message)";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        Text = "(Error occurred)"; // Provide a default message in case of an error
	    }
	    return Text;
}

    // Methods to interact with the page
    public void enterFirstName(String firstNameValue) throws InterruptedException {
    	firstName.sendKeys(firstNameValue);
    }

    public void enterLastName(String lastNameValue) {
    	lastName.sendKeys(lastNameValue);
    }
    
    public void enterPostalCode(String postalCodeValue) {
    	postalCode.sendKeys(postalCodeValue);
    }
    

    public void clickLogin() {
        loginButton.click();
    }
    /*
    public HomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new HomePage(driver);
    }*/
}
