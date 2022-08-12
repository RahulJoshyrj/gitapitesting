package com.crm.VtigerLoginPageTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilities.BaseClass;
import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.JavaUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.vtiger.objectrepository.CreateOrganisationPage;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.LoginPage;
import com.crm.vtiger.objectrepository.OrganisationPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.comcast.GenericUtilities.ListnerImlTn.class)
public class vtiger_login_propertyfile extends BaseClass  {


	@Test(groups={"smokeTest","regressionTest"},retryAnalyzer=com.crm.comcast.GenericUtilities.RetryAnalyImp.class)
	public void vtiger_Login_propertyfileTest() throws IOException, InterruptedException {
		WebDriver driver=null;
		//initializing all generic utilities
		WebDriverUtility wLib = new WebDriverUtility(); 
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib=new JavaUtility();


		//get the values from the property file
		String browser = fLib.getPrpertyValue("browser");
		String url = fLib.getPrpertyValue("url");
		String username = fLib.getPrpertyValue("username");
		String password=fLib.getPrpertyValue("password");
//		//selecting the browser
//		if(browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();	
//		}
//		else if(browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//		}
//		else {
//			driver=new ChromeDriver();
//		}
		//initializing the random number method in java utility class 
		int RandomNum = jLib.getRandomNumber();
		//using Excel utility class to get data from the excel sheet to create organization
		String value = eLib.getDataFromExcel("Sheet1", 1, 1);
		String orgname=value+RandomNum;
		//maximize the page
		wLib.maximizeThePage(driver);
		//implicit wait from webdriver utility class
		wLib.waitTillPageLoad(driver);
		//entering login credentials
		driver.get(url);
		//login to Vtiger
		LoginPage loginpage=new LoginPage(driver);
		loginpage.LoginToApp(username, password);

		//creating new organization
		HomePage homepage=new HomePage(driver);
		homepage.getOrganisationLink().click();
		OrganisationPage organisationpage=new OrganisationPage(driver);
		organisationpage.getOrganisationLkpImg().click();
		CreateOrganisationPage createorganisationpage=new CreateOrganisationPage(driver);
		createorganisationpage.createOrg(orgname);
		createorganisationpage.getSaveBtn().click();
		WebElement adminlink=homepage.getAdministratorLink();
		Thread.sleep(3000);
		homepage.Logout(driver);
		driver.close();


	}

}
