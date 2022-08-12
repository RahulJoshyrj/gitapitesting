package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgname;
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactsLink;
	//initialization
	public OrganisationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getOrgname() {
		return orgname;
	}
	public WebElement getContactsLink() {
		return contactsLink;
	}
	
	
}
