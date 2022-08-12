package com.crm.Vtiger_EmailModule;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.JavaUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.vtiger.objectrepository.ComposeEmailPage;
import com.crm.vtiger.objectrepository.EmailPage;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_automation_EmailModuleTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		String url = fLib.getPrpertyValue("url");
		String username=fLib.getPrpertyValue("username");
		String password=fLib.getPrpertyValue("password");
		driver.get(url);
		wLib.waitTillPageLoad(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.LoginToApp(username, password);
		HomePage homepage=new HomePage(driver);
		homepage.getEmailLink().click();
		String parent = driver.getWindowHandle();
		EmailPage emailpage=new EmailPage(driver);
		emailpage.getComposeLink().click();
		wLib.switchToWindow(driver, "Compose Mail");
		ComposeEmailPage composeemail=new ComposeEmailPage(driver);
		composeemail.createToEdt("thadathiljoshy@gmail.com");
		composeemail.createSubjectEdt("appreciation Mail");
		wLib.switchToFrame(driver, 0);
		WebElement el = driver.switchTo().activeElement();
		Actions a=new Actions(driver);
		a.moveToElement(el).perform();
		el.sendKeys("confirmation mail");
		wLib.switchToMainFrame(driver);
		String compose = driver.getWindowHandle();
		composeemail.getContactLkpImg().click();
		wLib.switchToWindow("Contacts&action", driver);
		composeemail.getSearchEdt().sendKeys("Rahul joshy");
		composeemail.getSearchBtn().click();
		composeemail.getContactName().click();

		wLib.switchToMainWindow(driver,compose);
		composeemail.getSaveBtn().click();
		composeemail.getSendBtn().click();
		wLib.switchToMainWindow(driver, parent);
		homepage.Logout(driver);
		driver.close();
	}

}
