package com.crm.ProductModule;

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
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.vtiger.objectrepository.CreateProductsPage;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.LoginPage;
import com.crm.vtiger.objectrepository.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_automation_ProductModuleTest {

	public static void main(String[] args) throws IOException {
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String url=fLib.getPrpertyValue("url");
		String username=fLib.getPrpertyValue("username");
		String password=fLib.getPrpertyValue("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		wLib.waitTillPageLoad(driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.LoginToApp(username, password);	
		String productname = eLib.getDataFromExcel("product", 1, 0);
		HomePage homepage=new HomePage(driver);
		homepage.getProductsLink().click();
		String parent = driver.getWindowHandle();
		ProductsPage productspage=new ProductsPage(driver);
		productspage.getCreateProductLkpImg().click();
		CreateProductsPage createproductpage=new CreateProductsPage(driver);
		createproductpage.createProductEdt(productname);
		driver.findElement(By.xpath("//img[@title='Open Calendar...']")).click();
		
		String categoryName = eLib.getDataFromExcel("product", 1, 1);
		createproductpage.selectProductCategoryDrpDwn(categoryName);
		createproductpage.getVendorLkpImg().click();
		
		wLib.switchToWindow("Vendors&action", driver);
		String vendername = eLib.getDataFromExcel("product", 1, 2);
		createproductpage.createSearchEdt(vendername);
		createproductpage.getSearchBtn().click();
		createproductpage.getVenderName().click();
		wLib.switchToMainWindow(driver, parent);	
		WebElement upload =createproductpage.getFileUploadLink();
		upload.sendKeys("C:\\\\Users\\\\RJ\\\\Desktop\\TYSS NOTES\\ddt and jdbc.png");
		createproductpage.getSaveBtn().click();
		homepage.Logout(driver);
		driver.close();
		
		
	}

}
