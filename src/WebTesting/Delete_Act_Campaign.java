package WebTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Delete_Act_Campaign {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://stgbrand.adfluencetech.com/login");
		driver.manage().window().maximize();

		driver.findElement(By.id("loginemail")).sendKeys("test@gmail.com");
		driver.findElement(By.id("loginpassword")).sendKeys("Tata@123");
		driver.findElement(By.className("submit-button")).click();

		// This Mathod using for select menu and click on sub menu

		Thread.sleep(2000);
		WebElement Ele = driver.findElement(By.xpath("//header//ul/li[3]/a/span\r\n"));
		Thread.sleep(2000);
		WebElement Ele1 = driver.findElement(By.xpath("//header//ul/li[3]//ul/li[2]/a\r\n"));
		Actions s = new Actions(driver);
		s.moveToElement(Ele);
		s.click(Ele1);
		s.build().perform();
		
		
        // Loop to perform the delete operation 20 times
        for (int i = 1; i <= 20; i++) {
            try {
                // Apply filter for the campaign
                driver.findElement(By.id("filter_campaign")).clear(); // Clear previous input

		driver.findElement(By.id("filter_campaign")).sendKeys("Anik"); // using search campaign
		
		Thread.sleep(2000); // Wait for the filter to apply and results to load

		// Locate the delete button for the filtered campaign
		// Adjust the XPath below to match the actual structure of the campaign list
		
		WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"innerListingBody\"]/tr[1]/td[9]/a[2]"));
		deleteButton.click();
		
		// Handle confirmation popup if it appears
		// Update the XPath or identifier as per the actual confirmation dialog
		
		Thread.sleep(2000); // Wait for confirmation dialog
		WebElement confirmDelete = driver.findElement(By.id("deleteCampaignButton"));
		confirmDelete.click();
		
		// Add a log for tracking progress
        System.out.println("Deleted campaign " + i);

		// Add a final wait to observe the result (optional)
		Thread.sleep(2000);
            } catch (Exception e) {
                // Handle exceptions and log the error
                System.out.println("An error occurred during deletion for iteration " + i + ": " + e.getMessage());
            }
        }

        // Close the browser after the loop completes
        driver.quit();
    }
}