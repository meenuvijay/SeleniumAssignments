package week6.day2.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import week6.day2.assignment.hooks.ProjectBase;


public class MyHomePageSN extends ProjectBase{
	
	public SwitchParentFrameSN typeFilter (String navpage) throws InterruptedException{
		
		WebElement filternav;
		filternav = driver.findElement(By.id("filter"));
		filternav.sendKeys(navpage);
		filternav.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='" + navpage + "']")).click();
		return new SwitchParentFrameSN();
       
		}
	
	
public SwitchParentFrameSN typeSubFilter (String subnavpage, String navpage) throws InterruptedException{
	
		WebElement filternav;
		filternav = driver.findElement(By.id("filter"));
		filternav.sendKeys(navpage);
		filternav.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='" + subnavpage + "']")).click();
		return new SwitchParentFrameSN();
       
		}

	
  

}
