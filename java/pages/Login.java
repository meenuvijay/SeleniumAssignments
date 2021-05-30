package pages;
import org.openqa.selenium.By;

import hooks.TestNgHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class Login extends TestNgHooks{
	
	
	
	@Given("The username is entered as (.*)$")
	public Login typeUserName(String userdata) {
		type(locateElement("id", "username"), userdata);
		return this;
	}
	
	@And("The password is entered as (.*)$")
	public Login typePassword(String passdata) {
		type(locateElement("id", "password"), passdata);
		return this;
	}
	
	public Home typePasswordAndEnter(String passdata) {
		typeAndEnter(locateElement("id", "password"),passdata);
		return new Home();
	}
	
	@And("Click Login")
	public Home clickLogin() {
		click(locateElement("class", "decorativeSubmit"));
		return new Home();
	}
	
	public Login clickLoginForFailure() {
		click(locateElement("class", "decorativeSubmit"));
		return this;
	}


	

}
