package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

public class OpportunitiesPage extends WebDriverUtility {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement opportunityLkpImg;
	
	
	
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getOpportunityLkpImg() {
		return opportunityLkpImg;
	}
	
	

}
