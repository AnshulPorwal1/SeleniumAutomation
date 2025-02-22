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


public class MultiURLLoadTime {

    public static void main(String[] args) 
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
		
        List<String> urls = List.of("https://stgbrand.adfluencetech.com/macroDashboard", 
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
				"https://stgbrand.adfluencetech.com/credits");
        Map<String, Long> loadTimes = new HashMap<>();
        
        driver.get("https://stgbrand.adfluencetech.com/login");
        
        driver.findElement(By.id("loginemail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("loginpassword")).sendKeys("Tata@123");
        driver.findElement(By.className("submit-button")).click();
        
        try {
            Thread.sleep(2000);  // Simple wait; consider using WebDriverWait for better handling
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
        for (String url : urls) {
            ((JavascriptExecutor) driver).executeScript("window.open('" + url + "', '_blank');");
        }
		
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		
        for (int i = 1; i < tabs.size(); i++) {
            driver.switchTo().window(tabs.get(i));

            Instant start = Instant.now();
            driver.get(urls.get(i - 1)); // Access URL in the new tab
            Instant end = Instant.now();

            long loadTime = Duration.between(start, end).toMillis();
            loadTimes.put(urls.get(i - 1), loadTime);
        }

        // Print loading times for each page
        for (Map.Entry<String, Long> entry : loadTimes.entrySet()) {
            System.out.println("Load time for " + entry.getKey() + ": " + entry.getValue() + " ms");
        }
        
        driver.quit();
		

	}

}
