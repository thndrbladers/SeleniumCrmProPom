package com.akkuandidiot.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.akkuandidiot.base.CrmProBase;
import com.akkuandidiot.pages.ContactsPage;
import com.akkuandidiot.pages.Homepage;
import com.akkuandidiot.pages.LoginPage;

public class HomepageTest extends CrmProBase{
	
	LoginPage loginPage;
	Homepage homepage;
	ContactsPage contactsPage;

	public HomepageTest() {
		super();
	}
	
  @BeforeMethod
  public void setUp() {
	  initialization();
	  loginPage=new LoginPage();
	  try {
		  Thread.sleep(2000);
		  }catch(InterruptedException e) {
			  
		  }
	  homepage=loginPage.loginLoginPage(prop.getProperty("username"), prop.getProperty("password"));
	  
  }
  
  @Test(priority=1,enabled=false)
  public void validateHomepageTitleTest() {
	  Assert.assertEquals(homepage.validateHomepageTitle(),"CRMPRO","Title not matched.");
  }
  
  @Test(priority=2,enabled=false)
  public void isUsernameLabelDisplayedOnHompageTest() {
	  Assert.assertTrue(homepage.isUsernameLabelDisplayed(), "User Label not displayed.");
  }
  
  @Test(priority=3,enabled=false)
  public void clickOnContactsOnHomepage() {
	  contactsPage=homepage.clickOnContact();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
