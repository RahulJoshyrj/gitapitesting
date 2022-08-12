package com.crm.comcast.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author RJ
 *
 */
public class WebDriverUtility {
	/**
	 * maximize the web page
	 * @param driver
	 */
	public void maximizeThePage(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * minimize the browser
	 * @param driver
	 */
	public void minimizeThebrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * refresh the web page
	 * @param driver
	 */
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	/**
	 * navigate back to previous page
	 * @param driver
	 */
	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}
	/**
	 * navigate to forward to next page
	 * @param driver
	 */
	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}
	/**
	 * method to wait until the page loads
	 * @param driver
	 */
	public void waitTillPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.implicitwaitduraiton));
	}
	/**
	 * method to wait until the web element is clicked
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToClick(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitwaitduration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * method to wait until the element is visible
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitwaitduration));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	/**
	 * method to wait until the page with necessary title appears 
	 * @param driver
	 * @param title
	 */
	public void waitTillPageLoadTitle(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitwaitduration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * method to wait until the page with the necessary URL appears
	 * @param driver
	 * @param URL
	 */
	public void waitTillPageLoadURL(WebDriver driver,String URL) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitwaitduration));
		wait.until(ExpectedConditions.urlContains(URL));	
	}
	/**
	 * method to ignore no such element exception
	 * @param driver
	 */
	public void ignoreNoSuchElementException(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitwaitduration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * method to wait until the alert message appears
	 * @param driver
	 */
	public void waitForAlertMesage(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitwaitduration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * method to switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * method to switch frames based on id
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver,String id) {
		driver.switchTo().frame(id);
	}
	/**
	 * method to switch frame based on element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * method to switch frame to main frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * handle list based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * handle list based on value
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * handle list based on visible text
	 * @param text
	 * @param element
	 */
	public void select(String text,WebElement element) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * method to select all options in list
	 * @param element
	 */
	public void getAllOptionsFromDropDown(WebElement element) {
		Select select=new Select(element);
		List<WebElement> option = select.getOptions();
		for(WebElement webelement:option) {
			String text=webelement.getText();
			System.out.println(text);
		}

	}
	/**
	 * method to mouse over to a particular element
	 * @param driver
	 * @param element
	 */
	public void mouseoverOneElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();;
	}
	/**
	 * method to right click
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();;
	}
	/**
	 * method to double click
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick().perform();
	}
	/**
	 * method to click enter
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver) {
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * method to take screen shot
	 * @param driver
	 * @param screenshotname
	 */
	public void takeScreenShot(WebDriver driver,String screenshotname) {
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshots"+screenshotname+".PNG");
		try {
			FileUtils.copyFile(src, dst);

		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * method to wait and click using custom wait
	 * @param element
	 * @param duration
	 * @param pollingtime
	 */
	public void waitAndClickUsingCustomWait(WebElement element,int duration,long pollingtime) {
		int count=0;
		while(count<duration){
			try {element.click();
			break;
			}
			catch(Exception e){
				try {
					Thread.sleep(pollingtime);
				}
				catch(Exception e2) {
					e2.printStackTrace();
				}
				count++;

			}
		}	
	}
	/**
	 * method to switch window and verify the title
	 * @param driver
	 * @param actualTitle
	 */
	public void switchToWindow(WebDriver driver, String actualTitle) {
		Set<String> set = driver.getWindowHandles();
		for(String string:set) {
			driver.switchTo().window(string);
			String title=driver.getTitle();
			if(title.contains(actualTitle))
			{
				break;
			}

		}
	}
	/**
	 * method to switch back to main window
	 * @param driver
	 * @param parent
	 */
	public void switchToMainWindow(WebDriver driver, String parent) {
		driver.switchTo().window(parent);
	}
	/**
	 * method to switch window and verify url
	 * @param actualURL
	 * @param driver
	 */
	public void switchToWindow(String actualURL,WebDriver driver) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String>it=set.iterator();
		while(it.hasNext()) {
			String wId=it.next();
			driver.switchTo().window(wId);
			String url=driver.getCurrentUrl();
			if(url.contains(actualURL)) {
				break;
			}
		}

	}
	/**
	 * method to handle pop and accept the alert
	 * @param driver
	 * @param expectedmsg
	 */
	public void switchToAlertPopUpAndAccept(WebDriver driver,String expectedmsg) {
		Alert alert=driver.switchTo().alert();
		if(alert.getText().trim().equalsIgnoreCase(expectedmsg.trim())) {
			System.out.println("alert message is verified");
		}
		else {
			System.out.println("alert message not verified");
		}
		alert.accept();
	}
	public void switchToAlertPopUpAndAccept(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.accept();	
	}
	public void  switchToAlertPopUpAndDismiss(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	/**
	 * method to handle alert and dismiss the alert
	 * @param expectedmsg
	 * @param driver
	 */
	public void switchToAlertPopUpAndDismiss(String expectedmsg,WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		if(alert.getText().trim().equalsIgnoreCase(expectedmsg.trim())) {
			System.out.println("alert message is verified");
		}
		else {
			System.out.println("alert message not verified");
		}
		alert.dismiss();

	}
	public WebElement getLinkText(WebDriver driver,String linktext) {
		WebElement element=driver.findElement(By.xpath("//a[text()='"+linktext+"']"));
		return element;
	}

}




