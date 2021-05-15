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

public class AssignTheIncident {

	public static void main(String[] args) throws InterruptedException {
		// Incident_TC_TC003

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

		// Click on Assignment Group
		driver.findElement(By.xpath("//button[@data-for='sys_display.incident.assignment_group']//span[1]")).click();

		// Group select software group
		Set<String> allwindowhandles = driver.getWindowHandles();
		System.out.println(allwindowhandles);

		List<String> lstwindows = new ArrayList<String>(allwindowhandles);
		String secwinhandle = lstwindows.get(1);
		driver.switchTo().window(secwinhandle);
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Software");
		driver.findElement(By.xpath("//td[contains(@class,'list_decoration_cell col-small')]/following-sibling::td"))
				.click();
		String firstwinhandle = lstwindows.get(0);
		driver.switchTo().window(firstwinhandle);
		System.out.println(driver.getTitle());
		Thread.sleep(1000);

		driver.switchTo().frame("gsft_main");

		// update work notes

		driver.findElement(By.id("activity-stream-work_notes-textarea")).sendKeys("Dont Touch this incident no!!!!!");

		// String worknotes =
		// driver.findElement(By.id("activity-stream-work_notes-textarea")).getText();

		// Click on bottom update button

		driver.findElement(By.id("sysverb_update_bottom")).click();

		// Click on the incident no
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		

		// Verify the Assignment group
		WebElement sysdisplay1 = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']"));
		String sysdisplay =  sysdisplay1.getAttribute("value");
		;
		System.out.println(sysdisplay);
		Thread.sleep(1000);

		if (sysdisplay.contains("Software")) {
			System.out.println("Assignment group is verified");
		} else {
			System.out.println("Assignment group not as expected");
		}

	}

}
