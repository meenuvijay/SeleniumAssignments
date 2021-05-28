package week6.day2.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import week6.day2.assignment.hooks.ProjectBase;


public class HomePageSN extends ProjectBase{
	
	public MyHomePageSN verifyWelcomeMsg (){
		
		 WebElement navsideBar =  driver.findElement(By.xpath("//nav[@class='navpage-nav']"));
			String title = driver.getTitle();
			System.out.println(title);
			
			boolean navdisplay = navsideBar.isDisplayed();
			System.out.println(navdisplay);
			
			if(navdisplay)
			{
				if(title.contains("ServiceNow"))
				{
					System.out.println("Login Successful");
				}else
				{
					System.out.println("Login not Successful");
				}
			}
			return new MyHomePageSN();
	}
	
  
	public LoginServiceNow clickLogout() {
		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.linkText("Logout")).click();
		return new LoginServiceNow();
	}
	

}
