package com.crm.OpportunitiesModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.JavaUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.vtiger.objectrepository.CreateOpportunitiesPage;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.LoginPage;
import com.crm.vtiger.objectrepository.OpportunitiesPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_automation_OpportunitiesModuleTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();

		String url=fLib.getPrpertyValue("url");
		String username=fLib.getPrpertyValue("username");
		String password=fLib.getPrpertyValue("password");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		wLib.waitTillPageLoad(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.LoginToApp(username, password);
		HomePage homepage=new HomePage(driver);
		homepage.getOpportunityLink().click();
		String parent=driver.getWindowHandle();
		OpportunitiesPage opportunitypage=new OpportunitiesPage(driver);
		opportunitypage.getOpportunityLkpImg().click();
		String potentialname = eLib.getDataFromExcel("opportunity", 1, 0);
		CreateOpportunitiesPage createopportunitiespage=new CreateOpportunitiesPage(driver);
		createopportunitiespage.createPotentialNameEdt(potentialname);
		createopportunitiespage.getAccountsActionLkpImg().click();
		wLib.switchToWindow("Accounts&action", driver);
		String organizationName=eLib.getDataFromExcel("opportunity", 1, 1);
		createopportunitiespage.createSearchEdt(organizationName);
		createopportunitiespage.getSearchBtn().click();
		Thread.sleep(2000);
		createopportunitiespage.getOrgName().click();
		wLib.switchToMainWindow(driver, parent);
		String type=eLib.getDataFromExcel("opportunity", 1, 2);
		createopportunitiespage.selectOppType(type);
		createopportunitiespage.getAccountsActionLkpImg().click();
		wLib.switchToWindow("Campaigns&action", driver);
		String campaign=eLib.getDataFromExcel("opportunity", 1, 3);
		createopportunitiespage.createSearchEdt(campaign);
		createopportunitiespage.getSearchBtn().click();
		createopportunitiespage.getCampaignName().click();
		wLib.switchToMainWindow(driver, parent);
		String salesStage = eLib.getDataFromExcel("opportunity", 1, 4);
		createopportunitiespage.selectSalesStage(salesStage);
		createopportunitiespage.getCalenderPopUp().click();
		createopportunitiespage.getDate().click();
		createopportunitiespage.getSaveBtn().click();
		homepage.Logout(driver);
		driver.close();


	}

}
