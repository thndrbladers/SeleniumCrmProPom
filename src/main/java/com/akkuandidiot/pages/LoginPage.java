package com.akkuandidiot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.akkuandidiot.base.CrmProBase;

public class LoginPage extends CrmProBase{
	
	
	
	@FindBy(name="username")   //Equivalent to
	WebElement username;	   //WebElement element=driver.findElement(By.name("username"));
	
	@FindBy(name="password")	//Equivalent to
	WebElement password;		//WebElement element=driver.findElement(By.name("password"));
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginButton;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement logo;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	
	//Constructor initializing instance variables with WebDriver mentioned in superclass(CrmProBase)
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	//Validate LoginPage Title
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	//Validate LoginPageLogo
	public boolean validateLoginPageLogo() {
		return logo.isDisplayed();
	}
	
	//Login, returns Homepage
	public Homepage loginLoginPage(String user,String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		return new Homepage();
	}
	
	
	
	
	
	
	
	
	

}
