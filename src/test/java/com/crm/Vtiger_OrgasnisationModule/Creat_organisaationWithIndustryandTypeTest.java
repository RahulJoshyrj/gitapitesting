package com.crm.Vtiger_OrgasnisationModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilities.BaseClass;
import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.JavaUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Creat_organisaationWithIndustryandTypeTest extends BaseClass {
	@Test(groups="regressionTest")

	public void createOrganisationWithIndustryType() throws InterruptedException, IOException {
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		String url = fLib.getPrpertyValue("url");
		String username=fLib.getPrpertyValue("username");
		String password=fLib.getPrpertyValue("password");
		int randomNum = jLib.getRandomNumber();
		String orgname = eLib.getDataFromExcel("Sheet1", 3, 0)+randomNum;
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		wLib.waitTillPageLoad(driver);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		wLib.select(industry, "Technology");
		
		
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys("technoelevate@gmail.com");
		
		WebElement type = driver.findElement(By.xpath("(//select[@name='accounttype'])"));
		wLib.select(type, "Investor");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseoverOneElement(driver, target);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
