package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadStepdef {
	ChromeDriver driver;
	
	@Given("Launch the Chrome browser")
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	
	String leadid;
	
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
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	}
	

	@And("Click on Leads Tab")
	public void clickLeadsTab()
	{
		driver.findElement(By.linkText("Leads")).click();
	}
	
	@And("Click on Find Leads link")
	public void clickFindLeadslink()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	@And("Click on Phone tab")
	public void clickPhoneTab()
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	
	
	@And("Type phonenum as(.*)$")
	public void typePhoneno(String phonenum) {
		driver.findElement(By.name("phoneNumber")).sendKeys(phonenum);
	}
	
    @And("Click Find Leads Button")
	public void clickFindLeadsbutton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	    Thread.sleep(1000);
	}
	
		@And("Get LeadId")
	public void leadId(){

		leadid  = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).getText();
		System.out.println(leadid);

	}
	
	@And("Click on Firstlink")
	public void clickFirstLink()
	{
	
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
	}
	

	@And("Click on Delete button")
	public void clickDeletebutton()
	{
		driver.findElement(By.linkText("Delete")).click();
	}
	
	@And("Click on Find Leads again")
	public void clickFindLeadslink1()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	@And("Find by Leadid")
	public void typeLeadid()
	{
		driver.findElement(By.name("id")).sendKeys(leadid);
	}
	
	
	@And("Click Find Leads Button1")
	public void clickFindLeadsbutton1()
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	
	}
	
	@Then ("Verify Lead is deleted successfully")
	public void isDelete()
	{
		String delMsg = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();

		if (delMsg.contains("No records to display"))

		{
			System.out.println("No Records Found - Verified");
		} else {
			System.out.println("Verified - Records found");
		}
	}

	
	
}
