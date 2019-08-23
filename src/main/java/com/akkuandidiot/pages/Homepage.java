package com.akkuandidiot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.akkuandidiot.base.CrmProBase;

public class Homepage extends CrmProBase {
	
	@FindBy(xpath="//td[contains(text(),'Rahul Ghosh')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsPageLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Validate Homepage Title
	public String validateHomepageTitle() {
		return driver.getTitle();
	}
	
	//Validate username label
	public boolean isUsernameLabelDisplayed() {
		
		return usernameLabel.isDisplayed();
	}
	
	//Click on Contacts
	public ContactsPage clickOnContact() {
		
		contactsPageLink.click();
		return new ContactsPage();
	}
	
	//Click on New Contact
	public void clickOnNewContact() {
		Actions action =new Actions(driver);
		action.moveToElement(contactsPageLink).build().perform();
		newContactLink.click();		
	}
	
	//Click on Deals
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	//Click on Tasks
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}

}
