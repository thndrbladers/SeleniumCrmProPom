package com.akkuandidiot.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.akkuandidiot.base.CrmProBase;
import com.akkuandidiot.pages.ContactsPage;
import com.akkuandidiot.pages.Homepage;
import com.akkuandidiot.pages.LoginPage;
import com.akkuandidiot.utility.TestUtility;


public class ContactsPageTest extends CrmProBase {
	
	LoginPage loginPage;
	Homepage homepage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	  @BeforeMethod
	  public void beforeMethod() {
		  initialization();
		  loginPage=new LoginPage();
		  try {
		  Thread.sleep(2000);
		  }catch(InterruptedException e) {
			  
		  }
		  homepage=loginPage.loginLoginPage(prop.getProperty("username"), prop.getProperty("password"));
		  TestUtility.switchToframe();
		  contactsPage=homepage.clickOnContact();
		  
		  
	  }
	  
	  @Test(priority=1,enabled=false)
	  public void validateContactsLabelOnContactsPageTest() {
		  TestUtility.takeScreenshotAtEndOfTest();
		  Assert.assertTrue(contactsPage.validateContactsLabel(), "Contacts Label not displayed");
	  }
	  
	  @Test(priority=2,enabled=false)
	  public void selectSingleContactTest() {
		  contactsPage.selectContactsByname("Rahul Dev Ghosh");
	  }
	  
	  @Test(priority=3,dataProvider="getNewContactData",enabled=false)
	  public void addNewContactTest(String title,String firstname,String middlename,String lastname,
				String company,String supervisor,String email,String phone,String mobile) {
		  
		  homepage.clickOnNewContact();
		  contactsPage.createNewContact(title, firstname, middlename, lastname, company, supervisor, email, phone, mobile);
		  
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
	  
	  @DataProvider
	  public Object[][] getNewContactData(){
		  Object[][]obj=TestUtility.getTestData("Contacts");
		  return obj;
	  }

}
