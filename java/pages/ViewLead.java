package pages;


import hooks.TestNgHooks;
import wrappers.BaseDriver;

public class ViewLead extends TestNgHooks{
	
	public  ViewLead verifyCreateLead()
	{
		verifyPartialText((locateElement("id","sectionHeaderTitle_leads")),"View");
		
		return this;
		
	}

	public Login clickLogout()
	{
		click(locateElement("class","decorativeSubmit"));
		
		return new Login();
	}
}
