package Week4.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.navigate().to("https://www.nykaa.com/");

		Actions builder = new Actions(driver);

		// Click on Brands
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).build().perform();
		Thread.sleep(1000);

		// Click on Popular
		WebElement popular = driver.findElement(By.xpath("//a[text()=\"Popular\"]"));
		builder.moveToElement(brands).moveToElement(popular).click().perform();

		// Click on L'Oreal Paris
		WebElement loreal = driver.findElement(By.xpath("//img[contains(@src,'lorealparis.png')]"));
		builder.moveToElement(brands).moveToElement(popular).moveToElement(loreal).click().perform();

		// Code for switching the window handle

		String title = driver.getTitle();
		System.out.println(title);

		Set<String> allwindowhandles = driver.getWindowHandles();
		System.out.println(allwindowhandles);

		List<String> lstwindows = new ArrayList<String>(allwindowhandles);
		System.out.println(lstwindows);

		// move to the control to loreal window
		String secwinhandle = lstwindows.get(1);
		driver.switchTo().window(secwinhandle);
		System.out.println(driver.getTitle());

		// Click on Sort by
		WebElement lorealsort = driver.findElement(By.xpath("//div[@class='sort-btn clearfix']"));
		builder.moveToElement(lorealsort).click().perform();
		Thread.sleep(1000);

		// Click on Customer Top Rated
		WebElement custrated = driver.findElement(By.xpath("//span[text()='customer top rated']"));
		builder.moveToElement(lorealsort).moveToElement(custrated).click().perform();
		Thread.sleep(1000);

		// Click on Category

		driver.findElement(By.xpath("//div[@class='filter-sidebar__filter-title pull-left']")).click();

		Thread.sleep(1000);

		// Click on shampoo
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(1000);
		String shampoo = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']")).getText();

		if (shampoo.contains("Shampoo")) {
			System.out.println("The Filter is Shampoo");
		} else {
			System.out.println("The Filter is not Shampoo");
		}

		// Click on L'oreal Protect Shampoo

		driver.findElement(By.xpath(
				"//div[@id='listingContainer']/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[10]/div[1]/a[1]/div[1]/div[2]/div[1]/h2[1]/span[1]"))
				.click();

		// move to the control to loreal shampoo window
		allwindowhandles = driver.getWindowHandles();
		lstwindows = new ArrayList<String>(allwindowhandles);
		driver.switchTo().window(lstwindows.get(2));
		System.out.println(driver.getTitle());

		// click on 175ml and click on Add to bag
		driver.findElement(By.xpath("//span[text()='175ml']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();
		Thread.sleep(2000);

		// click on shopping bag
		driver.findElement(By.className("AddBagIcon")).click();
		Thread.sleep(2000);

		// click on Grand Total
		String GrantTotal = driver.findElement(By.xpath("//div[text()='Grand Total:']")).getText();
		GrantTotal = GrantTotal.replaceAll("\\D", "").trim();

		int GrantTotal1 = Integer.parseInt(GrantTotal);
		System.out.println("Grandtotal on shopping page: " + GrantTotal1);
		Thread.sleep(2000);

		// Click on Proceed
		driver.findElement(By.xpath("//button[contains(@class,'btn full')]")).click();
		Thread.sleep(5000);

		// continue as guest
		driver.findElement(By.xpath("(//button[contains(@class,'btn full')])[2]")).click();
		Thread.sleep(5000);

		// Checking the Grand Total
		String GT = driver.findElement(By.xpath("//div[contains(@class,'payment-details-tbl grand-total-cell')]"))
				.getText();
		GT = GT.replaceAll("\\D", "").trim();
		int GTintfinal = Integer.parseInt(GT);
		System.out.println(GTintfinal);

		if (GTintfinal == GrantTotal1) {
			System.out.println("The Total is Same");
		} else {
			System.out.println("The Total is Not Same");
		}

		driver.close();
	}

}
