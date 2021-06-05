package pages;

import org.openqa.selenium.By;

import hooks.TestNgHooks;


public class UpdateCallerDetailsSN extends TestNgHooks{
	
	

	public UpdateCallerDetailsSN updatePhone(String phno) {
		
			clearAndType(locateElement("id","sys_user.phone"),phno);
			
			return this;
		}
		
		
	

	
	public ReturnPageSN clickUpdate() {
		
		click(locateElement("id","sysverb_update"));
		return new ReturnPageSN() ;
	}
	
	

}
