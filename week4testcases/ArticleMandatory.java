package week4testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ArticleMandatory {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launching URL
		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Switch to Frame
		driver.switchTo().frame("gsft_main");
		
		// Login
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		
		// Filter with Incidents
		driver.findElement(By.id("filter")).sendKeys("Knowledge");
		driver.findElement(By.xpath("//div[text()='My Knowledge Articles']")).click();
		
		// Switch to Frame and click on new button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		
		// Get Knowledge no
		String knowledgeNo = driver.findElement(By.id("sys_readonly.kb_knowledge.number")).getAttribute("value");
		
		// Update Description
		driver.findElement(By.id("sys_display.kb_knowledge.kb_knowledge_base")).sendKeys("IT", Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys("Dont Touch my Knowledge!!!!!!");
		
		// Click on Submit
		driver.findElement(By.id("sysverb_insert")).click();
		
		
		// Search for Knowledge no
		Select filter = new Select(
				driver.findElement(By.xpath("//span[@class='input-group-addon input-group-select']//select")));
		filter.selectByVisibleText("Number");
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys(knowledgeNo, Keys.ENTER);

		if (driver.findElement(By.xpath("//a[@class='linked formlink']")).isDisplayed()) {
			System.out.println("Knowledge is created");
		}
		System.out.println(knowledgeNo);
		

	}

}
