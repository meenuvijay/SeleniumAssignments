package week4testcases.IncidentManagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Login
		driver.switchTo().frame("gsft_main");

		// Enter the username and password

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");

		// click on Login button
		driver.findElement(By.id("sysverb_login")).click();

		// Click on Filter Navigator and Enter Incidents
		driver.findElement(By.id("filter")).click();

		// Click on Open
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(1000);

		driver.switchTo().frame("gsft_main");

		// Search by incident no
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select forTextNum1 = new Select(forTextNum);
		forTextNum1.selectByIndex(1);
		Thread.sleep(1000);
		
		
		// Enter the value
		// driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("INC0010822" + Keys.ENTER);
		Thread.sleep(1000);

		// click on incident no
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		//Click on Delete button 
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		
		//Click on the confirmation Delete
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		
		/*
		 * Thread.sleep(1000); WebElement forTextNum2 = driver.findElement(By.
		 * xpath("//select[@class='form-control default-focus-outline']")); Select
		 * forTextNum3 = new Select(forTextNum2); forTextNum3.selectByIndex(1);
		 * Thread.sleep(1000);
		 * 
		 * //Search for incident id
		 * driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(
		 * "INC0010757"+ Keys.ENTER); Thread.sleep(1000);
		 */
		
		//No records to display
		String noRecordsTo = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		
		if(noRecordsTo.contains("No records to display"))
		{
			System.out.println("The incident is deleted successfully");
		}
		else
		{
			System.out.println("There is an issue with Delete Incident");
		}
	}

}
