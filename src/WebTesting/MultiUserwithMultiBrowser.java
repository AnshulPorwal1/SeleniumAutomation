package WebTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class MultiUserwithMultiBrowser {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stgadf.adfluencetech.com/");
		driver.findElement(By.id("loginemail")).sendKeys("agency234@gmail.com");
		driver.findElement(By.id("loginpassword")).sendKeys("owq03Sas");
		driver.findElement(By.className("submit-button")).click();
		System.out.println("ftue popup is coming on chrome browser test case passed");
		
		WebDriver driver1=new FirefoxDriver();
		driver.manage().window().maximize();
		driver1.get("https://stgbrand2.adfluencetech.com/");
		driver1.findElement(By.id("loginemail")).sendKeys("Abc123@gmail.com");
		driver1.findElement(By.id("loginpassword")).sendKeys("4xtGe1rW");
		driver1.findElement(By.className("submit-button")).click();
		System.out.println("ftue popup is coming on firefox browser test case passed");
		
		WebDriver driver2=new EdgeDriver();
		driver.manage().window().maximize();
		driver2.get("https://stghul.adfluencetech.com/");
		driver2.findElement(By.id("loginemail")).sendKeys("Mcont@hul.gmail.com");
		driver2.findElement(By.id("loginpassword")).sendKeys("k9xS2Mm3");
		driver2.findElement(By.className("submit-button")).click();
		System.out.println("ftue popup is coming on Edge browser test case passed");
		
		

	}

}
