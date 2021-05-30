package tests;

import org.testng.annotations.Test;

import hooks.TestNgHooks;

import pages.Login;

public class CreateLeadTest extends TestNgHooks {
	
	
	@Test(dataProvider="FetchExcelData")
	public void createleadtest(String compName,String firstName,String lastName){
		
		new Login()
		.typeUserName("DemoSalesManager")
		.typePassword("crmsfa")
		.clickLogin()
		.welcomemsg()
		.clickCRMSFA()
	    .clickLeadTab()
	    .clickCreateLead()
	    .typeCompanyName(compName)
	    .typefirstName(firstName)
	    .typelastName(lastName)
	    .clickCreateButton()
	    .verifyCreateLead();
	}

}
