package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;


import hooks.TestNgHooks;

public class SwitchParentFrameSN extends TestNgHooks{
	
	public ClickNewButtonSN switchParentFrame() throws InterruptedException {
		click(locateElement("xpath","//button[text()='New']"));
		Thread.sleep(1000);
		return new ClickNewButtonSN();
	}
	

	
	
	public   EnterSearch switchEnterSearch() {
		
		return new EnterSearch();
	}

	
	

}
