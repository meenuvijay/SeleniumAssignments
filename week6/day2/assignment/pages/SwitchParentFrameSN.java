package week6.day2.assignment.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;


import week6.day2.assignment.hooks.ProjectBase;

public class SwitchParentFrameSN extends ProjectBase{
	
	public ClickNewButtonSN switchParentFrame() {
		driver.findElement(By.xpath("//button[text()='New']")).click();
		return new ClickNewButtonSN();
	}
	
	public   SwitchParentFrameSN switchHomeFrame() {
		driver.switchTo().frame("gsft_main");
		return this;
	}
	
	
	public   EnterSearch switchEnterSearch() {
		
		return new EnterSearch();
	}

	
	

}
