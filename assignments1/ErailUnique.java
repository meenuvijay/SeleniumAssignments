package week3day2.assignments1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// navigate to url
		driver.get("https://erail.in/");

		// maximize the window
		driver.manage().window().maximize();

		Thread.sleep(2000);

		// Enter the StationFrom
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("SCT" + Keys.ENTER);
		driver.findElement(By.id("txtStationFrom")).click();

		Thread.sleep(2000);
		// Enter the ToStation
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MAS" + Keys.ENTER);
		driver.findElement(By.id("txtStationFrom")).click();

		Thread.sleep(2000);

		// Uncheck the check box - sort on date
		driver.findElement(By.id("chkSelectDateOnly")).click();

		LinkedHashSet<String> set1 = new LinkedHashSet<String>();

		// Create the list using the Train Table listed

		List<WebElement> lsttrain = driver
				.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//td[2]"));

		// Create an Array
		List<String> strings = new ArrayList<String>();

		// Looping through the Webelement list

		for (WebElement i : lsttrain) {
			strings.add(i.getText());

		}
		
		System.out.println("The Size of the Train Array List " + strings.size());
		System.out.println("The Sorted order of Train Name" + strings);
		
		// Adding the trains to the new Set

		for (String j : strings) {
			set1.add(j);

		}

		for (String j : set1)
			System.out.println(j);

		System.out.println("The Size of the Train Set " + set1.size());

	}
}
