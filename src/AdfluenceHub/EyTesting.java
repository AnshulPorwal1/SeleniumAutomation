package AdfluenceHub;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class EyTesting {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stgbrand2.adfluencetech.com/");
		driver.findElement(By.id("profile2-tab")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"loginemailmobile\"]")).sendKeys("amevtest@demo.com");
		driver.findElement(By.id("sendOTP-btn")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("loginotp")).sendKeys("6666");
		driver.findElement(By.xpath("//*[@id=\"sendOTP-btn\"]")).click();
		
		Thread.sleep(2000);
		driver.get("https://stghul.adfluencetech.com/campaign-workflows");
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"home-version-1\"]/div/section/div/div[1]/div[2]/a")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("planName")).sendKeys("Ice Cream Test Campaign");
		
		driver.findElement(By.xpath("//*[@id=\"planForm1\"]/div/div[1]/div/div[2]/div/span[1]/span[1]/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/span/span/span/ul/li[5]")).click();
		
		driver.findElement(By.id("select2-brandId-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[5]")).click();
		
		Select SubSegment = new Select (driver.findElement(By.id("subSegment")));
		Thread.sleep(2000);
		SubSegment.selectByVisibleText("Ice cream");
		
		Select PVariant = new Select (driver.findElement(By.id("variant")));
		Thread.sleep(1000);
		PVariant.selectByVisibleText("Ice cream");
		
		Select PlanType = new Select (driver.findElement(By.id("planType")));
		Thread.sleep(1000);
		PlanType.selectByVisibleText("Paid");
		
		Select CommissionType = new Select (driver.findElement(By.id("commissionType")));
		Thread.sleep(1000);
		CommissionType.selectByVisibleText("Percentage");
		
		driver.findElement(By.id("agencyCommission")).sendKeys("10");
		
		driver.findElement(By.xpath("//*[@id=\"planForm1\"]/div/div[1]/div/div[9]/div/span[1]/span[1]/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/span/span/span/ul/li[1]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"planForm1\"]/div/div[2]/div/button")).click();
		
		//Fill all Platform Selection Column 
		Thread.sleep(2000);
		driver.findElement(By.id("select2-planRegion-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[2]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[2]/div/div/div[1]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[3]/div/div/div[1]")).click();
		
		driver.findElement(By.id("brief")).sendKeys("Others who use this device won’t see your activity, so you can browse more privately. This won't change how data is collected by websites you visit and the services they use, including Google. Downloads, bookmarks and reading list items will be saved");
		
		driver.findElement(By.id("instagramInfluencerCount")).sendKeys("20");
		driver.findElement(By.id("noOfPost")).sendKeys("20");
		driver.findElement(By.id("noOfStories")).sendKeys("20");
		
		driver.findElement(By.xpath("//*[@id=\"planForm2\"]/div/div[2]/div/button[2]")).click();
		
		// Upload Plan case handle 
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"influencerList\"]/div[1]/div/div[4]/div/div[3]/button[1]")).click();
		
		Select UploadType = new Select (driver.findElement(By.id("uploadType")));
		UploadType.selectByVisibleText("Replace All");
		
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//*[@id=\"uploadInfluencerModal\"]/div/div/div/p/a")).click();
		//System.out.println("CSV File Download Successfully");
		
		Thread.sleep(1000);
		driver.findElement(By.id("infFile")).sendKeys("C:\\Users\\User\\Downloads\\plan_influencers (3).CSV");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"uploadInfluencerForm\"]/div/div[2]/div/div/button[2]")).click();
		
	
	/*
		// Add influencer Manual 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"influencerList\"]/div[2]/div/div/div/div[1]/div[2]/div[1]/button")).click();
		
		Thread.sleep(1000);
		Select PlatformIG = new Select (driver.findElement(By.id("influencerPlatform")));
		PlatformIG.selectByVisibleText("Instagram");
		
		driver.findElement(By.id("influencerHandle")).sendKeys("malaikaaroraofficial");
		
		driver.findElement(By.id("influencerCost")).sendKeys("1000");
		
		driver.findElement(By.id("influencerGenre")).sendKeys("Fashion");
		
		driver.findElement(By.id("influencerLocation")).sendKeys("Mumbai");
		
		driver.findElement(By.id("influencerGender")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/div[1]/div[6]/div/select/option[3]")).click();
		
		driver.findElement(By.id("contentLanguage")).sendKeys("English");
		
		driver.findElement(By.id("reelCount")).sendKeys("1");
		
		driver.findElement(By.id("staticPostCount")).sendKeys("1");
		
		driver.findElement(By.id("carouselCount")).sendKeys("1");
		
		driver.findElement(By.id("videoStoryCount")).sendKeys("1");
		
		driver.findElement(By.id("storyCount")).sendKeys("1");
		
		driver.findElement(By.id("staticPostCount")).sendKeys("1");
		
		driver.findElement(By.id("otherDeliverables")).sendKeys("Abc");
		
		driver.findElement(By.id("otherDeliverablesCost")).sendKeys("1");
		
		driver.findElement(By.xpath("//*[@id=\"addInfluencerModalForm\"]/div[2]/div/button[2]")).click();
		System.out.println("");
	*/
		
	/*
		// Click on back button and delete the plan on listing page 
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"home-version-1\"]/div/div[1]/div/nav/ol/li[1]/a")).click();
		
		driver.findElement(By.xpath("/html/body/div/section/div/div[2]/div/div/div[3]/div[1]/div[2]/div[2]/a[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"deletePlanForm\"]/button[2]")).click();
		
	*/
		// Verify View button on listing page
		//driver.findElement(By.xpath("//*[@id=\"listing\"]/div[1]/div[2]/div[2]/a[1]")).click();
		
		// Verify search box on listing page 
		//driver.findElement(By.id("planSearch")).sendKeys("Lakme Test Campaign");
		
		//Verify See more button on listing page
	/*	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/section/div/div[2]/div/div/div[3]/div[11]/div/a")).click();
    */
		
	/*	
		//verify filter on listing page 
		Thread.sleep(1000);
		driver.findElement(By.id("filterButton")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"filterBox\"]/div[3]/div[1]/div[2]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"filterBox\"]/div[3]/div[2]/div[2]/div/div[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"brand\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/section/div/div[2]/div/div/div[1]/div[2]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div[1]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("filterApply")).click();
		
		//Again click on Filter and Click on Reset button 

		Thread.sleep(1000);
		driver.findElement(By.id("filterButton")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("filterReset")).click();
		
	*/
		

	}

}
