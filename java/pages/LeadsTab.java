package pages;



import hooks.TestNgHooks;
import wrappers.BaseDriver;


public class LeadsTab extends TestNgHooks {
	
	public  CreateLead clickCreateLead()
	{
		click(locateElement("link","Create Lead"));
		return new CreateLead();
	}
	

}
