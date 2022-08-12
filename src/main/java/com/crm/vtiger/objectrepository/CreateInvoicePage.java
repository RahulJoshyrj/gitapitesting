package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

public class CreateInvoicePage extends WebDriverUtility {
	@FindBy(xpath="//input[@name='subject']")
	private WebElement subjectEdt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement salesorderActionLkpImg;
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[3]")
	private WebElement OrganisationLkpImg;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	

	
	
	
	
	public CreateInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getSubjectEdt() {
		return subjectEdt;
	}
	public void createSubjectEdt(String subject) {
		subjectEdt.sendKeys(subject);
	}
	public WebElement getSalesorderActionLkpImg() {
		return salesorderActionLkpImg;
	}
	public WebElement getLinktext(WebDriver driver,String salesorder) {
		WebDriverUtility wLib=new WebDriverUtility();
		WebElement link = wLib.getLinkText(driver, salesorder);
		return link;
		
	}
	public WebElement getOrganisationLkpImg() {
		return OrganisationLkpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	
	
}
