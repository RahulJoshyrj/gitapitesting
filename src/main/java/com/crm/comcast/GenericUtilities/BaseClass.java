package com.crm.comcast.GenericUtilities;
/**
 * 
 * @author SanjayBabu
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility  wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();

	/**
	 * connecting to database
	 */
//	@BeforeSuite
//	public void dbConfig()
//	{
//		dLib.connectionToDB();
//	}
	/**
	 * launching the browser
	 * @throws Throwable
	 */
//	@Parameters("BROWSER")
	@BeforeClass
	(groups= {"smokeTest","regressionTest"})
	public void launchTheBrowser(String BROWSER)
	{  
		
		try {
			BROWSER = fLib.getPrpertyValue("browser");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(BROWSER);
		String URL = null;
		try {
			URL = fLib.getPrpertyValue("url");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().create();
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			//	ChromeOptions chromeOptions=new ChromeOptions();
			//	chromeOptions.setBinary("C:\\Users\\SanjayBabu\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			//	driver=new ChromeDriver(chromeOptions);
			WebDriverManager.chromedriver().create();
			driver=new ChromeDriver();
		}
		else {
			driver=new ChromeDriver();
		}

		System.out.println("Browser successfully launched");
		//implicitly wait
		sdriver=driver;
		wLib.waitTillPageLoad(driver);
		//enter the URL of the Application
		sdriver.get(URL);
		//maximize the screen
		driver.manage().window().maximize();
	}
	/**
	 * login to application
	 */
	@BeforeMethod
	public void loginToAppln()
	{
		String USERNAME = null;
		try {
			USERNAME = fLib.getPrpertyValue("username");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		String PASSWORD = null;
		try {
			PASSWORD = fLib.getPrpertyValue("password");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		LoginPage loginpage=new LoginPage(driver);
		loginpage.LoginToApp(USERNAME, PASSWORD);
		
	}
	/**
	 * logout from application
	 */
	@AfterMethod
	public void logoutFromAppln()
	{
		HomePage homepage=new HomePage(driver);
		homepage.Logout(driver);
		System.out.println("Logout successful");
	}
	/**
	 * close the browser
	 */
	@AfterClass
	public void closeTheBrowser()
	{
		driver.quit();
		System.out.println("Browser successfully closed");
	}
	/**
	 * close database configuration
	 */
//	@AfterSuite
//	public void closeDBconfig()
//	{
//		dLib.closeDB();
//	}
}