package AutomationQA.AutomationDemo.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationQA.AutomationDemoOrangeHRM.Pages.HomePage;
import AutomationQA.AutomationDemoOrangeHRM.Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTest {
	private WebDriver driver;
	String Path = "src/main/Resources/sample_data.xlsx";
	String Sheet = "Sheet2";

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Replace with actual login
																							// URL

	}

	@Test

	public void flow() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		String Username = ExcelReader.getCellValue(Path, Sheet, "User1", "Username");
		String Password = ExcelReader.getCellValue(Path, Sheet, "User1", "Password");
		loginPage.enterUsername(Username);
		loginPage.enterPassword(Password);
		loginPage.clickLogin();

		HomePage homepage = new HomePage(driver);
		String Homepage = homepage.getWelcomeMessage();
		System.out.println(Homepage);
		homepage.ClickOnAdmin();
		homepage.ClickOnAdd();
		homepage.ClickOnUserRole();
	}

}
