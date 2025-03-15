package AutomationQA.AutomationDemoOrangeHRM.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	String Text;
	
	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement welcomeDashboard;
	
	@FindBy(xpath = "//span[text()='Admin']/parent::a")
	private WebElement Admin;
	
	@FindBy(xpath = "//button[text()=' Add ']")
	private WebElement Add;
	
	@FindBy(xpath = "//label[text()='User Role']/following::div[text()='-- Select --']/parent::div/parent::div/parent::div")
	private WebElement UserRole;
	
	@FindBy(xpath = "//div[@role='listbox']")
	private WebElement UserRoleAdmin;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getWelcomeMessage() {

		 
		    try {
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		        wait.until(ExpectedConditions.visibilityOf(welcomeDashboard)); // Wait for the element to be visible
		        System.out.println("welcomeDashboard Element found: " + welcomeDashboard.isDisplayed()); // Debug log
		        Text = welcomeDashboard.getText();
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
	
	public void ClickOnAdmin()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		wait.until(ExpectedConditions.visibilityOf(Admin)); // Wait for the element to be visible
        System.out.println("Admin Element found: " + Admin.isDisplayed()); // Debug log
		Admin.click();
	}
	
	public void ClickOnAdd() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		wait.until(ExpectedConditions.visibilityOf(Add)); // Wait for the element to be visible
        System.out.println("Add Element found: " + Add.isDisplayed()); // Debug log
		Add.click();
	}
	
	public void ClickOnUserRole() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		wait.until(ExpectedConditions.visibilityOf(UserRole)); // Wait for the element to be visible
        System.out.println("UserRole Element found: " + UserRole.isDisplayed()); // Debug log
		UserRole.click();
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'User Role')]/following::div[1]")));
        dropdown.click();
        
        // Wait for dropdown options to appear and select "Admin"
        WebElement adminOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option' and text()='Admin']")));
        adminOption.click();

        // Wait and close browser
        Thread.sleep(2000);
	        
	        // Close Browser
	        Thread.sleep(2000); 
	}
	
}
