package WebTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

public class MultiBrowserLoginBrand {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adf.adfluencehub.com/login");

		driver.findElement(By.xpath("//*[@id=\"profile2-tab\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"loginemailmobile\"]")).sendKeys("vikasinf5@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"sendOTP-btn\"]")).click();
		Thread.sleep(2000);

		// Console se OTP input lene ka code
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter OTP: ");
		String otp = sc.nextLine();  // OTP Input Console se lega
		
		driver.findElement(By.xpath("//*[@id=\"loginotp\"]")).sendKeys(otp);
		Thread.sleep(2000);
		
		// Login button par click karega
		driver.findElement(By.xpath("//*[@id=\"sendOTP-btn\"]")).click();
		
		System.out.println("Login Successfully");
		
		
		
		//sc.close();  // Scanner close karna zaroori hai
		//driver.quit();  // Browser band karne ka code
	}
}
