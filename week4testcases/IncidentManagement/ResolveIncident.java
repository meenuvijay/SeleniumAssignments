package week4testcases.IncidentManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResolveIncident {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("INC0010713" + Keys.ENTER);

		// click on incident no
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		// State as Resolved
		WebElement incstate = driver.findElement(By.id("incident.state"));
		Select incstate1 = new Select(incstate);
		incstate1.selectByIndex(3);
		Thread.sleep(1000);

		// Click on Resolution information
		driver.findElement(By.xpath("//span[text()='Resolution Information']")).click();

		// Enter Resolution information - Knowledge
		WebElement chkknowledge = driver.findElement(By.id("label.ni.incident.knowledge"));

		if(!chkknowledge.isSelected())
		{
			chkknowledge.click();
		}
		Thread.sleep(1000);
		
		// Resolution Code
		WebElement rescode1 = driver.findElement(By.id("incident.close_code"));
		Select rescode = new Select(rescode1);
		rescode.selectByIndex(3);
		Thread.sleep(1000);

		// Resolution Notes
		driver.findElement(By.id("incident.close_notes")).sendKeys("Dont touch this");

	

		// Resolved by
		driver.findElement(By.id("lookup.incident.resolved_by")).click();

		Set<String> allwindowhandles = driver.getWindowHandles();
		System.out.println(allwindowhandles);

		List<String> lstwindows = new ArrayList<String>(allwindowhandles);
		String secwinhandle = lstwindows.get(1);
		driver.switchTo().window(secwinhandle);
		System.out.println(driver.getTitle());

		// Click on first link
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();

		String firstwinhandle = lstwindows.get(0);
		driver.switchTo().window(firstwinhandle);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.switchTo().frame("gsft_main");
		
		// Resolved on
				driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();
				Thread.sleep(1000);
				//driver.findElement(By.xpath("//a[@id='GwtDateTimePicker_day17']")).click();
				//Thread.sleep(1000);
			//	driver.findElement(By.xpath("//td[@id='GwtDateTimePicker_debug']/following-sibling::td[1]")).click();
			//	Thread.sleep(1000);
		
		// Click on bottom update button

		driver.findElement(By.id("sysverb_update_bottom")).click();
		
		//Verify the state
		
		// Click on the incident no
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			
		
		
		WebElement st_res = driver.findElement(By.id("incident.state"));
		String state_res =  st_res.getText();
		
		if (state_res.contains("Resolved")) {
			System.out.println("The incident is resolved");
		} else {
			System.out.println("The incident is not resolved");
		}

	}

}
