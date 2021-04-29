package week2.assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		**No need to write Selenium script - Just find these elements in the DOM using only XPaths
		
		Try all the xpaths that you've learnt (basic, text-based, axes..)
		1. Launch the URL
		
		2. Enter the username based on its label
		
		//input[@id ='username']
		
		3. Enter the password based on its label
		
		 //input[@id ='password']
		
		4. Click Login
		//input[@class='decorativeSubmit']
		 
		5. Click on CRMSFA link
		
		
		
		6. Click on Leads link
		
		7. Click on Merge Leads link
		
		8. Click the first img icon
		
		9. Select the first resulting lead
		
		10. Click the second img icon
		
		11. Select the second resulting lead
		
		12. Click on Merge Lead (submit) button
		
		13. Get the company name text based on its label*/
		

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		// Launch the URL

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//Enter the username based on its label
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		
		//Enter the password based on its label
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		//Click on Login
		
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		// Click on CRMSFA link
		
		driver.findElement(By.xpath("//a[contains(@href,'/crmsfa')]")).click();
		
		//Click on Leads link
		
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/leadsMain']")).click();
		
		
		//Click on Merge Leads 
		
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeLeadsForm']")).click();
		
		//Click the first img icon
		
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();

		
		//Click on first result
		//driver.findElement(By.xpath("//div[@class ='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.xpath("(//div[@class ='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		
		//Select the second resulting lead
		//driver.findElement(By.xpath("(//div[@class ='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.findElement(By.xpath("(//div[@class ='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();

		
		//Click on Merge Lead (submit) button
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		
		
		//Get the company name text based on its label
		driver.findElement(By.xpath("//span[@id ='viewLead_companyName_sp']"));
	}

}
