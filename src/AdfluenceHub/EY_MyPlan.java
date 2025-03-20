package AdfluenceHub;

import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class EY_MyPlan {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stghul.adfluencetech.com/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.findElement(By.xpath("//*[@id='profile2-tab']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='loginemailmobile']")).sendKeys("hulbrand@gmail.com");
        driver.findElement(By.xpath("//*[@id='sendOTP-btn']")).click();
        
        // OTP Input from Console
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter OTP: ");
        String otp = sc.nextLine();
        driver.findElement(By.xpath("//*[@id='loginotp']")).sendKeys(otp);
        driver.findElement(By.xpath("//*[@id='sendOTP-btn']")).click();

        System.out.println("Login Successfully");

        // Select Menu and Submenu with Hover and Click
        WebElement Ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header//ul/li[3]/a/span")));
        Actions s = new Actions(driver);
        s.moveToElement(Ele).perform();
        Thread.sleep(2000);
        WebElement Ele1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='home-version-1']/div/header/div/div[1]/ul/li[3]/ul/li[4]/a")));
        Ele1.click();

        // Click Create New Plan Button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='home-version-1']/div/section/div/div[1]/div[2]/a"))).click();

        // Fill Form
        driver.findElement(By.xpath("//*[@id='planName']")).sendKeys("Instagram My Plan Test");
        WebElement BM = driver.findElement(By.xpath("//*[@id='planForm1']/div/div[1]/div/div[2]/div/span[1]/span[1]/span"));
        BM.click();
        Thread.sleep(2000); // Extra Wait to Ensure Dropdown is Opened
        List<WebElement> brandManagerOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(text(),'Brand Manager')]")));
        if (!brandManagerOptions.isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(brandManagerOptions.get(0))).click();
            System.out.println("Brand Manager Selected Successfully");
        } else {
            System.out.println("Brand Manager Option Not Found");
        }

        System.out.println("Plan Created Successfully");

        // Browser Band Karne ka Code
        driver.quit();
        sc.close();
    }
}