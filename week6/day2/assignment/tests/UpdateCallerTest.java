package week6.day2.assignment.tests;

import org.testng.annotations.Test;

import week6.day2.assignment.hooks.ProjectBase;
import week6.day2.assignment.pages.LoginServiceNow;

public class UpdateCallerTest extends ProjectBase{
	
	@Test
	
	public void updatecallertest() throws InterruptedException
	{
		
		new LoginServiceNow()
		.clickMainFrame()
		.typeUsername("admin")
		.typePassword("India@123")
		.clickLogin()
		.verifyWelcomeMsg()
		.typeFilter("Callers")
		.switchHomeFrame()
		.switchEnterSearch()
		.searchfield("Meena")
		.updatePhone("0987654321")
		.clickUpdate()
		.verifyCallerUpdate();
		
		
		
	}

}
