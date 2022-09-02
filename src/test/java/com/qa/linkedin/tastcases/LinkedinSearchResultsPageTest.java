package com.qa.linkedin.tastcases;

import org.testng.annotations.Test;

import com.qa.linkedin.base.TestBase;
import com.qa.linkedin.pages.LinkedinFeedPage;
import com.qa.linkedin.pages.LinkedinHomePage;
import com.qa.linkedin.pages.LinkedinLoginPage;
import com.qa.linkedin.pages.LinkedinSearchResultsPage;

import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class LinkedinSearchResultsPageTest extends TestBase{
	private Logger log=Logger.getLogger(LinkedinFeedPageTest.class);
	LinkedinLoginPage logpg;
	LinkedinHomePage homepg;
	LinkedinFeedPage feedpg;
	LinkedinSearchResultsPage searchPg;
	
	
	
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		 log.info("create login page object"); 
		 logpg=new LinkedinLoginPage();
		 homepg=new LinkedinHomePage();
		 feedpg=new LinkedinFeedPage();
		 //storing linkedinhomepage nonstatic method to current 
		 logpg=homepg.clickOnSigninLink();
		 searchPg=new 	LinkedinSearchResultsPage();
	  }
  @Test(description="login to linkedin",priority=1)
  public void doLoginTest() throws InterruptedException, IOException {
	  
	  log.info("input data usernam and password in sign in");
	  feedpg=logpg.doLogin(readPopertyValue("uname"), readPopertyValue("pwd"));
	  log.debug("log in successfully");
	  
  }
  @Test(dataProvider="inputData",priority=2)
  public void doPeopleSearchTest(String keyword) throws InterruptedException {
	  log.info("providing search results test using data provider annotation");   
	  searchPg=feedpg.doPeopleSearch(keyword);
	
	  log.debug("click on seeAllPeopleResultsLink");
	  searchPg.clickonSearchResultsLink();
	  
	  log.info("verify search serults page title");
	 
	  Assert.assertTrue(searchPg.isVerifyPageTitle().contains("Search | LinkedIn"));
	  log.info("fetching the results count "+keyword);
	  long count=searchPg.fetchCounttxt();
	  log.info("search rsults for"+keyword+"count is"+count);
	  log.info("click on hoem tab");
	  searchPg.clickOnHomeTab();
  }

  @DataProvider
  public Object[][] inputData() {
	  Object[][] data=new Object[3][1];
	  //1st data
     data[0][0]="venkatesh";
     //2nd data
     data[1][0]="Lakshmi";
    //3rd data
     data[2][0]="pravallika";
    
    
    return data;
  }
  

}
