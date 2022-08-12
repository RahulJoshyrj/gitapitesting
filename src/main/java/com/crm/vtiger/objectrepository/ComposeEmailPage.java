package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeEmailPage {
	@FindBy(xpath="//input[@name='parent_name']")
	private WebElement ToEdt;
	@FindBy(xpath="//input[@name='ccmail']")
	private WebElement ccEdt;
	@FindBy(xpath="//input[@name='bccmail']")
	private WebElement bccEdt;
	@FindBy(xpath="//input[@name='subject']")
	private WebElement subjectEdt;
	@FindBy(xpath="//input[@name='file_0']")
	private WebElement uploadLink;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement ContactLkpImg;
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchEdt;
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	@FindBy(xpath="//a[text()=\\\"Rahul joshy\\\"]")
	private WebElement contactName;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;
	@FindBy(xpath="//input[@name='Send']")
	private WebElement sendBtn;
	
	public ComposeEmailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getToEdt() {
		return ToEdt;
	}
	public void createToEdt(String Toname) {
		ToEdt.sendKeys(Toname);
	}

	public WebElement getCcEdt() {
		return ccEdt;
	}
	public void createCcEdt(String CcName ) {
		ccEdt.sendKeys(CcName);
	}

	public WebElement getBccEdt() {
		return bccEdt;
	}
	public void createBccEdt(String BccName) {
		bccEdt.sendKeys(BccName);
	}

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}
	public void createSubjectEdt(String subject) {
		subjectEdt.sendKeys(subject);
	}
	

	public WebElement getUploadLink() {
		return uploadLink;
	}

	public WebElement getContactLkpImg() {
		return ContactLkpImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getContactName() {
		return contactName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSendBtn() {
		return sendBtn;
	}
	

	
	
	
}
