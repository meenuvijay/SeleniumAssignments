package week6.day2.assignment.tests;

import org.testng.annotations.Test;

import week6.day2.assignment.hooks.ProjectBase;
import week6.day2.assignment.pages.LoginServiceNow;


public class UpdateArticleTest extends ProjectBase{
	
	@Test
	
	public void articlecreatetest() throws InterruptedException
	{
		
		new LoginServiceNow()
		.clickMainFrame()
		.typeUsername("admin")
		.typePassword("India@123")
		.clickLogin()
		.verifyWelcomeMsg()
		.typeSubFilter("My Knowledge Articles", "Knowledge")
		.switchHomeFrame()
		.switchEnterSearch()
		.searchfieldknowlegeno("KB0010222")
		.typeshortDesc("Meena Test")
		.selectKnowledgelookup()
		.clickKnowledgeBase()
		.clickUpdate()
		.verifyUpateArticle();
			
	}

}
