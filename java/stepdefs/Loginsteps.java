package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginsteps {

	ChromeDriver driver;
	@Given ("Launch Chrome browser")
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
	public void typePassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@And("Click Login Button")
	public void clickLogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@Then("Verify Login is successful")
	public void isSuccess()
	{
		WebElement eleCrm = driver.findElement(By.linkText("CRM/SFA"));
		System.out.println(eleCrm.isDisplayed());
	}
	
	
	}
	

