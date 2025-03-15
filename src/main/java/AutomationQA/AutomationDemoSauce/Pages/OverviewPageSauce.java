package AutomationQA.AutomationDemoSauce.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverviewPageSauce {
	WebDriver driver;
	String Text;

	@FindBy(xpath = "//span[text()='Checkout: Overview']")
	private WebElement welcomeOverviewPage;

	@FindBy(xpath = "//button[text()='Finish']")
	private WebElement Finish;

	public OverviewPageSauce(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String WelcomeOverviewPage() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
			wait.until(ExpectedConditions.visibilityOf(welcomeOverviewPage)); // Wait for the element to be visible
			System.out.println("welcomeProductsPage Element found: " + welcomeOverviewPage.isDisplayed()); // Debug log
			Text = welcomeOverviewPage.getText();
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

	public void ClickOnCheckout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		wait.until(ExpectedConditions.visibilityOf(Finish)); // Wait for the element to be visible
		System.out.println("Cart Element found: " + Finish.isDisplayed()); // Debug log
		Finish.click();
	}
}
