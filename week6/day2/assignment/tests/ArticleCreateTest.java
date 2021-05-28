package week6.day2.assignment.tests;

import org.testng.annotations.Test;

import week6.day2.assignment.hooks.ProjectBase;
import week6.day2.assignment.pages.LoginServiceNow;


public class ArticleCreateTest extends ProjectBase{
	
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
		.switchParentFrame()
		.clickNewButtonArticle()
		.getArticleNo()
		.typeshortDesc("Dont Touch My Article")
		.typeKnowledgeBase("Knowledge")
		.clickSubmit()
		.verifyCreateArticle();
		
	}

}
