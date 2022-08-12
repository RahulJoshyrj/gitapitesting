package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAssetsPage {
	@FindBy(xpath="//input[@name='asset_no']") private WebElement assetNoEdt;
	@FindBy(xpath="//input[@name='serialnumber']")private WebElement serialNumEdt;
	@FindBy(xpath="//input[@name='shippingtrackingnumber']") private WebElement shipptrackNumEdt;
	@FindBy(xpath="//input[@name='assetname']")private WebElement assetNameEdt;
	
	public CreateAssetsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAssetNoEdt() {
		return assetNoEdt;
	}
	public void createAssetNoEdt(double assetno) {
		assetNoEdt.sendKeys(String.valueOf(assetno));
	}

	public WebElement getSerialNumEdt() {
		return serialNumEdt;
	}
	public void createSerialNumEdt(int serialNum) {
		serialNumEdt.sendKeys(String.valueOf(serialNum));
	}
	public WebElement getShipptrackNumEdt() {
		return shipptrackNumEdt;
	}
	public void createShipTractNumEdt(int shiptrackNum) {
		shipptrackNumEdt.sendKeys(String.valueOf(shiptrackNum));
	}

	public WebElement getAssetNameEdt() {
		return assetNameEdt;
	}
	public void createAssetNameEdt(String assetname) {
		assetNameEdt.sendKeys(assetname);
	}
	
	
	

}
