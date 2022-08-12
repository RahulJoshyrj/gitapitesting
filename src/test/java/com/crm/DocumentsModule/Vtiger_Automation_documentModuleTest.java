package com.crm.DocumentsModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.JavaUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.vtiger.objectrepository.CreateDocumentPage;
import com.crm.vtiger.objectrepository.DocumentPage;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_Automation_documentModuleTest {

	public static void main(String[] args) throws IOException {
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
		LoginPage loginpage=new LoginPage(driver);
		loginpage.LoginToApp(username, password);
		wLib.waitTillPageLoad(driver);
		HomePage homepage=new HomePage(driver);
		homepage.getDocumentLink().click();
		DocumentPage documentpage=new DocumentPage(driver);
		documentpage.getDocumentLkpImg().click();
		String title=eLib.getDataFromExcel("document", 1, 0)+randomNum;
		CreateDocumentPage createdocumentpage=new CreateDocumentPage(driver);
		createdocumentpage.createTitleEdt(title);
		String fileAddress=eLib.getDataFromExcel("document", 1, 1);
		createdocumentpage.getFileUploadLink().sendKeys(fileAddress);
		
		
		String message=eLib.getDataFromExcel("document", 1, 2);
		createdocumentpage.switchFrameAndSendText(driver, 0, message);
		
		createdocumentpage.getSaveBtn().click();
		homepage.Logout(driver);
		driver.close();

	}

}
