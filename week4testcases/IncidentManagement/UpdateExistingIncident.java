package week4testcases.IncidentManagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateExistingIncident {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Incident_TC_TC002

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Login
		driver.switchTo().frame("gsft_main");

		// Enter the username and password

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");

		// click on Login button
		driver.findElement(By.id("sysverb_login")).click();

		// Click on Filter Navigator and Enter Incidents
		driver.findElement(By.id("filter")).sendKeys("Incidents" + Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		Thread.sleep(2000);

		// Search the Incident Number Value
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("INC0010181" + Keys.ENTER);

		// click on incident no
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		// Select urgency as High incident.state
		WebElement incidenturgency = driver.findElement(By.id("incident.urgency"));
		Select incopturgency = new Select(incidenturgency);
		incopturgency.selectByIndex(0);

		// Select State as High
		WebElement incstate = driver.findElement(By.id("incident.state"));
		Select incstate1 = new Select(incstate);
		incstate1.selectByIndex(1);

		// Click on Update
		driver.findElement(By.id("sysverb_update")).click();

		// Click on the incident no
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		// Get the Priority value
		//String incpriority = driver.findElement(By.xpath("(//span[@class='sn-widget-list-table-cell'])[3]")).getText();
		String incpriorvalue = driver.findElement(By.xpath("//span[text()='3 - Moderate']")).getText();

		// System.out.println(incpriority + incpriorvalue );
		// Get the State Value
		//String incistate1 = driver.findElement(By.xpath("//span[@class='sn-widget-list-table-cell']")).getText();
		String incistatevalue = driver.findElement(By.xpath("//span[@class='sn-widget-list-table-cell']//span"))
				.getText();

		// System.out.println(incistate1 + incistatevalue);

		// Verify the state and Priority
		if (incpriorvalue.contains("Moderate")) {
			System.out.println("The Priority is " + incpriorvalue);
		} else {
			System.out.println("The Priority is not as expected");
		}

		if (incistatevalue.contains("In Progress")) {
			System.out.println("The State  is as expected" + incistatevalue);
		} else {
			System.out.println("The State is not as expected");
		}

	}

}
