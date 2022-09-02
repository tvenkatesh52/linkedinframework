package com.qa.linkedin.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.linkedin.util.BasePageWebActions;

public class LinkedinSearchResultsPage   extends BasePageWebActions{
	private Logger log=Logger.getLogger(LinkedinSearchResultsPage.class);
	
	//createa a constructor
	public LinkedinSearchResultsPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='app-aware-link'][contains(.,'See all people results')]")
	
	//@FindBy(xpath="//*[@id=\"main\"]/div/div/div[1]/div[2]/a']")
	
	private WebElement searchResultsLink;
	
	@FindBy(xpath = "//div[@class='search-results-container']/h2")
	private WebElement searchResultsCount;
	
	@FindBy(xpath = "//*[@class='global-nav__nav']/ul/li[1]/a")
	//@FindBy(xpath = "//a[contains(.,'Home')]")
	private WebElement homeTab;
	
	public String isVerifyPageTitle() {
		
		log.info("verify the page tittle");
		return driver.getTitle();
		
	}
	public void clickonSearchResultsLink() throws InterruptedException {
		log.info("click on search results link");
		click(searchResultsLink);
		Thread.sleep(2000);
		
	}
	
	
	
	public String getfetchResultsCount() throws InterruptedException {
		log.debug("fetch search results count");
		return getText(searchResultsCount);	
	}
	public void clickOnHomeTab() throws InterruptedException {
		log.debug("clicl ob home tab");
		click(homeTab);
	}
	public long fetchCounttxt() throws InterruptedException {
		String str=getfetchResultsCount();
		String[] txt=str.split(" ");
		String xt=txt[1].replace(",", "");
		long ltxt=Long.parseLong(xt);
		log.info("result count txt is: ");
		return ltxt;
		
	}
	

}
