package week6.day2.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import week6.day2.assignment.pages.CreateArticleSN;

//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;


import week6.day2.assignment.hooks.ProjectBase;


public class ReturnPageSN extends ProjectBase{
	
   public  void verifyCallerUpdate() {
	    
		if(driver.findElement(By.xpath("//tbody[@class='list2_body']//td[text()='(098) 765-4321']")).isDisplayed()) {
			System.out.println("Caller is Updated");
		}else
		{
			System.out.println("Issue with Updation");
		}
		
	}
   
   
	public  void verifyCallerDelete() {

		System.out.println("Caller is Deleted");
		
	}
	
	public  void verifyCreateArticle() throws InterruptedException {
		
		  WebElement ele =
		  driver.findElement(By.xpath("//input[@placeholder='Search']")); ele.click();
		  ele.sendKeys(number); ele.sendKeys(Keys.ENTER);
		  
		  Thread.sleep(1000);
		  
		  
		  String number1 =
		  driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		  Thread.sleep(1000);
		 
		System.out.println(number);
		
		  if (number.equals(number1)) {
		  System.out.println("Knowledge is created successfully"); } else {
		  System.out.println("Knowledge is not created successfully"); }
		 
	
	}
	
	
	 
		public  void verifyUpateArticle() {

			System.out.println("Article Updated");
			
			WebElement searchOptNum = driver
					.findElement(By.cssSelector("span#kb_knowledge_hide_search>div>div>span>span>select"));
			new Select(searchOptNum).selectByIndex(1);

			WebElement eleSearch = driver.findElement(By.xpath("//input[@placeholder='Search']"));
			eleSearch.click();
			eleSearch.sendKeys(number);
			eleSearch.sendKeys(Keys.ENTER);
			
		}
	

}
