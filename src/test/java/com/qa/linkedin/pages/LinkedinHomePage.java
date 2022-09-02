package com.qa.linkedin.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.linkedin.util.BasePageWebActions;

public class LinkedinHomePage extends BasePageWebActions{
	private Logger log=Logger.getLogger(LinkedinHomePage.class);
     
    //new modification is changes for git
	
	//createa a constructor
	public LinkedinHomePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="a[class*='nav__logo-link']")
    private WebElement linkedinLogo;
	
	@FindBy(css="a.nav__button-secondary.btn-md.btn-secondary-emphasis")
    private WebElement signinButton;
	
	public String getLInkedinHomepageTitle() {
		log.info("fetching linkedinhomepage  title");
		return driver.getTitle();
	}
	
	public boolean  isLinkedLogoPresent(){
		
		log.info("checking linkedin logo is present or not");
		return linkedinLogo.isDisplayed();
		
	}
	public LinkedinLoginPage clickOnSigninLink() throws InterruptedException  {
		click(signinButton);
		return new LinkedinLoginPage();
	}
}

