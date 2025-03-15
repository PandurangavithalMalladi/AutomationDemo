package AutomationQA.AutomationDemoSauce.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPageSauce {
	WebDriver driver;
	String Text;

	@FindBy(xpath = "//span[text()='Your Cart']")
	private WebElement welcomeCartPage;

	@FindBy(xpath = "//button[text()='Checkout']")
	private WebElement Checkout;

	public CartPageSauce(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String WelcomeToCartPage() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
			wait.until(ExpectedConditions.visibilityOf(welcomeCartPage)); // Wait for the element to be visible
			System.out.println("welcomeProductsPage Element found: " + welcomeCartPage.isDisplayed()); // Debug log
			Text = welcomeCartPage.getText();
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
		wait.until(ExpectedConditions.visibilityOf(Checkout)); // Wait for the element to be visible
		System.out.println("Cart Element found: " + Checkout.isDisplayed()); // Debug log
		Checkout.click();
	}
}
