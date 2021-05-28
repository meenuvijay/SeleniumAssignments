package week6.day2.pages;
import org.openqa.selenium.By;

import week6day2.hooks.TestNghooks;

public class MyHome extends TestNghooks{
	
	public  MyHome welcomemsg()
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
		return new MyHome();
	}

	public Login clickLogout()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		
		return new Login();
	}
	
	public  LeadsTab clickLeadTab()
	{
		driver.findElement(By.linkText("Leads")).click();
		return new LeadsTab();
	}
}
