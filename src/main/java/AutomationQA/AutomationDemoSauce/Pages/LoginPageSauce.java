package AutomationQA.AutomationDemoSauce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSauce {
	WebDriver driver;

	// Define elements using @FindBy annotation
	@FindBy(xpath = "//input[@name ='user-name']")
	private WebElement usernameField;

	@FindBy(xpath = "//input[@name ='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;

	@FindBy(id = "errorMessage")
	private WebElement errorMessage;

	// Constructor
	public LoginPageSauce(WebDriver driver) {
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
	 * public HomePage login(String username, String password) {
	 * enterUsername(username); enterPassword(password); clickLogin(); return new
	 * HomePage(driver); }
	 */
}
