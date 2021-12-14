package com.sample.test.demo.reusables;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIInteraction {

	private WebDriver driver;
	private WebDriverWait wait;
	private long waitTime;
	private Logger logger = Logger.getLogger(UIInteraction.class);

	public UIInteraction(WebDriver driver, long waitTime) {
		super();
		this.driver = driver;
		this.waitTime = waitTime;
		this.wait = new WebDriverWait(driver, waitTime);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}

	/**
	 * @description : this function will help to select the option from dropdown
	 * @param {By}     locator : locator for select dropdown
	 * @param {String} dropdownName : select dropdown name
	 * @param {String} option : which option to select
	 */
	public void selectDropdownByText(By locator, String dropdownName, String option) {
		logger.info(
				"Selecting option " + option + " from select dropdown " + dropdownName + " with locator " + locator);
		try {
			WebElement wb = element(locator);
			Select select = new Select(wb);
			select.selectByVisibleText(option);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("error occured while selecting option " + option + " fro select dropdown " + dropdownName
					+ " due to " + e.getMessage());
		}
	}

	/**
	 * @description : this function will help to select the option from dropdown
	 * @param {By}     locator : locator for select dropdown
	 * @param {String} dropdownName : select dropdown name
	 * @param {int}    option : which option to select
	 */
	public void selectDropdownByIndex(By locator, String dropdownName, int index) {
		logger.info("Selecting option " + index + " from select dropdown " + dropdownName + " with locator " + locator);
		try {
			WebElement wb = element(locator);
			Select select = new Select(wb);
			select.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("error occured while selecting option " + index + " fro select dropdown " + dropdownName
					+ " due to " + e.getMessage());
		}
	}

	/**
	 * @description : this function will help to select the option from dropdown
	 * @param {By}     locator : locator for select dropdown
	 * @param {String} dropdownName : select dropdown name
	 * @param {String} value : which value to select
	 */
	public void selectDropdownByValue(By locator, String dropdownName, String value) {
		logger.info("Selecting option " + value + " from select dropdown " + dropdownName + " with locator " + locator);
		try {
			WebElement wb = element(locator);
			Select select = new Select(wb);
			select.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("error occured while selecting option " + value + " fro select dropdown " + dropdownName
					+ " due to " + e.getMessage());
		}
	}

	/**
	 * @description : This function will enter the data in input textbox
	 * @param {By}     locator : locator for Input Textbox
	 * @param {String} InputBoxName : Input Text box name
	 * @param {String} text : which value to select
	 */
	public void enterText(By locator, String InputBoxName, String text) {
		logger.info("Entering text  " + text + " in unput text box " + InputBoxName + " with locator " + locator);
		try {
			WebElement wb = element(locator);
			wb.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("error occured while Entering text  " + text + " in unput text box " + InputBoxName
					+ " with locator " + locator + " due to " + e.getMessage());
		}
	}

	/**
	 * @description : This function will get text from element
	 * @param {By}     locator : locator for Input Textbox
	 * @param {String} elementName :element Name
	 * @return : String
	 */
	public String getText(By locator, String elementName) {
		String text = null;
		logger.info("Getting text from" + elementName + " with locator " + locator);
		try {
			WebElement wb = element(locator);
			text = wb.getText().trim();
			logger.info("text " + text + " get retrived from " + locator);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("error occured while Getting text from" + elementName + " with locator " + locator + " due to "
					+ e.getMessage());
		}
		return text;
	}

	/**
	 * @description : This function will get text from element
	 * @param {By}     locator : locator for Input Textbox
	 * @param {String} elementName :element Name
	 * @param {String} attribute :attribute Name
	 * @return : String
	 */
	public String getValue(By locator, String elementName, String attribute) {
		String value = null;
		logger.info("Getting attribute " + attribute + " from" + elementName + " with locator " + locator);
		try {
			WebElement wb = element(locator);
			value = wb.getAttribute(attribute).trim();
			logger.info("text " + value + " get retrived from " + locator);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("error occured while Getting text from" + elementName + " with locator " + locator + " due to "
					+ e.getMessage());
		}
		return value;
	}

	/**
	 * @description : This function will click on element based on the locator
	 *              provided
	 * @param {By}     locator : locator for clickable element
	 * @param {String} elementName : elementName
	 */
	public void click(By locator, String elementName) {
		logger.info("Clicking on element " + elementName + " with locator " + locator);
		try {
			WebElement wb = element(locator);
			waitUntilElementClickable(locator);
			wb.click();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("error occured while Clicking on element " + elementName + " with locator " + locator
					+ " due to " + e.getMessage());
		}
	}

	public void takeSnapShot( String fileName) throws Exception {
		String filePath = System.getProperty("user.dir") + "/screenshot/" + fileName + ".png";
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(filePath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public WebElement element(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitUntilElementClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitUntilElementVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
