package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import hooks.TestNgHooks;



public class MyHomePageSN extends TestNgHooks{
	
	public SwitchParentFrameSN typeFilter (String navpage) throws InterruptedException{
		
		WebElement filternav;
		filternav = locateElement("id","filter");
		filternav.sendKeys(navpage);
		filternav.sendKeys(Keys.ENTER);
		click(locateElement("xpath", "//div[text()='Callers']"));
		switchToFrame(0);
		return new SwitchParentFrameSN();
       
		}
	
	
public SwitchParentFrameSN typeSubFilter (String subnavpage, String navpage) throws InterruptedException{
	
    	WebElement filternav;
    	filternav = locateElement("id","filter");
		filternav.sendKeys(navpage);
		filternav.sendKeys(Keys.ENTER);
		click(locateElement("xpath","//div[text()='\" + subnavpage + \"']"));
		return new SwitchParentFrameSN();
       
		}

	
  

}
