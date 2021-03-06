package wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver implements Browser, Element, Select1, TargetLocator {

	public static RemoteWebDriver driver;

	@Override
	public boolean startApp(String browser, String url) {

		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else {
				System.err.println("This browser "+browser+" is not supported");
				return false;
			}

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("The browser "+browser+" launched successfully");
			return true;

		} catch (Exception e) {
			System.err.println("The browser "+browser+" could not be launched");
			return false;
		}

	}

	@Override
	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);
			System.out.println("WindowHandling: " + allWindowHandles.size());
			String windowHandle = lstWindowHandles.get(index);
			driver.switchTo().window(windowHandle);
			System.out.println("The window of index" +index+ "is switched");
		} catch (Exception e) {
			System.err.println("The window of index" +index+ "cannot be switched");
		}
	}

	@Override
	public void switchToFrame(WebElement ele) {
		
		try {
			driver.switchTo().frame(ele);
			System.out.println("Switched to the Frame successfully" +ele);
		} catch (Exception e) {
			System.out.println("Switched to the Frame  was not successfull" +ele);
		}

	}

	@Override
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("Alert accepted");
		} catch (Exception e) {
			System.err.println("Alert not accepted");
		}

	}

	@Override
	public void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			System.out.println("Alert dismissed successfully");
		} catch (Exception e) {
			System.err.println("Alert not dismissed");
		}
	}

	@Override
	public String getAlertText() {
	
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert text" +text + "received successfully");
		return null;
	}

	@Override
	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			selectDropDownUsingVisibleText(ele,value);
			System.out.println("DropDown option selected using visible text");
		} catch (Exception e) {
		 System.err.println("DropDown option is not selected using visible text");
		}
		

	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			selectDropDownUsingValue(ele,value);
			System.out.println("DropDown option selected using value is sucessful");
		} catch (Exception e) {
		 System.err.println("DropDown option selected using value is not sucessful");
		}

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			selectDropDownUsingIndex(ele, index);
			System.out.println("DropDown option selected using index is sucessful");
		} catch (Exception e) {
		 System.err.println("DropDown option selected using index is not sucessful");
		}
	}

	@Override
	public void type(WebElement ele, String data) {
		
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The element "+ele+" is typed with the value "+data);
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed with the value "+data);
		}

	}
	
	@Override
	public void typeAndEnter(WebElement ele, String data) {
		
		try {
			ele.clear();
			ele.sendKeys(data);
			ele.sendKeys(Keys.ENTER);
			System.out.println("The element "+ele+" is typed and entered with the value "+data);
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed with the value "+data);
		}

	}

	@Override
	public void click(WebElement ele) {	
		try {
			ele.click();
			System.out.println("The element "+ele+" is clicked");
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be clicked");
		}

	}

	@Override
	public String getText(WebElement ele) {
		
		try {
			String textele = ele.getText();
			System.out.println("The text of" +ele+ "is" +textele);
		} catch (Exception e) {
			System.err.println("The text of" +ele+ "is not attainable");
		}
		return null;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		
		String textele = ele.getText();
			
		if(textele.equals(expectedText))
		{
			System.out.println("The exact text is matched" +ele );
		}else
		{
			System.out.println("The exact text is not matched" +ele );
		}
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		String textele = ele.getText();
		
		if(textele.contains(expectedText))
		{
			System.out.println("The exact text is matched" +ele );
		}else
		{
			System.out.println("The exact text is not matched" +ele );
		}

	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		String  val = ele.getAttribute(attribute);
		if(val.equals(value))
		{
			System.out.println("verify Exact Attribute is successful" +ele);
		}else
		{
			System.out.println("verify Exact Attribute is not  successful" +ele);
		}
		

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		String  val = ele.getAttribute(attribute);
		if(val.contains(value))
		{
			System.out.println("verify Exact Attribute is successful" +ele);
		}else
		{
			System.out.println("verify Exact Attribute is not  successful" +ele);
		}

	}

	@Override
	public void verifySelected(WebElement ele) {

		boolean sel = ele.isSelected();
		if(sel)
		{
			System.out.println("The element is selected successfully" +ele);
		}else
		{
			System.out.println("The element is not selected" +ele);
		}

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		boolean sel = ele.isDisplayed();
		if(sel)
		{
			System.out.println("The element is displayed successfully" +ele);
		}else
		{
			System.out.println("The element is not displayed" +ele);
		}

	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator.toLowerCase()) {
			case "id": return driver.findElement(By.id(locValue));
			case "name": return driver.findElement(By.name(locValue));
			case "link": return driver.findElement(By.linkText(locValue));
			case "class": return driver.findElement(By.className(locValue));
			case "tag": return driver.findElement(By.tagName(locValue));
			case "xpath": return driver.findElement(By.xpath(locValue));
			case "css": return driver.findElement(By.cssSelector(locValue));
			case "partial": return driver.findElement(By.partialLinkText(locValue));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element could not be found for the locator "+locator+" with value "+locValue);
		}
		return null;

	}

	@Override
	public boolean verifyExactTitle(String expectedTitle ) {
		
		String text = driver.getTitle();
		if(text.equals(expectedTitle))
		{
			System.out.println("The exact title is verified" + expectedTitle + "with" +text);
		}
		else
		{
			System.out.println("The exact title is not verified successfully");
		}
		return false;
	}

	
	@Override
	public boolean verifyPartialTitle(String expectedTitle) {
		String text = driver.getTitle();
		if(text.contains(expectedTitle))
		{
			System.out.println("The exact title is verified" + expectedTitle + "with" +text);
		}
		else
		{
			System.out.println("The exact title is not verified successfully");
		}
		return false;
	}

	@Override
	public void closeActiveBrowser() {
		driver.close();

	}

	@Override
	public void closeAllBrowsers() {
		driver.quit();
		
	}


}
