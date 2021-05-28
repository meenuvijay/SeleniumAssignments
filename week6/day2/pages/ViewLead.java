package week6.day2.pages;
import org.openqa.selenium.By;

import week6day2.hooks.TestNghooks;

public class ViewLead extends TestNghooks{
	
	public  ViewLead welcomemsg()
	{
		String msgwelcome = driver.findElement(By.xpath("//h2[@text()='Welcome']")).getText();
		if(msgwelcome.contains("Welcome"))
		{
			System.out.println("Login successful");
		}
		else
		{
			System.out.println("Login Not successful");
		}
		return new ViewLead();
	}

	public Login clickLogout()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		
		return new Login();
	}
}
