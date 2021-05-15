package week4testcases.QueueEntry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_QueueEntry {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Create new incident
		driver.switchTo().frame("gsft_main");

		// Enter the username and password

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");

		// click on Login button
		driver.findElement(By.id("sysverb_login")).click();

		// Click on My Work -
		driver.findElement(By.id("filter")).sendKeys("My Work" + Keys.ENTER);
		driver.findElement(By.xpath(" //div[text()='My Work']")).click();
		driver.switchTo().frame("gsft_main");

		//Select Number
		
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1);
		
		//Search and Click on the chat no link 
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("CHAT0010060" + Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("sysverb_delete")).click();

		driver.findElement(By.id("ok_button")).click();

		Thread.sleep(2000);
		
		System.out.println("Config Chat Query Deleted");

	}

}
