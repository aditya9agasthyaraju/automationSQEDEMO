package com.sample.test.demo.tests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.reusables.TestBase;

public class PizzaPlaceOrderTest extends TestBase {
	private Logger console = Logger.getLogger(PizzaPlaceOrderTest.class);

	@Test(description = "verify whether user is able to place order or not")
	public void verifyPlaceOrderTest() throws Exception {
		console.info("###validating of placing pizza order verification begins###");
		try {
			ui.selectDropdownByIndex(obh.locator("pizza1"), "Pizza1", PizzaTypes.LARGE_THREETOPPINGS.ordinal() + 1);
			ui.selectDropdownByValue(obh.locator("pizza1Toppings1"), "Topping1", PizzaToppings.MANGOS.getDisplayName());
			ui.selectDropdownByValue(obh.locator("pizza1Toppings2"), "Topping2",
					PizzaToppings.EXTRACHEESE.getDisplayName());
			ui.enterText(obh.locator("pizza1Quantity"), "Quantity Textbox", "1");
			ui.enterText(obh.locator("pizza1Quantity"), "Quantity Textbox", Keys.chord(Keys.TAB));

			// enter
			ui.enterText(obh.locator("name"), "Name Textbox", config.getProperty("name"));
			ui.enterText(obh.locator("email"), "Email textbox", config.getProperty("email"));
			ui.enterText(obh.locator("phone"), "Phone Textbox", config.getProperty("phone"));
			ui.check(obh.locator("radioCreditCard"), "Credit Card Payment", true);

			ui.click(obh.locator("placeOrderButton"), "Place Order Button");

			assertEquals(ui.element(obh.locator("dialog")).isDisplayed(), true,
					"Place order modal is not being displayed");

			assertEquals(ui.getText(obh.locator("dialogText"), "Dialog Text"),
					"Thank you for your order! TOTAL: " +PizzaTypes.LARGE_THREETOPPINGS.getCost()+" "+PizzaTypes.LARGE_THREETOPPINGS.getDisplayName());

		} catch (Exception e) {
			console.error("error occured while validating the placing of pizza order");
			ui.takeSnapShot("Issue_In_verifyPizzaOrderCostTest");
			Assert.fail(e.getMessage());
		} finally {
			console.info("###validating of placing pizza order verification ends###");
		}
	}

}
