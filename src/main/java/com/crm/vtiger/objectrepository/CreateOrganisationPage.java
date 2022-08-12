package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

public class CreateOrganisationPage extends WebDriverUtility {
	//declaration
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgnameEdt;

	@FindBy(xpath="//input[@name='website']")
	private WebElement websiteEdt;

	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDrpDwn;

	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement typeDrpDwn;
	




	//initialization
	public CreateOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}
	public void createOrg(String orgname) {
		orgnameEdt.sendKeys(orgname);
	}

	public void selectIndustry(String industry) {
		select(industryDrpDwn,industry);
	}
	public void selectType(String type) {
		select(typeDrpDwn,type);
	}
	public void createWebsite(String website) {
		websiteEdt.sendKeys(website);
	}

}
