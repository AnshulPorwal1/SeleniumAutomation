package WebTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ReadyToDeploy {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Set wait globally to 20 seconds

        driver.get("https://stgbrand2.adfluencetech.com/login");
        driver.manage().window().maximize();

        // **Step 1: Login Process**
        driver.findElement(By.id("loginemail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("loginpassword")).sendKeys("Tata@123");
        driver.findElement(By.className("submit-button")).click();
        wait.until(ExpectedConditions.urlContains("dashboard"));  // Wait for login to complete

        // **Step 2: Navigate to 'Customize New Plan' Page**
        driver.get("https://stgbrand2.adfluencetech.com/rtdPlans/create");
        wait.until(ExpectedConditions.urlToBe("https://stgbrand2.adfluencetech.com/rtdPlans/create"));
        System.out.println("Successfully reached 'Customize New Plan' page.");

        // **Step 3: Select Brand**
        Select brandDropdown = new Select(driver.findElement(By.id("brandId")));
        brandDropdown.selectByIndex(77);
        System.out.println("Selected brand option: 77");

        // **Step 4: Enter Campaign Title**
        WebElement campaignTitle = driver.findElement(By.id("title"));
        campaignTitle.sendKeys("Automation test campaign");
        System.out.println("Entered Campaign Title: Automation test campaign");

        // **Step 5: Select Category**
        Select categoryDropdown = new Select(driver.findElement(By.id("childCategory")));
        categoryDropdown.selectByIndex(5);
        System.out.println("Selected category option: 5");

        // **Step 6: Enter Influencer Count**
        WebElement influencerCount = driver.findElement(By.xpath("//*[@id='formStep3']/div/div[1]/div[1]/div[5]/div/input"));
        influencerCount.sendKeys("10");
        System.out.println("Entered Influencer Count: 10");

        // **Step 7: Enter Reel Count**
        WebElement reelCount = driver.findElement(By.id("reelCount"));
        reelCount.sendKeys("1");
        System.out.println("Entered Reel Count: 1");

        // **Step 8: Enter Static Post Count**
        WebElement staticPostCount = driver.findElement(By.id("staticPostCount"));
        staticPostCount.sendKeys("1");
        System.out.println("Entered Static Post Count: 1");

        // **Step 9: Enter Story Count**
        WebElement storyCount = driver.findElement(By.id("storyCount"));
        storyCount.sendKeys("1");
        System.out.println("Entered Story Count: 1");

        // **Step 10: Click Submit Button**
        WebElement submitButton = driver.findElement(By.xpath("//*[@id='formStep3']/div/div[2]/div/button"));
        submitButton.click();
        System.out.println("Submit button clicked successfully.");

        // **Step 11: Validate Redirect to Target Filter Page**
        wait.until(ExpectedConditions.urlContains("/targetFilter"));

        String currentURL = driver.getCurrentUrl();
        String[] urlParts = currentURL.split("/");
        String dynamicPlanId = urlParts[urlParts.length - 2];

        System.out.println("✅ Successfully redirected to Target Filter Page with Plan ID: " + dynamicPlanId);

        // **Step 12: Apply Target Filters**
        // Select Age Group
        selectDropdownValue(driver, wait, "//*[@id='formTargetFilter']/div/div[1]/div[1]/div[3]/div/span/span[1]/span", "18-24 years");

        // Select Gender
        selectDropdownValue(driver, wait, "//*[@id='formTargetFilter']/div/div[1]/div[1]/div[2]/div/span/span[1]/span", "Female");

        // Select Zone
        selectDropdownValue(driver, wait, "/html/body/div/div/div/div[2]/div[2]/div/div/form/div/div[1]/div[1]/div[1]/div/span", "North Zone");

        // Select Interest
        selectDropdownValue(driver, wait, "//*[@id='formTargetFilter']/div/div[1]/div[1]/div[4]/div/span/span[1]/span", "Beauty");

        // Select Language
        selectDropdownValue(driver, wait, "//*[@id='formTargetFilter']/div/div[1]/div[1]/div[5]/div/span/span[1]/span", "Hindi");

        // Select Influencer Type
        selectDropdownValue(driver, wait, "//*[@id='select2-influencerType-container']", "Amplifier");

        // Select Engagement Rate
        selectDropdownValue(driver, wait, "//*[@id='formTargetFilter']/div/div[1]/div[1]/div[7]/div/span/span[1]/span", "7-9");

        // **Step 13: Submit Target Filter**
        WebElement submitFilterButton = driver.findElement(By.xpath("//*[@id='formTargetFilter']/div/div[2]/div/button"));
        submitFilterButton.click();
        System.out.println("✅ Target Filter applied successfully.");

        // **Step 14: Confirmation after applying filters**
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shortlistedBar']/div/div")));
        System.out.println("✅ Filters applied and successfully displayed on the next page.");

        // Close the browser
        driver.quit();
    }

    public static void selectDropdownValue(WebDriver driver, WebDriverWait wait, String dropdownXpath, String valueToSelect) {
        try {
            WebElement filterElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXpath)));
            filterElement.click();
            Thread.sleep(1000); // Wait for dropdown options

            // Select specific value from dropdown
            WebElement optionToSelect = driver.findElement(By.xpath("//li[contains(text(),'" + valueToSelect + "')]"));
            optionToSelect.click();
            System.out.println("✅ Selected '" + valueToSelect + "'");
        } catch (Exception e) {
            System.out.println("❌ Error selecting value '" + valueToSelect + "': " + e.getMessage());
        }
    }
}
