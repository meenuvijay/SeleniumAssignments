package week6.day2.assignment.pages;

import org.openqa.selenium.By;
import week6.day2.assignment.hooks.ProjectBase;

public class UpdateMandatoryArticleSN extends ProjectBase {
	
	public UpdateMandatoryArticleSN typeshortDesc(String shortDesc) {
		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys(shortDesc);
		return this;
	}

	public UpdateMandatoryArticleSN selectKnowledgelookup()  {
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']//span[1]")).click();
		return this;		
	}

	public UpdateMandatoryArticleSN clickKnowledgeBase() throws InterruptedException {
		ProjectBase.clickPopUp();
		driver.findElement(By.linkText("IT")).click();
		ProjectBase.clickParentwindow();
		return this;
	}

	public ReturnPageSN clickUpdate() {
		driver.findElement(By.id("sysverb_update")).click();
		return new ReturnPageSN() ;
	}

}
