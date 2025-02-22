package WebTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LandingPageTest {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the landing page
        driver.get("https://stghul.adfluencetech.com/nalanda/index.html");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Verify all internal and external links
        verifyLinks(driver);

        // Verify buttons are clickable
        verifyButtons(driver);

        // Verify basic UI elements
        verifyUIElements(driver);

        // Close the browser
        driver.quit();
    }

    // Method to verify all links
    public static void verifyLinks(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        for (int i = 0; i < links.size(); i++) {
            WebElement link = driver.findElements(By.tagName("a")).get(i);  // Refetching element to avoid stale reference
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                System.out.println("Link text: " + link.getText() + " | URL: " + url);
                verifyLinkIsClickable(driver, link);
            } else {
                System.out.println("Link with text '" + link.getText() + "' has no URL.");
            }
        }
    }

    // Helper method to check if a link is clickable and verify its icon if not clickable
    public static void verifyLinkIsClickable(WebDriver driver, WebElement link) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(link));
            System.out.println("Link '" + link.getText() + "' is clickable.");
        } catch (Exception e) {
            System.out.println("Link '" + link.getText() + "' is NOT clickable.");
            verifyLinkedIcon(driver, link);
        }
    }

    // Method to verify the icon associated with a non-clickable link
    public static void verifyLinkedIcon(WebDriver driver, WebElement link) {
        try {
            WebElement icon = link.findElement(By.tagName("img"));
            if (icon.isDisplayed()) {
                System.out.println("Icon for link '" + link.getText() + "' is visible.");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.elementToBeClickable(icon));
                System.out.println("Icon for link '" + link.getText() + "' is clickable.");
            }
        } catch (Exception e) {
            System.out.println("No clickable icon found for link '" + link.getText() + "'.");
        }
    }

    // Method to verify buttons are clickable with scrolling
    public static void verifyButtons(WebDriver driver) {
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("Total buttons found: " + buttons.size());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement button : buttons) {
            try {
                // Scroll the button into view
                js.executeScript("arguments[0].scrollIntoView(true);", button);
                Thread.sleep(500); // Small delay to allow scrolling effect

                // Check if the button is clickable
                wait.until(ExpectedConditions.elementToBeClickable(button));
                System.out.println("Button with text '" + button.getText() + "' is clickable.");
            } catch (Exception e) {
                System.out.println("Button with text '" + button.getText() + "' is NOT clickable.");
            }
        }
    }

    // Method to verify basic UI elements are displayed
    public static void verifyUIElements(WebDriver driver) {
        // Example: Check if logo is displayed
        try {
            WebElement logo = driver.findElement(By.xpath("//img[contains(@src, 'logo')]"));
            if (logo.isDisplayed()) {
                System.out.println("Logo is displayed correctly.");
            }
        } catch (Exception e) {
            System.out.println("Logo is NOT displayed.");
        }

        // Example: Verify headers and important texts
        List<WebElement> headers = driver.findElements(By.tagName("h1"));
        for (WebElement header : headers) {
            if (header.isDisplayed()) {
                System.out.println("Header: '" + header.getText() + "' is visible.");
            } else {
                System.out.println("Header: '" + header.getText() + "' is NOT visible.");
            }
        }
    }
}
