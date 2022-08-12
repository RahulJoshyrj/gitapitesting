package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

public class CreateDocumentPage extends WebDriverUtility {
	@FindBy(xpath="//input[@name='notes_title']")
	private WebElement TitileEdt;
	
	@FindBy(xpath="//input[@name='filename']")
	private WebElement fileUploadLink;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTitileEdt() {
		return TitileEdt;
	}
	public void createTitleEdt(String title) {
		TitileEdt.sendKeys(title);
	}

	public WebElement getFileUploadLink() {
		return fileUploadLink;
	}
	public void switchFrameAndSendText(WebDriver driver,int index,String message) {
		switchToFrame(driver,index);
		WebElement el = driver.switchTo().activeElement();
		 Actions a=new Actions(driver);
		 a.moveToElement(el).perform();
		 el.sendKeys(message);
		 switchToMainFrame(driver);
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
}
