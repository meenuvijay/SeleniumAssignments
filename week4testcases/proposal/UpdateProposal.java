package week4testcases.proposal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateProposal {

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

		// Click on Existing Proposal Number in Search

		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select forTextNum1 = new Select(forTextNum);
		forTextNum1.selectByIndex(1);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("STDCHG0001249" + Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(1000);

		// Click on category look up
		driver.findElement(By.id("lookup.std_change_proposal.category")).click();
		Set<String> allwindowhandles = driver.getWindowHandles();
		System.out.println(allwindowhandles);

		List<String> lstwindows = new ArrayList<String>(allwindowhandles);
		String secwinhandle = lstwindows.get(1);
		driver.switchTo().window(secwinhandle);
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//a[text()='Template Management']")).click();

		String firstwinhandle1 = lstwindows.get(0);
		driver.switchTo().window(firstwinhandle1);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.switchTo().frame("gsft_main");

	

		// Click on Change Request
		driver.findElement(By.xpath("//span[text()='Change Request values']")).click();
		Thread.sleep(1000);

		// Enter Justification
		driver.findElement(By.xpath("//td[@data-value='Justification']//textarea[1]"))
				.sendKeys("Dont touch my Proposal!!!!!!");

		// Enter Risk Analysis

		driver.findElement(By.xpath("//td[@data-value='Risk and impact analysis']//textarea[1]"))
				.sendKeys("!!!!!!Dont touch my Proposal!!!!!!");

		driver.findElement(By.xpath("//button[@class='icon-search btn btn-default filerTableAction']")).click();
		allwindowhandles = driver.getWindowHandles();
		System.out.println(allwindowhandles);

		lstwindows = new ArrayList<String>(allwindowhandles);
		String fourwinhandle = lstwindows.get(1);
		driver.switchTo().window(fourwinhandle);
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//a[text()='Change Management']")).click();

		firstwinhandle1 = lstwindows.get(0);
		driver.switchTo().window(firstwinhandle1);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.switchTo().frame("gsft_main");
		// State as InProgress
		WebElement propstate = driver.findElement(By.id("std_change_proposal.state"));
		Select propstate1 = new Select(propstate);
		propstate1.selectByVisibleText("In Progress");
		Thread.sleep(1000);

		driver.findElement(By.id("sysverb_update")).click();
		
		//Click on proposal no
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

	}

}
