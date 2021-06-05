package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import hooks.TestNgHooks;

public class EnterSearch extends TestNgHooks {

	public UpdateCallerDetailsSN searchfield(String data) {

		WebElement ele1 = locateElement("xpath","//input[@placeholder='Search']");
		ele1.sendKeys(data, Keys.ENTER);
		click(locateElement("xpath","//a[@class='linked formlink']"));
		return new UpdateCallerDetailsSN();

	}

/*	public DeleteCallerSN searchdelfield(String data) {

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(data, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new DeleteCallerSN();

	}
	
	public UpdateMandatoryArticleSN searchfieldknowlegeno(String data) {

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(data, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new UpdateMandatoryArticleSN();

	}*/

}
