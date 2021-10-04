package com.coursera.org.Base;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.coursera.org.Utilities.GenerateReport;

/**
 * This class extends GenerateReport class to generate HTML exten reprt
 * 
 * @author LEGION
 *
 */
public class Base extends GenerateReport {

	public static WebDriver driver;

	/****** Invoke Browser *********/
	/**
	 * This method is to initialize the web driver for the browser
	 * 
	 * @return WebDriver
	 */
	public WebDriver createDriver() {

		driver = DriverSetup.setDriver();
		return driver;
	}

	/****** Open URL *********/
	/**
	 * This method is to load URL into the browser
	 * 
	 * @param websiteURL
	 */
	public void openURL(String websiteURL) {
		driver.get(websiteURL);
	}

	/****** Refresh *********/
	/**
	 * This method is to refresh the page and its contents
	 */
	public void refresh() {
		driver.navigate().refresh();
	}

	/****** Get Page Title *********/
	/**
	 * This method is to get the title of the page
	 * 
	 * @return String
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/****** Return Home *********/
	/**
	 * This method is to navigate the page to home page
	 */
	public void returnhome() {
		driver.navigate().to("https://www.coursera.org/in");
	}

	/****** Close Browser *********/
	/**
	 * This method is to close the browser but not to close the drivers
	 */
	public void tearDown() {
		driver.close();
	}

	/****** Quit Browser *********/
	/**
	 * This method is to close the browser and to close the driver.
	 */
	public void quitBrowser() {
		driver.quit();
	}

	/****** Implicit Wait *********/
	/**
	 * This method is used to implement implicit wait which takes seconds as input
	 * 
	 * @param secs
	 */
	public void implicitWait(int secs) {

		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}

	/****** Page Load out *********/
	/**
	 * This method is to check the page load out time by taking seconds as input
	 * 
	 * @param secs
	 */
	public void pageLoadOut(int secs) {

		driver.manage().timeouts().pageLoadTimeout(secs, TimeUnit.SECONDS);
	}

	/****** Finding WebElement *********/
	/**
	 * This method is to find the web element ny giving xpath of the web element as
	 * input
	 * 
	 * @param xpath
	 * @return WebElement
	 */
	public WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/****** Scroll Page *********/
	/**
	 * This method is to scroll the page to bottom
	 */
	public void scrollPage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	/****** Scroll Page By *********/
	/**
	 * This method is to scroll page by giving number of pixels as input
	 * 
	 * @param pixel
	 */
	public void scrollPageBy(int pixel) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0," + pixel + ")");

	}

	/****** Close Bot *********/
	/**
	 * This method is to close the bot that loads when Coursera enterprise page is
	 * opened
	 */
	public void closeBot() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div[1]/div/button[1]")));
		WebElement botCloseButton = findElementByXpath("//*[@id='root']/div[1]/div/button[1]");
		botCloseButton.click();

	}

	/****** List To Map Conversion *********/
	/**
	 * This method is to convert list into map by taking two String lists as input
	 * 
	 * @param field
	 * @param count
	 * @return
	 */
	public HashMap<String, String> convertListToString(List<String> field, List<String> count) {

		HashMap<String, String> fld_cnt = new HashMap<String, String>();

		for (int i = 0; i < field.size(); i++) {

			String fld = field.get(i);
			String cnt = count.get(i);
			fld_cnt.put(fld, cnt);
		}
		return fld_cnt;
	}

}