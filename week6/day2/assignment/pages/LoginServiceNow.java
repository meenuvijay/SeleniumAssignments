package week6.day2.assignment.pages;

import org.openqa.selenium.By;

import week6.day2.assignment.hooks.ProjectBase;


public class LoginServiceNow extends ProjectBase{
	
	
	
	public  LoginServiceNow clickMainFrame()
	{
		driver.switchTo().frame("gsft_main");
		return this;
	}
	
	public LoginServiceNow typeUsername(String username) {
		
		driver.findElement(By.id("user_name")).clear();
		driver.findElement(By.id("user_name")).sendKeys(username);
		return this;
	}
	
  
	public LoginServiceNow typePassword(String password) {
		
	driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys(password);
		return this;
	}
	
	
	public HomePageSN clickLogin()
	{
		driver.findElement(By.id("sysverb_login")).click();
		return new HomePageSN();
	}

}
