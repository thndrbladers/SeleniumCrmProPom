package com.akkuandidiot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.akkuandidiot.base.CrmProBase;

public class ContactsPage extends CrmProBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(name="title")
	WebElement titleSelect;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="middle_initial")
	WebElement middleName;
	
	@FindBy(name="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(name="contact_lookup_sup")
	WebElement supervisorName;
	
	@FindBy(name="email")
	WebElement emailId;
	
	@FindBy(name="phone")
	WebElement phoneNum;
	
	@FindBy(name="mobile")
	WebElement mobileNum;
	
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement saveButton;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//validate contacts label
	public boolean validateContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	//Select contacts by name
	public void selectContactsByname(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td[1]/preceding-sibling::td/input")).click();
	}
	
	//Create new contact
	public void createNewContact(String title,String firstname,String middlename,String lastname,
			String company,String supervisor,String email,String phone,String mobile) {
		
		
		Select select=new Select(titleSelect);
		select.selectByVisibleText(title);
		
		firstName.sendKeys(firstname);
		middleName.sendKeys(middlename);
		lastName.sendKeys(lastname);
		companyName.sendKeys(company);
		supervisorName.sendKeys(supervisor);
		emailId.sendKeys(email);
		phoneNum.sendKeys(phone);
		mobileNum.sendKeys(mobile);
		
		saveButton.click();
		
		
		
		
		
	}

}
