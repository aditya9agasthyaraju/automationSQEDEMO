package com.sample.test.demo.tests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.reusables.TestBase;

public class PizzaOrderCostTest extends TestBase {
	private Logger console = Logger.getLogger(PizzaOrderCostTest.class);

	@Test(description = "verify whether cost of the pizza is getting updated for the selected pizza")
	public void verifyPizzaOrderCostTest() throws Exception {
		console.info("###validating of pizza cost verification begins###");
		try {
			ui.selectDropdownByIndex(obh.locator("pizza1"), "Pizza1", PizzaTypes.LARE_NOTOPPINGS.ordinal() + 1);
			ui.selectDropdownByValue(obh.locator("pizza1Toppings1"), "Topping1", PizzaToppings.MANGOS.getDisplayName());
			ui.selectDropdownByValue(obh.locator("pizza1Toppings2"), "Topping2",
					PizzaToppings.EXTRACHEESE.getDisplayName());
			ui.enterText(obh.locator("pizza1Quantity"), "Quantity Textbox", "1");
			ui.enterText(obh.locator("pizza1Quantity"), "Quantity Textbox", Keys.chord(Keys.TAB));

			assertEquals(ui.getValue(obh.locator("pizza1Cost"), "Cost Textbox", "value"),
					String.valueOf(PizzaTypes.LARE_NOTOPPINGS.getCost()));

		} catch (Exception e) {
			ui.takeSnapShot("Issue_In_verifyPizzaOrderCostTest");
			Assert.fail(e.getMessage());
		} finally {
			console.info("###validating of pizza cost verification ends###");
		}
	}

}
