package week6.day2.assignment.tests;

import org.testng.annotations.Test;

import week6.day2.assignment.hooks.ProjectBase;
import week6.day2.assignment.pages.LoginServiceNow;


public class CreateCallerTest extends ProjectBase{
	
	@Test
	
	public void createcallertest() throws InterruptedException
	{
		
		new LoginServiceNow()
		.clickMainFrame()
		.typeUsername("admin")
		.typePassword("India@123")
		.clickLogin()
		.verifyWelcomeMsg()
		.typeFilter("Callers")
		.switchHomeFrame()
		.switchParentFrame()
		.clickNewButton()
		.typeFirstname("Meenakshi")
		.typeLastname("Vijay")
		.typeEmail("meenutest@gmail.com")
		.typePhone("123456789")
		 .typeUsertitle("Mrs")
		 .typeMobile("1234545457")
		 .clickSubmit();
		
		
		
	}

}
