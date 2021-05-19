package week5day2.groups;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateLead2 extends BaseClassLead {

	
	@Test(dataProvider = "TestData" ,invocationCount = 3)
	
	
	//@Test(groups="Smoke")
	public  void createlead2(String CompanyName, String FirstName, String LastName) throws InterruptedException {
		// TODO Auto-generated method stub

		
	

		// Click on the Create Lead
		driver.findElement(By.linkText("Create Lead")).click();

		// Enter the Company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(CompanyName);

		// Enter the FirstName
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FirstName);

		// Enter the LastName
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LastName);


		// Click on Create Lead
		driver.findElement(By.className("smallSubmit")).click();
		
		

		}
	@DataProvider(name="TestData")
	public Object[][] fetchData(){
		
		String[][] data = new String [3][3];
		data[0][0]="Meena_TL";
		data[0][1]="Vijay_TL";
		data[0][2]="MV_Company";
		
		data[1][0]="Meena_TL1";
		data[1][1]="Vijay_TL1";
		data[1][2]="MV_Company1";
		
		data[2][0]="Meena_TL2";
		data[2][1]="Vijay_TL2";
		data[2][2]="MV_Company2";
		
		
		return data;
	
	}
}

		
	

	

