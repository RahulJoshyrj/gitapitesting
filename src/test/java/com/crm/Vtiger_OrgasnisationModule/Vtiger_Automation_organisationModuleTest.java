package com.crm.Vtiger_OrgasnisationModule;

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
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.JavaUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.vtiger.objectrepository.ContactInfoPage;
import com.crm.vtiger.objectrepository.ContactPage;
import com.crm.vtiger.objectrepository.CreateContactPage;
import com.crm.vtiger.objectrepository.CreateOrganisationPage;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.LoginPage;
import com.crm.vtiger.objectrepository.OrganisationInfoPage;
import com.crm.vtiger.objectrepository.OrganisationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_Automation_organisationModuleTest {
/**
 * @author RJ
 * @param args
 * @throws IOException
 * @throws InterruptedException 
 */
	public static void main(String[] args) throws IOException, InterruptedException {
		//Loading property file
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		String url = fLib.getPrpertyValue("url");
		String username=fLib.getPrpertyValue("username");
		String password=fLib.getPrpertyValue("password");
		
		//loading excel sheet
		int randomNum = jLib.getRandomNumber();
		String orgname = eLib.getDataFromExcel("Sheet1", 2, 0)+randomNum;
		String website = eLib.getDataFromExcel("Sheet1", 2, 1);
		String address = eLib.getDataFromExcel("Sheet1", 2, 2);
		String shipadd = eLib.getDataFromExcel("Sheet1", 2, 3);
		String firstname=eLib.getDataFromExcel("contact", 3, 0);
		String lastname=eLib.getDataFromExcel("contact", 3,1);
		
		//loading/opening  chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//enter URL in chrome browser
		driver.get(url);
		//adding implicit wait of 10seconds
		wLib.waitTillPageLoad(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.LoginToApp(username, password);
		//click on organization link
		HomePage homepage=new HomePage(driver);
		homepage.getOrganisationLink().click();
		//click on create organizations link
		OrganisationPage organisationpage=new OrganisationPage(driver);
		organisationpage.getOrganisationLkpImg().click();
		//enter organization name
		CreateOrganisationPage createorganisationpage=new CreateOrganisationPage(driver);
		createorganisationpage.createOrg(orgname);
		//enter web site
		createorganisationpage.createWebsite(website);
//		//select value for type of industry from drop down
//		
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		createorganisationpage.selectIndustry("Technology");

		createorganisationpage.selectType("Prospect");
		
		
//		//save the organization
		createorganisationpage.getSaveBtn().click();
//
//		//click on contacts link
		OrganisationInfoPage organisationinfopage=new OrganisationInfoPage(driver);
		Thread.sleep(2000);
		organisationinfopage.getContactsLink().click();
//		//click on create contact 
		ContactPage contactpage=new ContactPage(driver);
		contactpage.getCntctLkpImg().click();
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		createcontactpage.createSalutation("Ms.");
		createcontactpage.createFirstName(firstname);
		createcontactpage.createLastName(lastname);
		createcontactpage.getSaveBtn().click();
		Thread.sleep(2000);
		ContactInfoPage contactinfopage=new ContactInfoPage(driver);
		contactinfopage.getSignOutLink();
		driver.close();

	}

}
