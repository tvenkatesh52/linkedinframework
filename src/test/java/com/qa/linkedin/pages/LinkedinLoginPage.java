package com.qa.linkedin.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.linkedin.util.BasePageWebActions;

public class LinkedinLoginPage extends BasePageWebActions{
private Logger log=Logger.getLogger(LinkedinHomePage.class);
	
	//createa a constructor
	public LinkedinLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="h1[class*='header__content__heading ']")
	private WebElement siginHeaderText;
	
	@FindBy(id="username")
	private WebElement emailEditBox;
	
	@FindBy(name="session_password")
	private WebElement passwordEditBox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signinButton;
	
	public String getLinkedSigninPageTitle() {
		
		log.info("fetch the linkedin  signin page title");
		return driver.getTitle();
		
	}
	public boolean isSigninPageHreaderTextPresent() {
		log.info("verify  the linkedin  signin page header text or not");
		return siginHeaderText.isDisplayed();
		
	}
	public void clickSigninbutton() throws InterruptedException {
		log.info("click on sign in button");
		click(signinButton);
	}
	public LinkedinFeedPage doLogin(String uname,String pwd) throws InterruptedException {
		log.debug("perform the login action");
		log.info("clear the content ");
		clearText(emailEditBox);
		type(emailEditBox,uname);
		clearText(passwordEditBox);
		type(passwordEditBox,pwd);
		click(signinButton);
		return new LinkedinFeedPage();
	}
	
}
