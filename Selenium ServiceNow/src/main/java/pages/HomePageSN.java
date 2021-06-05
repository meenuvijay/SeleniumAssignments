package pages;




import org.openqa.selenium.WebElement;

import hooks.TestNgHooks;
;


public class HomePageSN extends TestNgHooks{
	
	public MyHomePageSN verifyWelcomeMsg (){
		
		 WebElement navsideBar =  locateElement("xpath","//nav[@class='navpage-nav']");
	
		 
			boolean navdisplay = navsideBar.isDisplayed();
			System.out.println(navdisplay);
			
			if(navdisplay)
			{
				if(verifyTitle("ServiceNow"))
				{
					System.out.println("Login Successful");
				}else
				{
					System.out.println("Login not Successful");
				}
			}
			return new MyHomePageSN();
	}
	
  
	public LoginServiceNow clickLogout() {
		
		click(locateElement("xpath","//span[@class='caret']"));
		click(locateElement("link","Logout"));
		
		return new LoginServiceNow();
	}
	

}
