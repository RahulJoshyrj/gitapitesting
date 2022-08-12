package com.crm.AssestsModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.vtiger.objectrepository.AssetsPage;
import com.crm.vtiger.objectrepository.CreateAssetsPage;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_Automation_AssetsWithInvoice {

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
		double assetno=eLib.getNumericDataFromExcel("assets", 1, 0);
		double serialnumber=eLib.getNumericDataFromExcel("assets", 1, 1);
		double shippingTracknumber=eLib.getNumericDataFromExcel("assets", 1, 2);
		String productname=eLib.getDataFromExcel("assets", 1, 3);
		String invoicename=eLib.getDataFromExcel("assets", 1, 4);
		String customername=eLib.getDataFromExcel("assets", 1, 5);
		String assetname=eLib.getDataFromExcel("assets", 1, 6);
		homepage.mouseHoverMoreAndClickAssetsLink(driver);
		AssetsPage assetspage=new AssetsPage(driver);
		assetspage.getCreateAssetLkpImg().click();
		CreateAssetsPage createassetspage=new CreateAssetsPage(driver);
		createassetspage.createAssetNoEdt(assetno);
		
		driver.findElement(By.xpath("//input[@name='asset_no']")).sendKeys(String.valueOf(assetno));
		driver.findElement(By.xpath("//input[@name='serialnumber']")).sendKeys(String.valueOf(serialnumber));
		driver.findElement(By.xpath("//input[@name='shippingtrackingnumber']")).sendKeys(String.valueOf(shippingTracknumber));
		driver.findElement(By.xpath("//input[@name='assetname']")).sendKeys("assetname");
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]")).click();
		Set<String> invoicewindow = driver.getWindowHandles();
		for(String window:invoicewindow) {
			driver.switchTo().window(window);
		}
		driver.findElement(By.xpath("//a[text()='"+invoicename+"']")).click();
		driver.switchTo().window(parent);

		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		Set<String> productwindow = driver.getWindowHandles();
		for(String window:productwindow) {
			driver.switchTo().window(window);
		}
		driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
		driver.switchTo().window(parent);

		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[3]")).click();
		Set<String> customerwindow = driver.getWindowHandles();
		for(String window:customerwindow) {
			driver.switchTo().window(window);
		}
		driver.findElement(By.xpath("//a[text()='"+customername+"']")).click();
		driver.switchTo().window(parent);

		driver.findElement(By.xpath("(//img[@src='themes/softed/images/btnL3Calendar.gif'])[3]")).click();
		driver.findElement(By.xpath("//td[text()='22']")).click();

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();


	}

}
