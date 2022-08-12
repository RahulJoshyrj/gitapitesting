package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

public class CreateOpportunitiesPage extends WebDriverUtility {
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement potentialNameEdt;
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement accountsActionLkpImg;
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement SearchEdt;
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	@FindBy(xpath="//a[text()=\\'\"+organizationName+\"']")
	private WebElement orgName;
	@FindBy(xpath="//select[@name='opportunity_type']")
	private WebElement opptype;
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[2]")
	private WebElement campaignActionLkpImg;
	@FindBy(xpath="//a[text()=\\'\"+campaign+\"']")
	private WebElement campaignName;
	@FindBy(xpath="\"//select[@name='sales_stage']\"")
	private WebElement salesStage;
	@FindBy(xpath="\"(//img[@src='themes/softed/images/btnL3Calendar.gif'])[2]\"")
	private WebElement calenderPopUp;
	@FindBy(xpath="//td[text()='15']")
	private WebElement date;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;

	


	public CreateOpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPotentialNameEdt() {
		return potentialNameEdt;
	}
	public void createPotentialNameEdt(String potentialName) {
		potentialNameEdt.sendKeys(potentialName);
	}

	public WebElement getAccountsActionLkpImg() {
		return accountsActionLkpImg;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}
	public void createSearchEdt(String organizationName) {
		SearchEdt.sendKeys(organizationName);
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getOrgName() {
		return orgName;
	}
	public WebElement getOpptype() {
		return opptype;
	}
	public void selectOppType(String type) {
		select(opptype,type);
	}
	public WebElement getCampaignActionLkpImg() {
		return campaignActionLkpImg;
	}
	
	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getSalesStage() {
		return salesStage;
	}
	public void selectSalesStage(String SalesStage) {
		select(salesStage,SalesStage);
	}

	public WebElement getCalenderPopUp() {
		return calenderPopUp;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	
	
	
	
	
}
