package week5day1;



import org.openqa.selenium.By;


import org.testng.annotations.Test;



public class DuplicateLead extends BaseClassLead {

	@Test
	public  void duplicatelead() throws InterruptedException {
		

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
		
	}

}
