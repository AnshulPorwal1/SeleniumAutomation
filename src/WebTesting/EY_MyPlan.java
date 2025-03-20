package WebTesting;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EY_MyPlan {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stghul.adfluencetech.com/login");

		driver.findElement(By.xpath("//*[@id=\"profile2-tab\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"loginemailmobile\"]")).sendKeys("hulbrand@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"sendOTP-btn\"]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"loginotp\"]")).sendKeys("6666");
		driver.findElement(By.xpath("//*[@id=\"sendOTP-btn\"]")).click();

		// This Mathod using for select menu and click on sub menu

		Thread.sleep(2000);
		WebElement Ele = driver.findElement(By.xpath("//header//ul/li[3]/a/span\r\n"));
		Thread.sleep(2000);
		WebElement Ele1 = driver.findElement(By.xpath("//*[@id=\"home-version-1\"]/div/header/div/div[1]/ul/li[3]/ul/li[4]/a"));
		Actions s = new Actions(driver);
		s.moveToElement(Ele);
		s.click(Ele1);
		s.build().perform();
		
		// click on the create new plan button 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"home-version-1\"]/div/section/div/div[1]/div[2]/a")).click();
		
		// Fill and select all column value and click save and next button 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"planName\"]")).sendKeys("Instagram My Plan Test");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"planForm1\"]/div/div[1]/div/div[2]/div/span[1]/span[1]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("select2-brandManager-result-sffp-5676")).click();
		
		// Console se OTP input lene ka code
		/*
		 * Scanner sc = new Scanner(System.in); System.out.print("Enter OTP: "); String
		 * otp = sc.nextLine(); // OTP Input Console se lega
		 * 
		 * driver.findElement(By.xpath("//*[@id=\"loginotp\"]")).sendKeys(otp);
		 * Thread.sleep(2000);
		 * 
		 * // Login button par click karega
		 * driver.findElement(By.xpath("//*[@id=\"sendOTP-btn\"]")).click();
		 * 
		 * System.out.println("Login Successfully");
		 * 
		 */

		// sc.close(); // Scanner close karna zaroori hai
		// driver.quit(); // Browser band karne ka code
	}
}
