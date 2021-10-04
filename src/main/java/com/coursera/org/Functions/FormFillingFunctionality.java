package com.coursera.org.Functions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.coursera.org.Base.Base;
import com.coursera.org.Utilities.FileInput;
import com.coursera.org.Utilities.HighlighterAndScreenshotClass;

public class FormFillingFunctionality extends Base {

	HighlighterAndScreenshotClass hs = new HighlighterAndScreenshotClass();
	FileInput fi = new FileInput();

	/**
	 * This method is to locate form both Regression and Smoke testing
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void locateForm() throws InterruptedException, IOException {

		// Action function for hovering
		Actions action = new Actions(driver);

		// This is for highlighting and clicking the For Enterprise link
		WebElement forEnterpriseLink = driver.findElement(By.linkText("For Enterprise"));
		hs.highlighttElements(forEnterpriseLink);
		forEnterpriseLink.click();

		// This is for highlighting and clicking the product link link
		WebElement productsLink = driver.findElement(By.linkText("Products"));
		hs.highlighttElements(productsLink);
		action.moveToElement(productsLink).perform();

		// This is for implicit and sleep
		implicitWait(10);
		Thread.sleep(3000);

		// This is for highlighting and clicking for campus link
		scrollPage();
		driver.switchTo().defaultContent();
		WebElement forCampusLink = driver.findElement(By.linkText("For Campus"));
		hs.highlighttElements(forCampusLink);
		forCampusLink.click();

		implicitWait(2);
	}

	/**
	 * This method is to highlight firstName field and fill data into that field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillFirst_name(String f_Name) throws IOException, InterruptedException {

		// This is for highlighting and filling first name field
		WebElement f_NameElem = driver.findElement(By.id("FirstName"));
		hs.highlighttElements(f_NameElem);
		f_NameElem.sendKeys(f_Name);
	}

	/**
	 * This method is to highlight lastName field and fill data into that field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillLast_name(String l_Name) throws IOException, InterruptedException {

		// This is for highlighting and filling last name field
		WebElement l_NameElem = driver.findElement(By.id("LastName"));
		hs.highlighttElements(l_NameElem);
		l_NameElem.sendKeys(l_Name);
	}

	/**
	 * This method is to highlight Job Function field and fill data into that field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillJob_func(String job_Func) throws IOException, InterruptedException {

		// This is for highlighting and filling Job function field
		WebElement job_FuncElem = driver.findElement(By.id("C4C_Job_Title__c"));
		Select select = new Select(job_FuncElem);
		hs.highlighttElements(job_FuncElem);
		select.selectByVisibleText(job_Func);
	}

	/**
	 * This method is to highlight Job Title field and fill data into that field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillJob_title(String job_Title) throws IOException, InterruptedException {

		// This is for highlighting and filling Job title field
		WebElement job_TitleElem = driver.findElement(By.id("Title"));
		hs.highlighttElements(job_TitleElem);
		job_TitleElem.sendKeys(job_Title);
	}

	/**
	 * This method is to highlight Work email field and fill data into that field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillEmail(String work_Email) throws IOException, InterruptedException {

		// This is for highlighting and filling work email field
		WebElement work_EmailElem = driver.findElement(By.id("Email"));
		hs.highlighttElements(work_EmailElem);
		work_EmailElem.sendKeys(work_Email);
	}

	/**
	 * This method is to highlight phone number field and fill data into that field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillPhone_no(String phone_No) throws IOException, InterruptedException {

		// This is for highlighting and filling phone number field
		WebElement phone_NoElem = driver.findElement(By.id("Phone"));
		hs.highlighttElements(phone_NoElem);
		phone_NoElem.sendKeys(phone_No);
	}

	/**
	 * This method is to highlight Institute name field and fill data into that
	 * field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillInstitute_name(String institute_Name) throws IOException, InterruptedException {

		// This is for highlighting and filling Institue name field
		WebElement institute_NameElem = driver.findElement(By.id("Company"));
		hs.highlighttElements(institute_NameElem);
		institute_NameElem.sendKeys(institute_Name);
	}

	/**
	 * This method is to highlight Institute type field and fill data into that
	 * field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillInstitute_type(String institute_Type) throws IOException, InterruptedException {

		// This is for highlighting and filling Institute type field
		WebElement institute_TypeElem = driver.findElement(By.id("Institution_Type__c"));
		Select select1 = new Select(institute_TypeElem);
		hs.highlighttElements(institute_TypeElem);
		select1.selectByVisibleText(institute_Type);

	}

	/**
	 * This method is to highlight primary Discipline field and fill data into that
	 * field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillPrimary_dis(String primary_Dis) throws IOException, InterruptedException {

		// This is for highlighting and filling primary discipline field
		WebElement primary_DisElem = driver.findElement(By.id("Primary_Discipline__c"));
		Select select2 = new Select(primary_DisElem);
		hs.highlighttElements(primary_DisElem);
		select2.selectByVisibleText(primary_Dis);

	}

	/**
	 * This method is to highlight country field and fill data into that field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillCountry(String country) throws IOException, InterruptedException {

		// This is for highlighting and filling country field
		WebElement countryElem = driver.findElement(By.id("Country"));
		Select select3 = new Select(countryElem);
		hs.highlighttElements(countryElem);
		select3.selectByVisibleText(country);

	}

	/**
	 * This method is to highlight state field and fill data into that field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillState(String state) throws IOException, InterruptedException {

		// This is for highlighting and filling state field
		WebElement stateElem = driver.findElement(By.id("State"));
		Select select4 = new Select(stateElem);
		hs.highlighttElements(stateElem);
		select4.selectByVisibleText(state);

	}

	/**
	 * This method is to highlight comments field and fill data into that field
	 * 
	 * @param f_Name
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillTextArea(String textArea) throws IOException, InterruptedException {

		// This is for highlighting and filling comments field
		WebElement textAreaElem = driver.findElement(By.id("What_the_lead_asked_for_on_the_website__c"));
		hs.highlighttElements(textAreaElem);
		textAreaElem.sendKeys(textArea);
	}

	/**
	 * This method is to highlight Submit button and click the button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickSubmitButton() throws IOException, InterruptedException {

		// This is for highlighting and clicking submit button
		WebElement submitButton = findElementByXpath("//button[contains(text(),'Submit')]");
		hs.highlighttElements(submitButton);
		submitButton.click();
	}

	/**
	 * This method is to fill all values with 1 second interval
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fillAllValues() throws IOException, InterruptedException {

		// Initializing variables
		String f_Name = fi.getData("f_name");
		String l_Name = fi.getData("l_name");
		String job_Func = fi.getData("job_func");
		String job_Title = fi.getData("job_title");
		String work_Email = fi.getData("work_email");
		String phone_No = fi.getData("phone_no");
		String institute_Name = fi.getData("institute_name");
		String institute_Type = fi.getData("institute_type");
		String primary_Dis = fi.getData("primary_dis");
		String country = fi.getData("country");
		String state = fi.getData("state");
		String textArea = fi.getData("comments");

		fillFirst_name(f_Name);
		Thread.sleep(1000);

		fillLast_name(l_Name);
		Thread.sleep(1000);

		fillJob_func(job_Func);
		Thread.sleep(1000);

		fillJob_title(job_Title);
		Thread.sleep(1000);

		fillEmail(work_Email);
		Thread.sleep(1000);

		fillPhone_no(phone_No);
		Thread.sleep(1000);

		fillInstitute_name(institute_Name);
		Thread.sleep(1000);

		fillInstitute_type(institute_Type);
		Thread.sleep(1000);
		scrollPageBy(450);

		fillPrimary_dis(primary_Dis);
		Thread.sleep(1000);

		fillCountry(country);
		Thread.sleep(1000);

		fillState(state);
		Thread.sleep(1000);

		fillTextArea(textArea);
		Thread.sleep(1000);

		clickSubmitButton();
		Thread.sleep(1000);

	}

}
