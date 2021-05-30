package pages;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.MyHome;
import wrappers.BaseDriver;

public class Home  extends TestNgHooks{
	
	@Then("Verify the welcome message")
	public  Home welcomemsg()
	{
		
		verifyPartialText((locateElement("tag","h2")),"Welcome");
	
		return this;
	}

	@And("Click Logout")
	public Login clickLogout()
	{
		click(locateElement("class","decorativeSubmit"));
		
		return new Login();
	}
	
	public MyHome clickCRMSFA()
	{
		click(locateElement("link","CRM/SFA"));
		return new MyHome();
	}

}
