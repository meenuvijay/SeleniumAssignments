package week6.day2.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import week6.day2.assignment.hooks.ProjectBase;

public class EnterSearch extends ProjectBase {

	public UpdateCallerDetailsSN searchfield(String data) {

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(data, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new UpdateCallerDetailsSN();

	}

	public DeleteCallerSN searchdelfield(String data) {

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(data, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new DeleteCallerSN();

	}
	
	public UpdateMandatoryArticleSN searchfieldknowlegeno(String data) {

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(data, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new UpdateMandatoryArticleSN();

	}

}
