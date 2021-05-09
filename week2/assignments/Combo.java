package week2.assignments;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Combo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		
		WebElement sel = driver.findElement(By.id("dropdown3"));
		Select dd1 = new Select(sel);
		int ind = dd1.getOptions().size();;
		dd1.selectByIndex(ind-2);

	}

}

