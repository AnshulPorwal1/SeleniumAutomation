package WebTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Xpath {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stgbrand2.adfluencetech.com/");
		driver.findElement(By.xpath("//div[@class='form-group']/descendant::a[@class='form-control']")).sendKeys("test@gmail.com");
		
	}

}
