package week4testcases.caller;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		



				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				//Launching URL
				driver.get("https://dev103117.service-now.com");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//Switch to Frame
				driver.switchTo().frame("gsft_main");
				//Login
				driver.findElement(By.id("user_name")).sendKeys("admin");
				driver.findElement(By.id("user_password")).sendKeys("India@123");
				driver.findElement(By.id("sysverb_login")).click();
				//Filter with Incidents
				driver.findElement(By.id("filter")).sendKeys("Callers",Keys.ENTER);
				driver.findElement(By.xpath("//div[text()='Callers']")).click();
				driver.switchTo().frame("gsft_main");
				driver.findElement(By.xpath("//button[text()='New']")).click();
				driver.findElement(By.id("sys_user.first_name")).sendKeys("Meena");
				driver.findElement(By.id("sys_user.last_name")).sendKeys("Vijay");
				driver.findElement(By.id("sys_user.title")).sendKeys("Mrs");
				driver.findElement(By.id("sys_user.email")).sendKeys("callertest@gmail.com");
				driver.findElement(By.id("sys_user.phone")).sendKeys("1234567890");
				driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("1234567890");
				driver.findElement(By.id("sysverb_insert")).click();
				System.out.println("Caller is created");
				
			}

		

	}


