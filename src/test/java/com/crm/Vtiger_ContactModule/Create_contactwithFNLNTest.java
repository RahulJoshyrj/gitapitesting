package com.crm.Vtiger_ContactModule;

import java.io.IOException;
import java.time.Duration;

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
import com.crm.vtiger.objectrepository.ContactPage;
import com.crm.vtiger.objectrepository.CreateContactPage;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_contactwithFNLNTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
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
		homepage.getMoreLink().click();
		ContactPage contactpage=new ContactPage(driver);
		contactpage.getCntctLkpImg().click();
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		createcontactpage.createSalutation("Mrs.");
		
		String firstname = eLib.getDataFromExcel("contact", 1, 0);
		createcontactpage.createFirstName(firstname);
		String lastname = eLib.getDataFromExcel("contact", 1, 1);
		createcontactpage.createLastName(lastname);
		String email = eLib.getDataFromExcel("contact", 1, 2);
		createcontactpage.createEmail(email);
		createcontactpage.getSaveBtn().click();
		
		Thread.sleep(2000);
		homepage.Logout(driver);
		driver.close();
		
	}

}
