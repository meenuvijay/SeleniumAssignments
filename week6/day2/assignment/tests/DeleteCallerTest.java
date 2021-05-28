package week6.day2.assignment.tests;

import org.testng.annotations.Test;

import week6.day2.assignment.hooks.ProjectBase;
import week6.day2.assignment.pages.LoginServiceNow;

public class DeleteCallerTest extends ProjectBase{
	
	@Test
	
	public void deletecallertest() throws InterruptedException
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
		.searchdelfield("Meena")
		.clickDelete()
		.verifyCallerDelete();
		
		
		
		
	}

}
