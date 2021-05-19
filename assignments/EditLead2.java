package week5day2.assignments;



import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead2 extends BaseClassLead{

	@Test(dataProvider = "TestData")
	public  void editlead2(String UpdateCompanyName, String FirstName) throws InterruptedException {
		

	
		// Click on the Leads

		driver.findElement(By.linkText("Leads")).click();

		// Click on the Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter the firstname for search

		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(FirstName);

		// Click on Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// Capture the leadid
		String leadidcap = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();

		// Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(2000);

		// 11 Verify title of the page
		String pagetitle = driver.getTitle();
		System.out.println("The Page is:" + pagetitle);

		if (pagetitle.contains("View"))
			System.out.println("The Page is View");
		else
			System.out.println("The Page is not  View Page");

		// Click on Edit

		driver.findElement(By.linkText("Edit")).click();

		// update the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(UpdateCompanyName);

		// Click on the Update button
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		Thread.sleep(2000);

		// company 2 name in View page
		String compname2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String comp2 = compname2.replaceAll("[^a-zA-Z]", "");
		System.out.println("Company Name2-" + comp2);
		Thread.sleep(2000);

		// Click on the Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter the lead id
		driver.findElement(By.name("id")).sendKeys(leadidcap);

		// Click on Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(2000);

		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		;
		String comp1 = companyName.replaceAll("[^a-zA-Z]", "");
		System.out.println("Company Name1-" + comp1);

		// Verifying the company names are same
		if (comp1.equals(comp2)) {
			System.out.println("Both the Company Name are Same");
		} else {
			System.out.println("Both the Company Name are Not Same");
		}
	}
		@DataProvider(name="TestData")
		public Object[][] fetchData() throws InvalidFormatException, IOException{
			
			String[][] data = ReadExcelDataProvider.readExcelData("Edit Lead");
			return data;
	

	}

	
}
