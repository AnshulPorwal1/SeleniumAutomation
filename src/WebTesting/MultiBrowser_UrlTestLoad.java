package WebTesting;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MultiBrowser_UrlTestLoad {

    public static void main(String[] args) {
        List<String> urls = List.of(
        		"https://stgbrand.adfluencetech.com/macroDashboard",
        		"https://stgbrand.adfluencetech.com/influencers/profile/reportSearch",
        		"https://stgbrand.adfluencetech.com/influencerDiscovery",
        		"https://stgbrand.adfluencetech.com/industryInfluencers",
        		"https://stgbrand.adfluencetech.com/my-lists",
        		"https://stgbrand.adfluencetech.com/rosters",
        		"https://stgbrand.adfluencetech.com/competitionAnalysis",
        		"https://stgbrand.adfluencetech.com/macroCampaigns",
        		"https://stgbrand.adfluencetech.com/brand-analysis",
        		"https://stgbrand.adfluencetech.com/microDashboard",
        		"https://stgbrand.adfluencetech.com/campaigns",
        		"https://stgbrand.adfluencetech.com/campaignBriefs",
        		"https://stgbrand.adfluencetech.com/enquiries",
        		"https://stgbrand.adfluencetech.com/myProfile",
        		"https://stgbrand.adfluencetech.com/aboutCompany",
        		"https://stgbrand.adfluencetech.com/members",
        		"https://stgbrand.adfluencetech.com/partners",
        		"https://stgbrand.adfluencetech.com/invitations",
        		"https://stgbrand.adfluencetech.com/brand",
        		"https://stgbrand.adfluencetech.com/credits"
        );

        Map<String, Map<String, Long>> results = new HashMap<>();

        // Test on all browsers
        results.put("Chrome", testOnBrowser("Chrome", urls));
        results.put("Firefox", testOnBrowser("Firefox", urls));
        results.put("Edge", testOnBrowser("Edge", urls));

        // Print results for all browsers
        System.out.println("\n=== Results for All Browsers ===");
        for (Map.Entry<String, Map<String, Long>> browserEntry : results.entrySet()) {
            System.out.println("Browser: " + browserEntry.getKey());
            for (Map.Entry<String, Long> urlEntry : browserEntry.getValue().entrySet()) {
                System.out.println("  URL: " + urlEntry.getKey());
                System.out.println("    Load Time: " + urlEntry.getValue() + " milliseconds");
            }
        }
    }

    private static Map<String, Long> testOnBrowser(String browser, List<String> urls) {
        WebDriver driver = null;

        // Configure driver for each browser
        switch (browser) {
            case "Chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "Firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "Edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                System.out.println("Unsupported browser: " + browser);
                return new HashMap<>();
        }

        System.out.println("Testing on browser: " + browser);
        Map<String, Long> results = new HashMap<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Login process
        driver.get("https://stgbrand.adfluencetech.com/login");
        driver.findElement(By.id("loginemail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("loginpassword")).sendKeys("Tata@123");
        driver.findElement(By.className("submit-button")).click();

        try {
            Thread.sleep(2000); // Consider WebDriverWait for better synchronization
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Open each URL in a new tab and measure load time
        for (String url : urls) {
            js.executeScript("window.open('" + url + "', '_blank');");

            // Switch to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabs.size() - 1));

            // Measure load time
            Instant loadStart = Instant.now();
            driver.get(url);
            Instant loadEnd = Instant.now();
            long loadTimeInMillis = Duration.between(loadStart, loadEnd).toMillis();
            results.put(url, loadTimeInMillis);

            // Print the load time
            System.out.println(browser + " - URL: " + url + " Load Time: " + loadTimeInMillis + " milliseconds");

            // Close the tab after measurement
            driver.close();
            driver.switchTo().window(tabs.get(0)); // Switch back to the main tab
        }

        // Quit the driver
        driver.quit();

        return results;
    }
}