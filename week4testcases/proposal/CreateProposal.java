package week4testcases.proposal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProposal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Create new incident
		driver.switchTo().frame("gsft_main");

		// Enter the username and password

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");

		// click on Login button
		driver.findElement(By.id("sysverb_login")).click();

		// Click on Proposal -
		driver.findElement(By.id("filter")).sendKeys("Proposal" + Keys.ENTER);
		driver.findElement(By.xpath(" //div[text()='My Proposals']")).click();
		driver.switchTo().frame("gsft_main");

		// Click on New button
		driver.findElement(By.id("sysverb_new")).click();

		// GEt the proposal no

		WebElement propno1 = driver.findElement(By.id("std_change_proposal.number"));
		String propno = propno1.getAttribute("value");

		System.out.println("The Proposal no :" + propno);

		// Enter the Template desc

		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']"))
				.sendKeys("Dont touch my Proposal!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		// Click on Change Request
		driver.findElement(By.xpath("//span[text()='Change Request values']")).click();
		Thread.sleep(1000);
		// Enter Short Desc value
		driver.findElement(By.xpath("//input[@class='filerTableInput form-control']"))
				.sendKeys("Dont touch my Proposal!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		// click on submit
		driver.findElement(By.id("sysverb_insert")).click();

		// Verify the Proposal Number in Search
		
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select forTextNum1 = new Select(forTextNum);
		forTextNum1.selectByIndex(1);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(propno + Keys.ENTER);
		Thread.sleep(2000);
		WebElement propno11 = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		Thread.sleep(1000);
		String valSearch = propno11.getText();

		if (valSearch.equals(propno)) {
			System.out.println("The Propasal no is same" + valSearch);
		} else {
			System.out.println("The Propasal no is not same");
		}

	}

}
