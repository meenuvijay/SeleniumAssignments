package week4testcases.QueueEntry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateChatQuery {

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


		
		//Search and Click on the chat no link 
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("CHAT0010056" + Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(1000);
		
		//change Priority as moderate
		
		WebElement chatprior1 = driver.findElement(By.id("chat_queue_entry.priority"));
		Select chatprior = new Select(chatprior1);
		chatprior.selectByVisibleText("3 - Moderate");
		String priority= chatprior.getFirstSelectedOption().getText();
		System.out.println(priority);
		Thread.sleep(1000);
		
		// State as InProgress 

		WebElement chatstate1 = driver.findElement(By.id("chat_queue_entry.state"));
		Select chatstate = new Select(chatstate1);
		chatstate.selectByVisibleText("Work In Progress");
		String state= chatstate.getFirstSelectedOption().getText();
		System.out.println(state);
		Thread.sleep(1000);
		
		System.out.println("The Chat Queue Entry is Updated Successfully");
		Thread.sleep(1000);
		driver.findElement(By.id("sysverb_update")).click();
		
       String priority1=driver.findElement(By.xpath("(//td[@class='vt'])[2]")).getText();
		
		String state1=driver.findElement(By.xpath("(//td[@class='vt'])[3]")).getText();
		
		if(state.equals(state1))
		{
			System.out.println("State Equals");
		}
		else
		{
			System.out.println("State Not Equals");
		}


		if(priority.equals(priority1))
		{
			System.out.println("Priority Equals");
		}
		else
		{
			System.out.println("Priority Not Equals");
		}

		Thread.sleep(2000);


	}

}
