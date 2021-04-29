package week2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * http://leaftaps.com/opentaps/control/main
		 * 
		 * 1 Launch the browser 2 Enter the username 3 Enter the password 4 Click Login
		 * 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8 Click on Email 9
		 * Enter Email 10 Click find leads button 11 Capture name of First Resulting
		 * lead 12 Click First Resulting lead 13 Click Duplicate Lead 14 Verify the
		 * title as 'Duplicate Lead' 15 Click Create Lead 16 Confirm the duplicated lead
		 * name is same as captured name 17 Close the browser (Do not log out)
		 * 
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
		driver.findElement(By.xpath("//span[text()='Email']")).click();

		// Enter the Email address
		driver.findElement(By.name("emailAddress")).sendKeys("test@gmail.com");

		// Click on Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String comp1 = companyName.replaceAll("[^a-zA-Z]", "");
		System.out.println("Company Name-" + comp1);

		// Click on Duplicate in View Page

		driver.findElement(By.linkText("Duplicate Lead")).click();

		String pagetitle = driver.getTitle();

		if (pagetitle.contains("Duplicate Lead")) {
			System.out.println("The Page is Duplicate Lead");

		} else {
			System.out.println("The Page is not  Duplicate Lead");
		}

		// Click on Create Lead
		driver.findElement(By.className("smallSubmit")).click();

		// company 2 name in View page
		String compname2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String comp2 = compname2.replaceAll("[^a-zA-Z]", "");
		System.out.println("Company Name-" + comp2);

		// Verifying the company names are same
		if (comp1.equals(comp2)) {
			System.out.println("Both the Company Name are Same");
		} else {
			System.out.println("Both the Company Name are Not  Same");
		}
		// driver.quit();
	}

}
