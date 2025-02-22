package WebTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleTest {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://stgbrand2.adfluencetech.com/");
		
		WebDriver driver1=new FirefoxDriver();
		driver1.get("https://stghul.adfluencetech.com/");

	}

}
