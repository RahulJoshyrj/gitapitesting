package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssetsPage {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")private WebElement createAssetLkpImg;
	
	
	public AssetsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreateAssetLkpImg() {
		return createAssetLkpImg;
	}
	
	
}
