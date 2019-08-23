package com.akkuandidiot.tests;

import org.testng.annotations.Test;

import com.akkuandidiot.base.CrmProBase;
import com.akkuandidiot.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends CrmProBase {
	
	LoginPage loginPage;
	public LoginPageTest() {
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
	}
  
	@Test(priority=1)
	public void loginPageTittleTest() {
		System.out.println(loginPage.validateLoginPageTitle());
		Assert.assertEquals(loginPage.validateLoginPageTitle(),
				"CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
  
	@Test(priority=2)
	public void loginPageLogoTest() {
		Assert.assertEquals(loginPage.validateLoginPageLogo(), true);
	}
  
	@Test(priority=3)
	public void loginPageLoginTest() {
		String user=prop.getProperty("username");
		String pass=prop.getProperty("password");
		loginPage.loginLoginPage(user, pass);
	}

	@AfterMethod
	public void tearDown() {
	driver.quit();
  }

}
