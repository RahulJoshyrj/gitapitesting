package com.crm.VtigerLoginPageTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_InsertMultipleValueIntoExcelTest {
@Test(groups="smokeTest")
	public void vtiger_InsertMultipleVlaueIntoExcelTest() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		String url = fLib.getPrpertyValue("url");
		String username=fLib.getPrpertyValue("username");
		String password=fLib.getPrpertyValue("password");
		
		
		FileInputStream fileinputstream=new FileInputStream("./src/test/resources/testdata.xlsx");
		 Workbook workbook=WorkbookFactory.create(fileinputstream);
		 Sheet sheet = workbook.getSheet("Sheet3");
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 	driver.get(url);
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			
			List<WebElement> alllink = driver.findElements(By.xpath("//a"));
			for(int i=1;i<alllink.size();i++) {
				Row row = sheet.createRow(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(alllink.get(i).getAttribute("href"));
				
			}
			FileOutputStream fot=new FileOutputStream("./src/test/resources/testdata.xlsx");
			workbook.write(fot);
	}

}
