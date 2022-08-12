package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
	@FindBy(xpath="//a[text()='Compose']")
	private WebElement composeLink;
	
	public  EmailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getComposeLink() {
		return composeLink;
	}
	
	
}
