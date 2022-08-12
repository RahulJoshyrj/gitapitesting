package com.crm.Vtiger_ContactModule;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.vtiger.objectrepository.ContactPage;
import com.crm.vtiger.objectrepository.CreateContactPage;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_automation_ContactModuleTest {

	public static void main(String[] args) throws IOException {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		String url=fLib.getPrpertyValue("url");
		String username=fLib.getPrpertyValue("username");
		String password=fLib.getPrpertyValue("password");

		driver.get(url);
		wLib.waitTillPageLoad(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.LoginToApp(username, password);
		HomePage homepage=new HomePage(driver);
		homepage.getContactsLink().click();
		ContactPage contactpage=new ContactPage(driver);
		contactpage.getCntctLkpImg().click();
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		String parent = driver.getWindowHandle();
		String firstname=eLib.getDataFromExcel("contact", 2, 0);
		String lastname=eLib.getDataFromExcel("contact", 2, 1);
		String salutation1=eLib.getDataFromExcel("contact", 2, 3);
		String emailString=eLib.getDataFromExcel("contact", 2, 2);
		String organisation=eLib.getDataFromExcel("contact", 2, 4);
		createcontactpage.createFirstName(firstname);
		createcontactpage.createLastName(lastname);
		createcontactpage.createSalutation(salutation1);
		createcontactpage.getAccountsAndactionLkpImg().click();
		wLib.switchToWindow("Accounts&action", driver);
		createcontactpage.createSearchOrganisation(organisation);
		createcontactpage.getSearchBtn().click();
		createcontactpage.getOrgName().click();
		wLib.switchToMainWindow(driver, parent);
		createcontactpage.getSaveBtn().click();
		driver.close();

	}

}
