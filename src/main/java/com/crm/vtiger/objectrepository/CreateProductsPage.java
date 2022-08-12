package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

public class CreateProductsPage extends WebDriverUtility {
	@FindBy(name="productname")
	private WebElement productEdt;
	@FindBy(xpath="//select[@name='productcategory']")
	private WebElement productCategoryDrpdwn;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement vendorLkpImg;
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement SearchEdt;
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	@FindBy(xpath="//a[text()='\"+vendername+\"']")
	private WebElement venderName;
	@FindBy(xpath="//input[@name='file_0']")
	private WebElement fileUploadLink;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	public CreateProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getProductEdt() {
		return productEdt;
	}
	public void createProductEdt(String productname) {
		productEdt.sendKeys(productname);
	}



	public WebElement getProductCategoryDrpdwn() {
		return productCategoryDrpdwn;
	}
	public void selectProductCategoryDrpDwn(String categoryName) {
		select(productCategoryDrpdwn,categoryName);
	}
	public WebElement getVendorLkpImg() {
		return vendorLkpImg;
	}
	public WebElement getSearchEdt() {
		return SearchEdt;
	}
	public void createSearchEdt(String vendername) {
		SearchEdt.sendKeys(vendername);
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getVenderName() {
		return venderName;
	}
	public WebElement getFileUploadLink() {
		return fileUploadLink;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	



}
