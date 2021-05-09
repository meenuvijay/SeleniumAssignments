package Week4.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		
		//Pseudo Code
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		 
		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		// Click on Widget of From Contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		
		Set <String> allwindowhandles = driver.getWindowHandles();
		System.out.println(allwindowhandles);

		
		List<String> lstwindows = new ArrayList<String>(allwindowhandles);
		String secwinhandle = lstwindows.get(1);
		driver.switchTo().window(secwinhandle);
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		
		//Move the Control to the First Page
		driver.switchTo().window(lstwindows.get(0));
		
		// Click on Widget of To Contact
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		Thread.sleep(2000);
		
		// Switch to Second Window
		allwindowhandles = driver.getWindowHandles();
		lstwindows = new ArrayList<String>(allwindowhandles);
		driver.switchTo().window(lstwindows.get(1));
		
		 //  Click on Second Resulting Contact
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/following::table/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		Thread.sleep(2000);
		
		//Move the Control to the First Page
		driver.switchTo().window(lstwindows.get(0));
		
		//Click on Merge button using Xpath Locator
		driver.findElement(By.className("buttonDangerous")).click();
		Thread.sleep(2000);
		
		// 	switch to Alert
		Alert alert = driver.switchTo().alert();
		
		// 	Click Ok button in Alert
		alert.accept();
 
		// Verify the title of the page
		String title = driver.getTitle();
		System.out.println("The title of the page is : " + title);
		 
		driver.close();
		
	}
}
