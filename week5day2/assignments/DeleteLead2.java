package week5day2.assignments;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DeleteLead2 extends BaseClassLead {

	@Test(dataProvider = "TestData")
	public  void deletelead(String phoneno) throws InterruptedException {
		

		// Click on the Leads
		driver.findElement(By.linkText("Leads")).click();

		// Click on the Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Click on Email
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		// Enter the Email address
		driver.findElement(By.name("phoneNumber")).sendKeys(phoneno);

		// Click on Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// Capture the leadid
		String leadidcap = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(2000);

		// Click on Delete in View Page

		driver.findElement(By.linkText("Delete")).click();

		// String pagetitle = driver.getTitle();

		// Click on the Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter the lead id
		driver.findElement(By.name("id")).sendKeys(leadidcap);

		// Click on Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);

		// No Records Found - Verification
		String leadi_del = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();

		if (leadi_del.contains("No records to display"))

		{
			System.out.println("No Records Found - Verified");
		} else {
			System.out.println("Verified - Records found");
		}
	}
		@DataProvider(name="TestData")
		public Object[][] fetchData() throws InvalidFormatException, IOException{
			
			String[][] data = ReadExcelDataProvider.readExcelData("Duplicate Lead");
			return data;
	
	}

}
