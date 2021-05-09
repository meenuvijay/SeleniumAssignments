package week2.assignments;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();
		
	    
	    
	    List<WebElement> progress = driver.findElements(By.xpath("//table[@class='display']//td[2]"));
	    System.out.println( progress.size());
	    
	    for (int i=0 ; i< progress.size();i++)
	    {
	    	System.out.println(progress.get(i).getText());
	    }
	}
	
	

}
