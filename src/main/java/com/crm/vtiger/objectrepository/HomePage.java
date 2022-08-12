package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriverUtility wLib=new WebDriverUtility();
	//declaration
	@FindBy(xpath="//a[text()='Organizations']")private WebElement organisationLink;
	@FindBy(xpath="//a[text()='Contacts']")private WebElement ContactsLink;
	@FindBy(xpath="//a[text()='More']")private WebElement moreLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")private WebElement administratorLink;
	@FindBy(xpath="//a[text()='Email']") private WebElement EmailLink;	
	@FindBy(xpath="//a[text()='Products']") private WebElement productsLink;
	@FindBy(xpath="(//a[text()='Opportunities'])[1]")private WebElement opportunityLink;
	@FindBy(xpath="//a[@name='Invoice']")private WebElement invoiceLink;
	@FindBy(xpath="//a[text()='Documents']")private WebElement documentLink;
	@FindBy(xpath="//a[@name='Assets']") private WebElement assestsLink;
	@FindBy(xpath="//a[text()='Sign Out']")private WebElement signOutLink;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getOrganisationLink() {
		return organisationLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getInvoiceLink() {
		return invoiceLink;
	}
	
	public void mouseHoverMoreAndClickInvoiceLink(WebDriver driver) {
		
		mouseoverOneElement(driver, moreLink);
		invoiceLink.click();
		
	}

	public WebElement getAdministratorLink() {
		return administratorLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	public WebElement getEmailLink() {
		return EmailLink;
	}
	public WebElement getProductsLink() {
		return productsLink;
	}
	
	public WebElement getOpportunityLink() {
		return opportunityLink;
	}
	public WebElement getDocumentLink() {
		return documentLink;
	}
	
	public WebElement getAssestsLink() {
		return assestsLink;
	}
	public void mouseHoverMoreAndClickAssetsLink(WebDriver driver) {
		mouseoverOneElement(driver, moreLink);
		assestsLink.click();
	}
	public void Logout(WebDriver driver) {
		wLib.mouseoverOneElement(driver, administratorLink);
		signOutLink.click();
	}
	
}
