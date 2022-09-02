package com.qa.linkedin.tastcases;

import org.testng.annotations.Test;

import com.qa.linkedin.base.TestBase;
import com.qa.linkedin.pages.LinkedinFeedPage;
import com.qa.linkedin.pages.LinkedinHomePage;
import com.qa.linkedin.pages.LinkedinLoginPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class LinkedinFeedPageTest extends TestBase{
	private Logger log=Logger.getLogger(LinkedinFeedPageTest.class);
	LinkedinLoginPage logpg;
	LinkedinHomePage homepg;
	LinkedinFeedPage feedpg;
	
	
	
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		 log.info("create login page object"); 
		 logpg=new LinkedinLoginPage();
		 homepg=new LinkedinHomePage();
		 feedpg=new LinkedinFeedPage();
		 //storing linkedinhomepage nonstatic method to current 
		 logpg=homepg.clickOnSigninLink();
	  }

  @Test
  public void doLoginTest() throws InterruptedException, IOException {
	  log.info("input uname and pwd in for signin");
	  feedpg=logpg.doLogin(readPopertyValue("uname"), readPopertyValue("pwd"));
	  log.info("login successful");
  }
  @Test(dependsOnMethods={"doLoginTest"})
  public void verifyProfileRailCardTest() {
	  log.info("verify profile railcard is present or not");
	  //if condition is true then it will gotonext test if it is not therse String msg will be displayed
	  Assert.assertTrue(feedpg.isProfileCardPresent(), "there is no profile railcard in lfeef page ");
}
  @Test(priority=-1)
  public void verifyPageTitleTest() {
  log.info("verify feed page title is present or not");
  String title=feedpg.getLinkedinFeedPageTitle();
  Assert.assertTrue(title.contains("LinkedIn"), "verifying page title ");
  
  } 
  @Test(priority=1)
  public void doLogoutTest() throws InterruptedException {
	  log.info("verifying all amethods then press on logout button");
	  feedpg.doLogout();
      log.debug("successfully completed logout");
  
  
  } 
}