package week2.assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;




public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		System.out.println("The title of the page:" );

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on the Contacts tab
		driver.findElement(By.linkText("Contacts")).click();

		// Click on the Create Contact
		driver.findElement(By.linkText("Create Contact")).click();


		// Enter the FirstName
		driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("Test_Firstname");

		// Enter the LastName
		driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("Test_Lastname");

		// Enter the FirstName Local
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys("Test_FirstName_Local");

		// Enter the LastName Local
		driver.findElement(By.xpath("//input[@name='lastNameLocal']")).sendKeys("Test_LastName");

		// Enter the Department
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("Test_Dept");

		// Enter the Description
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Test _ This is a test Description");

		// Enter the Important Note
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Test _ This is a test Description");
		
		// Enter the Email
		driver.findElement(By.xpath("//input[@name='primaryEmail']")).sendKeys("test@gmail.com");
		
		// Enter State
		WebElement state = driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
		Select state1 = new Select(state);
		state1.selectByVisibleText("Iowa");
		
		
		// Click on Create Contact
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		
		
		//Click on EDIT in View Page
		
		driver.findElement(By.linkText("Edit")).click();
		
	
		
		// update the Description
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();

		// update  the Important Note)
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).clear();
		
		// update  the Important Note)
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Test2222 _ This is a test Description");
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		 String title = driver.getTitle();
		 
		 System.out.println(title);
		
		
		
		//input[@value='Update']
		
		
		
	}

}
