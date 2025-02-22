package WebTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LoginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            // ✅ Step 1: Open Login Page
            driver.get("https://stghul.adfluencetech.com/login");

            // ✅ Step 2: Login using OTP
            WebElement loginWithOtpButton = driver.findElement(By.id("profile2-tab"));
            loginWithOtpButton.click();

            WebElement emailInput = driver.findElement(By.id("loginemailmobile"));
            emailInput.sendKeys("changumangu@gmail.com");

            WebElement sendOtpButton = driver.findElement(By.id("sendOTP-btn"));
            sendOtpButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginotp")));
            otpField.sendKeys("6666");

            WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sendOTP-btn")));
            verifyButton.click();

            // ✅ Step 3: Wait for Dashboard to Load
            wait.until(ExpectedConditions.urlContains("dashboard"));
            System.out.println("✅ Login successful, redirected to Dashboard!");

            // ✅ Step 4: Get all Links on Dashboard
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            int totalLinks = 0, workingLinks = 0, brokenLinks = 0;

            System.out.println("\n🔗 **Checking all links on Dashboard**:");

            for (WebElement link : allLinks) {
                String linkText = link.getText().trim();
                String linkHref = link.getAttribute("href");

                if (linkText.isEmpty() || linkHref == null || linkHref.contains("javascript:void(0)")) {
                    System.out.println("❌ Skipping non-clickable link: " + linkText);
                    continue;
                }

                totalLinks++;
                String mainWindow = driver.getWindowHandle(); // ✅ Store main window handle

                // ✅ Open link in new tab
                ((ChromeDriver) driver).executeScript("window.open(arguments[0])", linkHref);

                // ✅ Switch to new tab
                for (String windowHandle : driver.getWindowHandles()) {
                    if (!windowHandle.equals(mainWindow)) {
                        driver.switchTo().window(windowHandle);
                        break;
                    }
                }

                // ✅ Check if the URL is loaded
                if (!driver.getCurrentUrl().equals(linkHref)) {
                    System.out.println("❌ Broken Link: " + linkText + " -> " + linkHref);
                    brokenLinks++;
                } else {
                    System.out.println("✅ Working Link: " + linkText + " -> " + linkHref);
                    workingLinks++;
                }

                // ✅ Close the new tab and switch back to the main window
                driver.close();
                driver.switchTo().window(mainWindow);
            }

            // ✅ Summary
            System.out.println("\n🔢 **Total Links Found: " + totalLinks + "**");
            System.out.println("✅ **Working Links: " + workingLinks + "**");
            System.out.println("❌ **Broken Links: " + brokenLinks + "**");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("\n🚪 ✅ Browser closed and WebDriver quit.");
        }
    }
}
