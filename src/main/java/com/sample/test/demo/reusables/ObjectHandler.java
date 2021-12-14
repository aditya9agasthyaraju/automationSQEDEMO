package com.sample.test.demo.reusables;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.sample.test.demo.constants.Identifiers;

public class ObjectHandler {

	private String filePath;
	private Logger console = Logger.getLogger(ObjectHandler.class);

	public ObjectHandler(String filePath) {
		super();
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @description : This function will return the locator on the basis of
	 *              pageObjectName passed
	 * @param {String} pageObject : Name of the locator given under the file which
	 *                 is under src/test/resources/file
	 * 
	 */
	public By locator(String pageObjectName) {
		By locator = null;
		InputStream ins = null;
		Reader r = null;
		BufferedReader br = null;
		String s;
		String text = null;
		try {

			ins = new FileInputStream(filePath);
			r = new InputStreamReader(ins, "UTF-8");
			br = new BufferedReader(r);
			// reading the file & breaking the loop if find out
			while ((s = br.readLine()) != null) {
				if (s.contains(pageObjectName)) {
					text = s;
					console.info("found the Object value as " + s + " for " + pageObjectName);
					break;
				} else {
					continue;
				}

			}
			String locatortext = text.replaceAll("\\s+", " ");
			console.info(locatortext);
			console.info(
					locatortext.split(" ")[0] + "##" + locatortext.split(" ")[1] + "##" + locatortext.split(" ")[2]);
			
			System.out.println(locatortext.split(" ")[1].trim());
			locator = locateElement(Identifiers.valueOf(locatortext.split(" ")[1].trim().toUpperCase()), locatortext.split(" ")[2].replaceAll("\"", "").trim());
		} catch (Exception e) {
			e.printStackTrace();
			console.error("error occured while fetching the page object" + e.getMessage());
		} finally {
			if (locator == null)
				console.info("No Object found for " + pageObjectName);
			else
				console.info("Object found as " + locator + " for the object Name " + pageObjectName);
		}
		return locator;
	}

	/**
	 * @description : This function will return the locator on the basis of
	 *              identifiers & locator value passed
	 * @param {Identifiers} identifiers : Identifier type i.e. ID, XPATH, CSS etc
	 * @param {String}      locatorValue : locator value which got retrieved from
	 *                      .txt file
	 * 
	 */
	public By locateElement(Identifiers identifiers, String locatorValue) {
		By pageObject = null;
		switch (identifiers) {
		case ID:
			pageObject = By.id(locatorValue);
			break;
		case XPATH:
			pageObject = By.xpath(locatorValue);
			break;
		case CSS:
			pageObject = By.cssSelector(locatorValue);
			break;
		case TAGNAME:
			pageObject = By.tagName(locatorValue);
			break;
		case CLASSNAME:
			pageObject = By.className(locatorValue);
			break;
		case LINKTEXT:
			pageObject = By.linkText(locatorValue);
			break;
		case PARTIALLINKTEXT:
			pageObject = By.partialLinkText(locatorValue);
			break;
		default:
			console.info("Please pass the proper identifier as there is no value available for "
					+ identifiers.getValue() + " for locator value " + locatorValue);
			break;
		}
		return pageObject;
	}

}
