package week6.day2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import week6day2.hooks.TestNghooks;

public class Login extends TestNghooks {
	
	
	public Login typeUsername(String username) {
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		return this;
	}
	
	
	
	public Login typePassword(String password) {
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}
	
	public Home typePasswordAndEnter() {
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("crmsfa", Keys.ENTER);
		return  new Home();
	}
	

	public  Home clickLogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		return new Home();
	}
	
	
	public Login clickLoginForFailure()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		return this;
	}

	

}
