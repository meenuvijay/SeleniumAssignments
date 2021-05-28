package week6.day2.pages;

import org.openqa.selenium.By;

import week6day2.hooks.TestNghooks;

public class CreateLead extends TestNghooks {
	
	

	public  CreateLead typeCompanyName(String compName) {
		
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);
		return this;
	}
	
	
	
   public  CreateLead typelastName(String lastName) {
		
	   driver.findElement(By.id("createLeadForm_lastName")).clear();
	   driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		return this;
	}
	
   public  CreateLead typefirstName(String firstName) {
	
	driver.findElement(By.id("createLeadForm_firstName")).clear();
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	return this;
}
   public   ViewLead clickCreateButton()
	{
	   driver.findElement(By.className("smallSubmit")).click();
		return new ViewLead();
	}


}
