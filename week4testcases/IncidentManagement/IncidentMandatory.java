package week4testcases.IncidentManagement;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class IncidentMandatory {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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

		//Click on Submit
		
		driver.findElement(By.id("sysverb_insert")).click();
		
		String errmsg = driver.findElement(By.xpath("//span[@class='outputmsg_text']")).getText();
		System.out.println(errmsg);
		
		
	}

}
