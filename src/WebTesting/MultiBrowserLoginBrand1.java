package WebTesting;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class BrowserTest extends Thread {
    String browserName;
    String otp;

    BrowserTest(String browser, String otp) {
        this.browserName = browser;
        this.otp = otp;
    }

    public void run() {
        WebDriver driver = null;
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver = new ChromeDriver();
            } 
            else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                driver = new FirefoxDriver();
            } 
            else if (browserName.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
                driver = new EdgeDriver();
            } 
            else {
                System.out.println("Invalid Browser Name");
                return;
            }

            driver.manage().window().maximize();
            driver.get("https://adf.adfluencehub.com/login");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id=\"profile2-tab\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"loginemailmobile\"]")).sendKeys("vikasinf5@gmail.com");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"sendOTP-btn\"]")).click();
            Thread.sleep(3000);

            System.out.println(browserName + " - OTP: " + otp);

            driver.findElement(By.xpath("//*[@id=\"loginotp\"]")).sendKeys(otp);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"sendOTP-btn\"]")).click();

            System.out.println(browserName + " - Login Successfully ✅");
            Thread.sleep(3000);
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class MultiBrowserLoginBrand1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter OTP: ");
        String otp = sc.nextLine();

        BrowserTest chrome = new BrowserTest("chrome", otp);
        BrowserTest firefox = new BrowserTest("firefox", otp);
        BrowserTest edge = new BrowserTest("edge", otp);

        chrome.start();   // Chrome Start
        firefox.start();  // Firefox Start
        edge.start();     // Edge Start

        sc.close(); // Scanner Close
    }
}
