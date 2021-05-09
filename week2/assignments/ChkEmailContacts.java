package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChkEmailContacts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps");
		
		driver.manage().window().maximize();
		
		// FireFox launch
		//WebDriverManager.firefoxdriver().setup();
		//FirefoxDriver driver1 = new FirefoxDriver();
		//driver1.get("http://leaftaps.co'm/opentaps");
		//driver1.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Find Contacts")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("XYZ@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		driver.findElement(By.xpath("(//a[@href='/crmsfa/control/viewContact?partyId=10120'])[3]")).click();
		
		
	}

}
