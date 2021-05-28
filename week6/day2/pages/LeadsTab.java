package week6.day2.pages;

import org.openqa.selenium.By;

import week6day2.hooks.TestNghooks;

public class LeadsTab extends TestNghooks {
	
	

	
	public  CreateLead clickCreateLead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLead();
	}
	

}
