package AutomationQA.AutomationDemo.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 sec timeout
    }

    // Wait for element to be visible
    protected void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Click on an element
    protected void click(WebElement element) {
        waitForElement(element);
        element.click();
    }

    // Enter text in a field
    protected void enterText(WebElement element, String text) {
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    // Get text from an element
    protected String getElementText(WebElement element) {
        waitForElement(element);
        return element.getText();
    }

    // Check if an element is displayed
    protected boolean isElementDisplayed(WebElement element) {
        try {
            waitForElement(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
