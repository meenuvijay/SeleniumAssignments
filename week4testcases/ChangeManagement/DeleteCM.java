package week4testcases.ChangeManagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
		//Login
		driver.get("https://dev103117.service-now.com/navpage.do");

		driver.switchTo().frame(0);

		driver.findElement(By.id("user_name")).sendKeys("admin");

		driver.findElement(By.id("user_password")).sendKeys("India@123");

		driver.findElement(By.id("sysverb_login")).click();

		Thread.sleep(2000);
		
		//Open existing Change
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("change", Keys.ENTER);

		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();

		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);

		WebElement search = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		search.sendKeys("CHG0000015", Keys.ENTER);
								
		Thread.sleep(3000);
		String firstCM = driver.findElement(By.xpath("(//td[@class='vt'])[1]/a")).getText();
		System.out.println(firstCM);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@class='vt'])[1]/a")).click();
		
		//Click on Delete
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		
		
		//Verify the deleted change request
		String text = "No records to display";
		String verifyDelete = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		// System.out.println(verifyDelete);

		if (verifyDelete.equalsIgnoreCase(text)) {
			System.out.println(firstCM  + " has been deleted");
			System.out.println(" ");
			System.out.println("Change Number Deleted ");
			driver.close();

		} else {
			System.out.println(firstCM + " hasn't been deleted");
			System.out.println(" ");
			
		}

	}

}
