package com.coursera.org.Functions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.coursera.org.Base.Base;
import com.coursera.org.Utilities.FileInput;
import com.coursera.org.Utilities.FileOutput;
import com.coursera.org.Utilities.HighlighterAndScreenshotClass;

public class LanguageLearningCoursesCount extends Base {

	HighlighterAndScreenshotClass hs = new HighlighterAndScreenshotClass();
	FileInput fi = new FileInput();
	FileOutput fo = new FileOutput();

	/**
	 * This method is to language learning page from home screen
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void loadLanguageLearningPage() throws InterruptedException, IOException {

		// This is for highlighting and filling search box
		WebElement searchBox = findElementByXpath("//input[@type='text' and @role='textbox']");
		hs.highlighttElements(searchBox);
		searchBox.sendKeys(fi.getData("course_name2"));
		Thread.sleep(1000);

		// This is for highlighting and clicking search icon
		WebElement searchIcon = findElementByXpath(
				"//*[@id='rendered-content']/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div");
		hs.highlighttElements(searchIcon);
		searchIcon.click();
		implicitWait(5000);

	}

	/**
	 * This method is to apply language filter and to fetch language details
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void languageFilter() throws InterruptedException, IOException {

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(
				findElementByXpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/span")));

		// This is for highlighting and clicking drop down icon
		WebElement dropDownIcon = findElementByXpath(
				"//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/span");
		hs.highlighttElements(dropDownIcon);
		dropDownIcon.click();

		// This is for highlighting and clicking show all link
		WebElement showAllOpt = findElementByXpath("//button[contains(text(),'Show All')]");
		hs.highlighttElements(showAllOpt);
		showAllOpt.click();

		// This is for retrieving data and storing them as a list
		hs.takeScreenshot("LanguageCount");
		List<WebElement> languages_names = driver
				.findElements(By.xpath("//div[@class='c-modal-content']//div[@class='checkboxText']"));
		List<WebElement> languages_count = driver
				.findElements(By.xpath("//div[@class='c-modal-content']//div[@class='filter-count']"));

		// This is for adding language web elements into String list
		List<String> languageNames = new ArrayList<String>();
		int i = 0;
		for (WebElement names : languages_names) {
			String name = names.getText();
			languageNames.add(i, name);
			i++;
		}
		languageNames.add(i, "Total Languages");

		// This is for adding language web elements into String list
		List<String> languageCount = new ArrayList<String>();
		int j = 0;
		int t_langcount = 0;
		for (WebElement count : languages_count) {
			String cnt = count.getText().replace("(", "").replace(")", "");
			int cntt = Integer.parseInt(cnt);
			t_langcount = t_langcount + cntt;
			languageCount.add(j, cnt);
			j++;
		}
		languageCount.add(j, Integer.toString(t_langcount));

		// This is for printing language values in excel
		fo.printValues(0, 0, "Languages", "Count", 1);
		for (int k = 0; k < languageCount.size(); k++) {

			int cnt = Integer.parseInt(languageCount.get(k));
			fo.printValues(k + 1, 0, languageNames.get(k), cnt, 1);
		}

		// This is for adding String list language values into
		HashMap<String, String> map = convertListToString(languageNames, languageCount);
		System.out.println("\nLanguage and its count");
		System.out.println("======================");
		for (Map.Entry<String, String> values : map.entrySet()) {
			System.out.println(values.getKey() + "-" + values.getValue());
		}
		System.out.println(languageNames.get(50) + "-" + languageCount.get(50));

	}

	/**
	 * This method is for highlighting and clicking close icon in language page
	 * 
	 * @throws InterruptedException
	 */
	public void closeLanguageFilter() throws InterruptedException {
		WebElement closeBtn = findElementByXpath(
				"//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[3]/div/div[3]/div[3]/a");
		hs.highlighttElements(closeBtn);
		closeBtn.click();
	}

	/**
	 * This method is to apply level filter and to fetch language details
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void levelFilter() throws InterruptedException, IOException {

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(
				findElementByXpath("//*[@id='main']/div/div[2]/div/div[2]/div[2]/div/div[1]/div/span")));

		// This is for highlighting and clicking drop down icon
		WebElement dropDownIcon = findElementByXpath(
				"//*[@id='main']/div/div[2]/div/div[2]/div[2]/div/div[1]/div/span");
		hs.highlighttElements(dropDownIcon);
		dropDownIcon.click();
		hs.takeScreenshot("LevelCount");

		// This is for retrieving data and storing level data as a list
		List<WebElement> level_names = driver.findElements(By.xpath("//div[@class='checkboxText']"));
		List<WebElement> level_count = driver.findElements(By.xpath("//div[@class='filter-count']"));

		// This is for adding level web elements into String list
		List<String> levelNames = new ArrayList<String>();
		int i = 0;
		for (WebElement names : level_names) {
			String name = names.getText();
			levelNames.add(i, name);
			i++;
		}
		levelNames.add(i, "Total Languages");

		// This is for adding level web elements into String list
		List<String> levelCount = new ArrayList<String>();
		int j = 0;
		int t_lvlcount = 0;
		for (WebElement count : level_count) {
			String cnt = count.getText().replace("(", "").replace(")", "");
			levelCount.add(j, cnt);
			int cntt = Integer.parseInt(cnt);
			t_lvlcount = t_lvlcount + cntt;
			j++;
		}
		levelCount.add(j, Integer.toString(t_lvlcount));

		// This is for printing level values in excel
		fo.printValues(0, 0, "Levels", "Count", 2);
		for (int k = 0; k < levelCount.size(); k++) {

			int cnt = Integer.parseInt(levelCount.get(k));
			fo.printValues(k + 1, 0, levelNames.get(k), cnt, 2);
		}

		// This is for converting list to map and storing level values into it
		System.out.println("\nLevels and its count");
		System.out.println("====================");
		HashMap<String, String> map = convertListToString(levelNames, levelCount);
		for (Map.Entry<String, String> values : map.entrySet()) {
			System.out.println(values.getKey() + "-" + values.getValue());
		}

	}

}
