package week6.day2.assignment.pages;

import org.openqa.selenium.By;

import week6.day2.assignment.hooks.ProjectBase;

public class UpdateCallerDetailsSN extends ProjectBase{
	
	

	public UpdateCallerDetailsSN updatePhone(String phone) {
		
		driver.findElement(By.id("sys_user.phone")).clear();
		driver.findElement(By.id("sys_user.phone")).sendKeys("0987654321");
		return this;
	}

	
	public ReturnPageSN clickUpdate() {
		driver.findElement(By.id("sysverb_update")).click();
		return new ReturnPageSN() ;
	}
	
	

}
