package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

public class ContactInfoPage extends WebDriverUtility {
	@FindBy(xpath="(//span[@class='dvHeaderText'])")
	private WebElement contactName;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorLink;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;

	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getContactName() {
		return contactName;
	}

	public WebElement getAdministratorLink() {
		return administratorLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public void Logout(WebDriver driver) {
		mouseoverOneElement(driver, administratorLink);
		signOutLink.click();
	}
	
}
