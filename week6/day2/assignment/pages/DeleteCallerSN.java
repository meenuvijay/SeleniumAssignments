package week6.day2.assignment.pages;

import org.openqa.selenium.By;

import week6.day2.assignment.hooks.ProjectBase;

public class DeleteCallerSN extends ProjectBase{
	

	
	public ReturnPageSN clickDelete() {
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		return new ReturnPageSN() ;
	}
	
	

}
