package week6.day2.tests;

import org.testng.annotations.Test;

import week6.day2.pages.Login;
import week6day2.hooks.TestNghooks;

public class CreateLeadTest extends TestNghooks{
	
	@Test
	
	public void login()
	{
		new Login()
		.typeUsername("DemoSalesManager")
		.typePassword("crmsfa")
		.clickLogin()
		.clickCRMSFA()
		.clickLeadTab()
		.clickCreateLead()
		.typeCompanyName("ReserveBank")
		.typefirstName("Meena")
		.typelastName("Vijay")
		.clickCreateButton();
		
		
		
	}
	


}
