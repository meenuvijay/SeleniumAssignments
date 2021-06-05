package tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;


import hooks.TestNgHooks;
import pages.LoginServiceNow;


public class UpdateCallerTest extends TestNgHooks{
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Update Caller";
		testDescription = "Update Caller";
		nodes = "Callers";
		authors = "Meenakshi";
		category = "sanity";
		dataSheetName = "UpdateCaller";
	}
	
	@Test(dataProvider="FetchExcelData")
	public void createcallertest(String firstname, String phno) throws InterruptedException
	{
		
		new LoginServiceNow()
		.clickMainFrame()
		.typeUsername("admin")
		.typePassword("India@123")
		.clickLogin()
		.verifyWelcomeMsg()
		.typeFilter("Callers")
		.switchEnterSearch()
		.searchfield(firstname)
		.updatePhone(phno)
		.clickUpdate()
		.verifyCallerUpdate();
		
		
		
	}

}
