package com.crm.InvoiceModule;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.JavaUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.vtiger.objectrepository.CreateInvoicePage;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.InvoicePage;
import com.crm.vtiger.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_Automation_CreatInvoiceTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		int randomNum = jLib.getRandomNumber();
		String url=fLib.getPrpertyValue("url");
		String username=fLib.getPrpertyValue("username");
		String password=fLib.getPrpertyValue("password");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		wLib.waitTillPageLoad(driver);
		String subject=eLib.getDataFromExcel("invoice", 1, 0)+randomNum;
		String billingadd=eLib.getDataFromExcel("invoice", 1, 1);
		String shippingadd=eLib.getDataFromExcel("invoice", 1, 2);
		String orgname=eLib.getDataFromExcel("invoice", 1, 3);
		String salesorder=eLib.getDataFromExcel("invoice", 1, 4);
		String product_name=eLib.getDataFromExcel("invoice", 1, 5);
		//go to vtiger login in
		driver.get(url);
		//enter login credentials
		LoginPage loginpage=new LoginPage(driver);
		loginpage.LoginToApp(username, password);
		//mouse hover to more tab in home page
		HomePage homepage=new HomePage(driver);
		homepage.mouseHoverMoreAndClickInvoiceLink(driver);
		InvoicePage invoicepage=new InvoicePage(driver);
		invoicepage.getCreateInvoiceLkpImg().click();
		String parent = driver.getWindowHandle();
		//enter subject
		CreateInvoicePage createinvoicepage=new CreateInvoicePage(driver);
		createinvoicepage.createSubjectEdt(subject);
		createinvoicepage.getSalesorderActionLkpImg().click();
		wLib.switchToWindow("SalesOrder&action", driver);
		 WebElement salesorderLink = createinvoicepage.getLinktext(driver, salesorder);
		 salesorderLink.click();
		
		 wLib.switchToMainWindow(driver, parent);
		//select organization
		 createinvoicepage.getOrganisationLkpImg().click();
		wLib.switchToWindow(driver, "Accounts&action");
		createinvoicepage.getLinkText(driver, orgname).click();
		 wLib.switchToAlertPopUpAndAccept(driver);;
		wLib.switchToMainWindow(driver, parent);
		createinvoicepage.getSaveBtn().click();
		homepage.Logout(driver);
		driver.close();











	}

}
