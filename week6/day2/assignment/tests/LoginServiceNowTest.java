package week6.day2.assignment.tests;
import week6.day2.assignment.pages.LoginServiceNow;
import org.testng.annotations.Test;

import week6.day2.assignment.hooks.ProjectBase;




public class LoginServiceNowTest extends ProjectBase{
	
	@Test
	
	public void loginservicenowtest() throws InterruptedException
	{
		
		new LoginServiceNow()
		.clickMainFrame()
		.typeUsername("admin")
		.typePassword("India@123")
		.clickLogin()
		.verifyWelcomeMsg();

		
	
	}

}
