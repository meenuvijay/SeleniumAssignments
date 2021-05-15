package week4testcases.QueueEntry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_QueueEntry {

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

		// Click on New button
		driver.findElement(By.id("sysverb_new")).click();

		// Click on Chat_queue_entry
		driver.findElement(By.linkText("Chat_queue_entry")).click();

		// Get the Queue Entry No
		String chatQno = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value");
		System.out.println(chatQno);

		// Enter the short desc

		driver.findElement(By.id("chat_queue_entry.short_description")).sendKeys("Dont Touch My Work!!!!!!!!!!!!");

		// Enter the work notes
		driver.findElement(By.id("chat_queue_entry.work_notes")).sendKeys("Dont Touch My Work!!!!!!!!!!!!");

		System.out.println("The Chat Queue Entry is Created Successfully");
		Thread.sleep(1000);
		driver.findElement(By.id("sysverb_insert")).click();

	}

}
