package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.GeckoDriverInfo;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadForm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps");

		driver.manage().window().maximize();

		// Enter the username

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		// Enter the Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on the CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// String text = driver.findElement(By.tagName("h2")).getText();
		// System.out.print(text);

		// Click on the Create Lead
		driver.findElement(By.linkText("Create Lead")).click();

		// Enter the Company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Company_Test");

		// Enter the FirstName
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Test_Firstname");

		// Enter the LastName
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Test_Lastname");

		// Enter the Source
		WebElement eledropdown1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd1 = new Select(eledropdown1);
		dd1.selectByVisibleText("Partner");

		// Enter Market campaign
		WebElement camp1 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select camp = new Select(camp1);
		camp.selectByVisibleText("Car and Driver");

		// Enter the FirstName Local
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Test_FirstName_Local");

		// Enter the LastName Local
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Test_LastName");

		// Enter the Salutation
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Test_Mrs");

		// Enter the BirthDate
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("05/12/2015");

		// Enter the Title
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Test_Mrs");

		// Enter the Department
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Test_Dept");

		// Enter the preferred currency
		WebElement currency1 = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select curr = new Select(currency1);
		curr.selectByVisibleText("UYU - Uruguay");

		// Enter the Annual Revenue
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("1000000");

		// Enter Industry
		WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select industry1 = new Select(industry);
		industry1.selectByVisibleText("Aerospace");

		// Enter Ownership
		WebElement owner = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select owner1 = new Select(owner);
		owner1.selectByVisibleText("Partnership");

		// Enter the Number of Employees
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("100");

		// Enter the SIC code
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("123456");

		// Enter the TickerSymbol
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("123");

		// Enter the Description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test _ This is a test Description");

		// Enter the Important Note
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Test_important Note");

		/* Contact info */
		// Enter the Country code
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("1");

		// Enter the Area Code
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("+91");

		// Enter the Phone extension
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("123");

		// Enter the Primary Phone no
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("+91 123 0000");

		// Enter the Person to Ask for
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Test_important Note");

		// Enter the Email
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test@gmail.com");

		// Enter the Primary URL
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.testleaf.com");

		/* Primary Address */

		// Enter the Primary Name
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Test_To_Name");

		// Enter the Attn Name
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Test_Attn_Name");

		// Enter the Primary Name
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Test_To_Name");

		// Enter the Address1
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Test_Add1");

		// Enter the Address2
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Test_Add2");

		// Enter the City
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Test_City");

		// Enter the State/Province
		driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")).sendKeys("Chicago");

		// Enter the zipcode
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("2146");

		// Enter the zipcode extn
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("012");

		// Enter State
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state1 = new Select(state);
		state1.selectByVisibleText("Iowa");

		// Enter country
		WebElement country = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select country1 = new Select(country);
		country1.selectByVisibleText("India");

		// Click on Create Lead
		driver.findElement(By.className("smallSubmit")).click();
		
		
	String text = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.print(text);
		

		
				   driver.findElement(By.linkText("Duplicate Lead")).click();
				   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				   
					// Change the Company Name
				   driver.findElement(By.id("createLeadForm_companyName")).clear();
					driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Macquire");
					driver.findElement(By.className("smallSubmit")).click();
					
					
						String companyview = driver.findElement(By.id("viewLead_companyName_sp")).getText();	
						String compv1 = companyview.replaceAll("[0-9]", "").replaceAll("[()]", "");
						
						System.out.print("one" + compv1);
			
					
						 driver.findElement(By.linkText("Duplicate Lead")).click();
	            	
						 Thread.sleep(3000);
	                String companydup = driver.findElement(By.id("viewLead_companyName_sp")).getText();	
	               
			        String compdup1 = companydup.replaceAll("[0-9]", "").replaceAll("[()]", "");
			       
			        System.out.println("two" + compdup1);
			        
			     
		
		if(compv1.contentEquals(compdup1))
		{
			System.out.println("Both company name is same");
		}
		}
		
	

	}


