package week3day2.assignments1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.navigate().to("https://www.myntra.com/");

		Actions builder = new Actions(driver);

		WebElement women = driver.findElement(By.xpath("//a[text()='Women']"));
		builder.moveToElement(women).build().perform();
		Thread.sleep(1000);

		// brand-more
		WebElement jCoat = driver.findElement(By.xpath("//a[text()='Jackets & Coats']"));
		builder.moveToElement(women).moveToElement(jCoat).click().perform();

		String jCoatTotal = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		jCoatTotal = jCoatTotal.replaceAll("\\D", "");
		System.out.println("The Total Jackets & Coats:" + jCoatTotal);

		String jTotal = driver.findElement(By.xpath("//label[text()='Jackets']")).getText();
		jTotal = jTotal.replaceAll("\\D", "");
		System.out.println("The  Jackets Count:" + jTotal);
		Thread.sleep(1000);

		String cTotal = driver.findElement(By.xpath("//label[text()='Coats']")).getText();
		cTotal = cTotal.replaceAll("\\D", "");
		System.out.println("The  Coats Count:" + cTotal);

		int SumTotal = Integer.parseInt(jTotal) + Integer.parseInt(cTotal);
		System.out.println("The  Total Count:" + SumTotal);

		driver.findElement(By.xpath("//div[@class='brand-more']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("MANGO");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();

		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();

		String brandMango = driver.findElement(By.xpath("(//div[@class='filter-summary-filter'])")).getText();

		if (brandMango.contains("MANGO")) {
			System.out.println("All the coats are MANGO brand");
		} else {
			System.out.println("Not belong to MANGO brand");
		}

		WebElement sortBy = driver.findElement(By.className("sort-sortBy"));
		WebElement betterDiscount = driver.findElement(By.xpath("//label[text()='Better Discount']"));
		builder.moveToElement(sortBy).moveToElement(betterDiscount).click().perform();
		Thread.sleep(2000);

		String discPrice = driver.findElement(By.xpath("(//span[(@class='product-discountedPrice')])")).getText();
		System.out.println("Price of the First Item" + discPrice);

		WebElement eleSize = driver.findElement(By.xpath("(//div[@class='product-price']//span)[2]"));
		builder.moveToElement(eleSize).build().perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[text()='wishlist'])[1]")).click();

	}

}
