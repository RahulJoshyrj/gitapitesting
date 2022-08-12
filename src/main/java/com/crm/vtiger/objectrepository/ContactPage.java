package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	//declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement cntctLkpImg;
	
	//initialization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getCntctLkpImg() {
		return cntctLkpImg;
	}
	
}
