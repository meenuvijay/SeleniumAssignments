package tests;

import org.testng.annotations.Test;

import hooks.TestNgHooks;

import pages.Login;

public class LoginTest extends TestNgHooks {
	
	@Test
	
	public void logintest(){
		
		new Login()
		.typeUserName("DemoSalesManager")
		.typePassword("crmsfa")
		.clickLogin()
		.welcomemsg();
		
	}

}
