package week4testcases.IncidentManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewIncident {

	public static void main(String[] args) throws InterruptedException {
		// Incident_TC_TC001
		
		WebDriverManager.chromedriver().setup();
     	ChromeDriver driver = new ChromeDriver();
     	
		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		//Create new incident
		driver.switchTo().frame("gsft_main");
		
		//Enter the username and password

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		
		//click on Login button
		driver.findElement(By.id("sysverb_login")).click();
		
		
		//Click on Create New
		driver.findElement(By.id("filter")).sendKeys("Incident" + Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		
		//Get the Incident Number Value
		driver.switchTo().frame("gsft_main");
		Thread.sleep(1000);
		WebElement Incidentno = driver.findElement(By.id("incident.number"));
		String inci =  Incidentno.getAttribute("value");

		System.out.println("The Incident No:" +  inci);

		//Enter the Caller details

		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("Guest" + Keys.ARROW_DOWN +  Keys.ENTER);

		//Enter Short Desc using  suggestions
		driver.findElement(By.id("incident.short_description")).click();
		driver.findElement(By.xpath("//span[@class='icon icon-lightbulb']")).click();
		
		
		Set<String> allwindowhandles = driver.getWindowHandles();
		
		List<String> lstwindows = new ArrayList<String>(allwindowhandles);
		String popup = lstwindows.get(1);
		driver.switchTo().window(popup);
		System.out.println(driver.getTitle());
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Issue with a web page']")).click();
		
		driver.switchTo().window(lstwindows.get(0));
		Thread.sleep(1000);
		
	/*	driver.findElement(By.xpath("//button[@id='lookup.change_request.assigned_to']")).click();

		Set<String> winSet1 = driver.getWindowHandles();
		List<String> winList1 = new ArrayList<String>(winSet1);
		driver.switchTo().window(winList1.get(1));
		String title1 = driver.getTitle();
		System.out.println(title1);

		driver.findElement(By.xpath("//a[text()='ITIL User']")).click();

		driver.switchTo().window(winList.get(0));

		WebElement iframe3 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe3);*/
		
		//Click on Submit
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_insert")).click();
		
		//Verify the Incident Number in Search
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(inci + Keys.ENTER);
		Thread.sleep(2000);
		WebElement inc1 = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		Thread.sleep(1000);
		String valSearch = inc1.getText();
		
		
		if(valSearch.equals(inci))
		{
			System.out.println("The Incident no is same" + valSearch);
		}else
		{
			System.out.println("The Incident no is not same");
		}
		
		
		
		
	}

}
