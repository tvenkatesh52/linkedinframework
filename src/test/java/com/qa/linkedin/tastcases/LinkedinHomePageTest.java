package com.qa.linkedin.tastcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qa.linkedin.base.TestBase;
import com.qa.linkedin.pages.LinkedinHomePage;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LinkedinHomePageTest extends TestBase{
	private Logger log=Logger.getLogger(LinkedinHomePageTest.class);
	/**
	 * verify linkedin logo-test1
	 * verify linkedin title-test2
	 */
	LinkedinHomePage lhp;
	
  @Test
  public void verifyLinkedinLogo() {
	  log.info("verifylinkedin logo ");
	  lhp=new LinkedinHomePage();
	  Assert.assertTrue(lhp.isLinkedLogoPresent(), "linkedin logo is not available in linkedinhomepage");
  }
  @Test
  public void verifyLinkedinTitle() {
	  log.info("verifylinkedin title is present or not ");
	  String title=lhp.getLInkedinHomepageTitle();
	  Assert.assertEquals(title, "LinkedIn: Log In or Sign Up");
	  
	  
	  
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  //launching the browser using TestBase class method
	  log.debug("launching the chrome browser");
	setup();
	  
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  log.info("close the current browser");
	  driver.manage().deleteAllCookies();
	  Thread.sleep(5000);
	  tearDown();
	  
  }

}
