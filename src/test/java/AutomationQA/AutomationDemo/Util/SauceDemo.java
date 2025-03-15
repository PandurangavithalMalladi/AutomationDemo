package AutomationQA.AutomationDemo.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationQA.AutomationDemoSauce.Pages.CartPageSauce;
import AutomationQA.AutomationDemoSauce.Pages.HomePageSauce;
import AutomationQA.AutomationDemoSauce.Pages.LoginPageSauce;
import AutomationQA.AutomationDemoSauce.Pages.OverviewPageSauce;
import AutomationQA.AutomationDemoSauce.Pages.YourInformationPageSauce;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo {
	private WebDriver driver;
	String Path = "src/main/Resources/sample_data.xlsx";
	String Sheet = "Sheet3";

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/"); // Replace with actual login URL

	}

	@Test

	public void flow() throws InterruptedException {
		LoginPageSauce loginPage = new LoginPageSauce(driver);
		String Username = ExcelReader.getCellValue(Path, Sheet, "User1", "Username");
		String Password = ExcelReader.getCellValue(Path, Sheet, "User1", "Password");
		loginPage.enterUsername(Username);
		loginPage.enterPassword(Password);
		loginPage.clickLogin();

		HomePageSauce homePageSauce = new HomePageSauce(driver);
		String Homepage = homePageSauce.WelcomeToProductsPage();
		homePageSauce.ClickOnSauceLabsBackpackAddToCart();
		homePageSauce.ClickOnSauceLabsBikeLightAddToCart();
		homePageSauce.ClickOnCart();
		Assert.assertEquals(Homepage, "Products", "Page title is not as expected!");

		CartPageSauce cartPageSauce = new CartPageSauce(driver);
		String Cartpage= cartPageSauce.WelcomeToCartPage();
		cartPageSauce.ClickOnCheckout();
		Assert.assertEquals(Cartpage, "Your Cart", "Page title is not as expected!");
		
		YourInformationPageSauce yourInformationPageSauce = new YourInformationPageSauce(driver);
		String YourInfo=yourInformationPageSauce.WelcomeToYourInformationPage();
		String firstNameValue = ExcelReader.getCellValue(Path, Sheet, "User1", "FirstName");
		String lastNameValue = ExcelReader.getCellValue(Path, Sheet, "User1", "LastName");
		String postalCodeValue = ExcelReader.getCellValue(Path, Sheet, "User1", "ZipCode");
		yourInformationPageSauce.enterFirstName(firstNameValue);
		yourInformationPageSauce.enterLastName(lastNameValue);
		yourInformationPageSauce.enterPostalCode(postalCodeValue);
		yourInformationPageSauce.clickLogin();
		Assert.assertEquals(YourInfo, "Checkout: Your Information", "Page title is not as expected!");
		
		OverviewPageSauce overviewPageSauce = new OverviewPageSauce(driver);
		String Overview = overviewPageSauce.WelcomeOverviewPage();
		overviewPageSauce.ClickOnCheckout();
		Assert.assertEquals(Overview, "Checkout: Overview", "Page title is not as expected!");
	}

	  @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
