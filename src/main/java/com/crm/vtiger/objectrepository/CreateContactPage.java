package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	//delclaration
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement salutationDrpDwn;
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstnameEdt;
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnameEdt;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])")
	private WebElement saveBtn;
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement accountsAndactionLkpImg;
	@FindBy(name="search_text")
	private WebElement searchOrganisationEdt;
	@FindBy (xpath="//input[@name='search']")
	private WebElement searchBtn;
	@FindBy(xpath="//a[text()='\"+organisation+\"']")
	private WebElement orgName;
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailEdt;
	


	


	


	//initialization
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSalutationDrpDwn() {
		return salutationDrpDwn;
	}
	public void createSalutation(String salutation) {
		select(salutationDrpDwn,salutation);
	}


	


	public WebElement getFirstnameEdt() {
		return firstnameEdt;
	}
	public void createFirstName(String firstname) {
		firstnameEdt.sendKeys(firstname);
	}


	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}
	public void createLastName(String lastname) {
		lastnameEdt.sendKeys(lastname);
	}
	public WebElement getSaveBtn() {
		return saveBtn;

	}
	public WebElement getAccountsAndactionLkpImg() {
		return accountsAndactionLkpImg;
	}
	public WebElement getSearchOrganisationEdt1() {
		return searchOrganisationEdt;
	}
	public void createSearchOrganisation(String orgname) {
		searchOrganisationEdt.sendKeys(orgname);
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getOrgName() {
		return orgName;
	}
	public WebElement getEmailEdt() {
		return emailEdt;
	}
	public void createEmail(String email) {
		emailEdt.sendKeys(email);
	}

}






