package week5day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassLead {

	//Browser lauch -> Login

	ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod

	
	public void setup(String url, String username, String password) {
		WebDriverManager.chromedriver().setup();

		 driver = new ChromeDriver();

		driver.get(url);

		driver.manage().window().maximize();

		// Enter the username

		driver.findElement(By.id("username")).sendKeys(username);

		// Enter the Password
		driver.findElement(By.id("password")).sendKeys(password);

		// Click on login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on the CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	
	//(groups="common")
	@AfterMethod

	public void teardown() {
		
		// Logout
		driver.close();
	}

}
