package week3day2.assignments1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MapInSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		
		 */
		
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// navigate to url
		driver.get("https://erail.in/");

		// maximize the window
		driver.manage().window().maximize();

		Thread.sleep(2000);

		// Enter the StationFrom
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("UD" + Keys.ENTER);
		driver.findElement(By.id("txtStationFrom")).click();

		Thread.sleep(2000);
		// Enter the ToStation
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("BNCE" + Keys.ENTER);
		driver.findElement(By.id("txtStationFrom")).click();

		Thread.sleep(2000);

		// Uncheck the check box - sort on date
		driver.findElement(By.id("chkSelectDateOnly")).click();

		Map<String,String> map = new HashMap<String, String> (); 
		
		// Create the list using the Train listed
		List<WebElement> lsttrain = driver
				.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']"));
		
	    
	    //Print data from each row
	    for (WebElement row : lsttrain) {
	        List<WebElement> cols = row.findElements(By.tagName("td"));
	        for (WebElement col : cols) {
	        	if (col.getText().startsWith("S")) {
	          //  System.out.print(col.getText() + "\t");
	        		map.put(col.getText(), col.getText());
	        }
	        }
	        System.out.println("\n");
	       
	    }
	    
	    System.out.println(map.values());
	}

}
