package week6.day2.assignment.pages;

import org.openqa.selenium.By;

import week6.day2.assignment.hooks.ProjectBase;

public class CreateCallerPagesSN extends ProjectBase{
	
	public CreateCallerPagesSN typeFirstname(String firstname) {

		driver.findElement(By.id("sys_user.first_name")).sendKeys(firstname);
		return this;
	}

	public CreateCallerPagesSN typeLastname(String lastname) {
		driver.findElement(By.id("sys_user.last_name")).sendKeys(lastname);
		return this;
	}

	public CreateCallerPagesSN typeUsertitle(String usertitle) {
		driver.findElement(By.id("sys_user.title")).sendKeys(usertitle);
		return this;
	}

	public CreateCallerPagesSN typeEmail(String email) {
		driver.findElement(By.id("sys_user.email")).sendKeys(email);
		return this;
	}

	public CreateCallerPagesSN typePhone(String phone) {
		driver.findElement(By.id("sys_user.phone")).sendKeys(phone);
		return this;
	}


	public CreateCallerPagesSN typeMobile(String mobileph) {
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys(mobileph);
		return this;
	}
	
	public ReturnPageSN clickSubmit() {
		driver.findElement(By.id("sysverb_insert")).click();
		return new ReturnPageSN() ;
	}
	
	

}
