package week5day2.assignments;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead3 extends BaseClassLead{
	
	
	
	//@Test(groups="Smoke")
	
	@Test(dataProvider = "TestData", timeOut=6000)
	public void createLead3(String companyName, String firstName, String lastName) throws InterruptedException {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.name("submitButton")).click();
		
	}
	
	@DataProvider(name="TestData", indices= {0})
	public Object[][] fetchData() throws InvalidFormatException, IOException{
		
		String[][] data = ReadExcelDataProvider.readExcelData("Create Lead");
		return data;
		
	}
}

