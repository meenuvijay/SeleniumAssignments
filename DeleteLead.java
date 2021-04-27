package week2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * http://leaftaps.com/opentaps/control/main
		 * 
		 * Delete Lead: 1 Launch the browser 2 Enter the username 3 Enter the password 4
		 * Click Login 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8
		 * Click on Phone 9 Enter phone number 10 Click find leads button 11 Capture
		 * lead ID of First Resulting lead 12 Click First Resulting lead 13 Click Delete
		 * 14 Click Find leads 15 Enter captured lead ID 16 Click find leads button 17
		 * Verify message "No records to display" in the Lead List. This message
		 * confirms the successful deletion 18 Close the browser (Do not log out)
		 */

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();

		// Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		// Enter the Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on the CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on the Leads
		driver.findElement(By.linkText("Leads")).click();

		// Click on the Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Click on Email
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		// Enter the Email address
		driver.findElement(By.name("phoneNumber")).sendKeys("+91 123 0000");

		// Click on Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);
		List<WebElement> leadid = driver
				.findElements(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		Thread.sleep(2000);

		// Capture the leadid
		String leadidcap = leadid.get(0).getText();
		Thread.sleep(2000);
		leadid.get(0).click();

		// Click on Duplicate in View Page

		driver.findElement(By.linkText("Delete")).click();

		// String pagetitle = driver.getTitle();

		// Click on the Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter the lead id
		driver.findElement(By.name("id")).sendKeys(leadidcap);

		// Click on Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// No Records Found - Verification
		List<WebElement> leadi_del = driver.findElements(By.xpath("//div[text()='No records to display']"));
		int validmess = leadi_del.size();

		if (validmess == 0)

		{
			System.out.println("No Records Found - Verified");
		}
driver.quit();
	}

}
