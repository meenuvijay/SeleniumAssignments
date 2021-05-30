package pages;

import org.openqa.selenium.By;

import hooks.TestNgHooks;
import wrappers.BaseDriver;


public class CreateLead extends TestNgHooks {
	
	

	public  CreateLead typeCompanyName(String compName) {
		
		type(locateElement("id","createLeadForm_companyName"),compName);
	
		return this;
	}
	
	
	
   public  CreateLead typelastName(String lastName) {
		
	   type(locateElement("id","createLeadForm_lastName"),lastName);
		return this;
	}
	
   public  CreateLead typefirstName(String firstName) {
	
	   type(locateElement("id","createLeadForm_firstName"),firstName);
	   return this;
}
   public   ViewLead clickCreateButton()
	{
	   driver.findElement(By.className("smallSubmit")).click();
		return new ViewLead();
	}


}
