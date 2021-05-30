package pages;
import org.openqa.selenium.By;

import hooks.TestNgHooks;
import wrappers.BaseDriver;


public class MyHome extends TestNgHooks{
	
	public MyHome welcomemsg()
	{
		
		verifyPartialText((locateElement("tag","h2")),"Welcome");
	
		return this;
	}
		

	public Login clickLogout()
	{
		click(locateElement("class","decorativeSubmit"));
		
		return new Login();
	}
	
	public  LeadsTab clickLeadTab()
	{
		click(locateElement("link","Leads"));
		return new LeadsTab();
	}
}
