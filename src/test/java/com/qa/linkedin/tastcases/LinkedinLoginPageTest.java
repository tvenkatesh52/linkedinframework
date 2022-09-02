package com.qa.linkedin.tastcases;

import org.testng.annotations.Test;

import com.qa.linkedin.base.TestBase;
import com.qa.linkedin.pages.LinkedinHomePage;
import com.qa.linkedin.pages.LinkedinLoginPage;

import org.apache.commons.collections4.Get;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class LinkedinLoginPageTest extends TestBase{
	private Logger log=Logger.getLogger(LinkedinLoginPageTest.class);
	LinkedinLoginPage logpg;
	LinkedinHomePage homepg;
	
	
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		 log.info("create login page object"); 
		 logpg=new LinkedinLoginPage();
		 homepg=new LinkedinHomePage();
		 //storing linkedinhomepage nonstatic method to current 
		 logpg=homepg.clickOnSigninLink();
		 
		 
	  }

  @Test
  public void verifySignHeaderText() {
	  log.info("verify sign page header text");
	  Assert.assertTrue(logpg.isSigninPageHreaderTextPresent(), "sign in header text is not available");
  }
  @Test
  public void verifyPageTitle() {
	  log.info("verify sign page header text");
	  String title=logpg.getLinkedSigninPageTitle();
	  Assert.assertTrue(title.contains("Sign in | LinkedIn"), "signin page title title is not available");
  }
 
}
