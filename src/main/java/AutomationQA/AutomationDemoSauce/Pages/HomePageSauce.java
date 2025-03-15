package AutomationQA.AutomationDemoSauce.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSauce {
	WebDriver driver;
	String Text;

	@FindBy(xpath = "//span[text()='Products']")
	private WebElement welcomeProductsPage;

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']/following::button[text()='Add to cart']")
	private WebElement SauceLabsBackpackAddToCart;

	@FindBy(xpath = "//a[@data-test='shopping-cart-link']")
	private WebElement Cart;

	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']/following::button[text()='Add to cart']")
	private WebElement SauceLabsBikeLightAddToCart;

	@FindBy(xpath = "//div[@role='listbox']")
	private WebElement UserRoleAdmin;

	public HomePageSauce(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String WelcomeToProductsPage() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
			wait.until(ExpectedConditions.visibilityOf(welcomeProductsPage)); // Wait for the element to be visible
			System.out.println("welcomeProductsPage Element found: " + welcomeProductsPage.isDisplayed()); // Debug log
			Text = welcomeProductsPage.getText();
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

	public void ClickOnSauceLabsBackpackAddToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		wait.until(ExpectedConditions.visibilityOf(SauceLabsBackpackAddToCart)); // Wait for the element to be visible
		System.out.println("SauceLabsBackpack AddToCart Element found: " + SauceLabsBackpackAddToCart.isDisplayed()); // Debug
																														// log
		SauceLabsBackpackAddToCart.click();
	}

	public void ClickOnSauceLabsBikeLightAddToCart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		wait.until(ExpectedConditions.visibilityOf(SauceLabsBikeLightAddToCart)); // Wait for the element to be visible
		System.out.println("SauceLabsBikeLight AddToCart Element found: " + SauceLabsBikeLightAddToCart.isDisplayed()); // Debug
																														// log
		SauceLabsBackpackAddToCart.click();
	}

	public void ClickOnCart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		wait.until(ExpectedConditions.visibilityOf(Cart)); // Wait for the element to be visible
		System.out.println("Cart Element found: " + Cart.isDisplayed()); // Debug log
		Cart.click();
	}
}
