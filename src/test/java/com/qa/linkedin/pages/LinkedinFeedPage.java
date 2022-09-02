package com.qa.linkedin.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.linkedin.util.BasePageWebActions;

public class LinkedinFeedPage extends BasePageWebActions{
	private Logger log=Logger.getLogger(LinkedinHomePage.class);
	
	//createa a constructor
	public LinkedinFeedPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="img[class*='feed-identity-module']")
    private WebElement ProfilrRailCard;
	
	@FindBy(css="img[class*='global-nav__me-photo']")
    private WebElement ProfileMeIcon;
	
	@FindBy(css="input[class*='search-global-typeahead__input']")
    private WebElement searchEditBox;
	
	@FindBy(xpath = "//a[contains(@class,'global-nav__secondary-link mv1')]")
	private WebElement signOutLink;
	
	public String getLinkedinFeedPageTitle(){
		log.info("fetching linkedinhomepage  title");
		return driver.getTitle();
	}
	public boolean isProfileCardPresent() {
		log.info("checking the profile railcard availability");
		return ProfilrRailCard.isDisplayed();
		
	}
	public void doLogout() throws InterruptedException {
		log.info("click on profile me ");
		click(ProfileMeIcon);
		Thread.sleep(2000);
		click(signOutLink);	
	}
   public 	LinkedinSearchResultsPage doPeopleSearch(String keyword) throws InterruptedException {
	   log.info("clear & type the keyboard "+keyword+"in searcheditbox");
	   clearText(searchEditBox);
	   type(searchEditBox,keyword);
	   searchEditBox.sendKeys(Keys.ENTER);
	   Thread.sleep(2000);
	   return new LinkedinSearchResultsPage();
	   
	   
	 
   }
	
	
	
	
	
	

}
