package week6.day2.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import week6.day2.assignment.hooks.ProjectBase;

public class CreateArticleSN extends ProjectBase {

	public CreateArticleSN typeKnowledgeBase(String knowledgebase) throws InterruptedException {
		WebElement kBase = driver.findElement(By.id("sys_display.kb_knowledge.kb_knowledge_base"));
		kBase.sendKeys(knowledgebase);
		kBase.sendKeys(Keys.ARROW_DOWN);
		kBase.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		return this;
	}

	public CreateArticleSN typeshortDesc(String shortDesc) {
		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys(shortDesc);
		return this;
	}

	public CreateArticleSN getArticleNo() throws InterruptedException {

		// Get Knowledge no
		number = driver.findElement(By.id("sys_readonly.kb_knowledge.number")).getAttribute("value");
		Thread.sleep(2000);
		System.out.println("The Knowlege number" + number);
		return this;
	}

	public ReturnPageSN clickSubmit() {
		driver.findElement(By.id("sysverb_insert")).click();
		return new ReturnPageSN();

	}

}
