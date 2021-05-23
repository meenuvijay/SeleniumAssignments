package stepdefs;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadMultiple {
	
		ChromeDriver driver;
		@Given ("Launch the Chrome browser")
		public void launchBrowser()
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
		}
		
		
		@When("Load URL {string}")
		public void loadUrl(String url)
		{
			driver.get(url);
		}
		

		@And("Type username as {string}")
		public void typeUsername(String username) {
			driver.findElement(By.id("username")).sendKeys(username);
		}
		
		
		
		@And("Type password as {string}")
		public void typePassword1(String password) {
			driver.findElement(By.id("password")).sendKeys(password);
		}
		
		@And("Click Login Button")
		public void clickLogin()
		{
			driver.findElement(By.className("decorativeSubmit")).click();
		}
		
		@Then("Verify Login is successful")
		public void isSuccess1()
		{
			driver.findElement(By.linkText("CRM/SFA")).click();;
			
		}
		
		@When("Click on CreateLead")
		
		public void clickCreat()
		{
		driver.findElement(By.linkText("Create Lead")).click();
		
		}
		@And("Type compname as (.*)$")
		public void typeCompname(String compname) {
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compname);
		}
		
		
		
		@And("Type fname as (.*)$")
		public void typeFname(String fname) {
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		}
		
		@And("Type lname as (.*)$")
		public void typeLname(String lname) {
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		}
		
		@And("Click Create Button")
		public void clickCreateLead()
		{
			driver.findElement(By.className("smallSubmit")).click();
		}
		
		@Then("Verify Create is successful")
		public void isSuccess()
		{
			String text = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
					
			System.out.print(text);
		}
		

}
