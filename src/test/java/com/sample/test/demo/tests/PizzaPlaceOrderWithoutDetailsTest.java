package com.sample.test.demo.tests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.reusables.TestBase;

public class PizzaPlaceOrderWithoutDetailsTest extends TestBase {
	private Logger console = Logger.getLogger(PizzaPlaceOrderWithoutDetailsTest.class);

	@Test(description = "verify whether user is getting proper error popup on without selecting name & email")
	public void verifyErrorMsgOnInvalidDetails() throws Exception {
		console.info("###validating of error message on without providing details for pickup informations begins###");
		try {
			ui.selectDropdownByIndex(obh.locator("pizza1"), "Pizza1", PizzaTypes.LARE_NOTOPPINGS.ordinal() + 1);
			ui.selectDropdownByValue(obh.locator("pizza1Toppings1"), "Topping1", PizzaToppings.MANGOS.getDisplayName());
			ui.selectDropdownByValue(obh.locator("pizza1Toppings2"), "Topping2",
					PizzaToppings.EXTRACHEESE.getDisplayName());
			ui.click(obh.locator("placeOrderButton"), "Place Order Button");

			assertEquals(ui.element(obh.locator("dialog")).isDisplayed(), true,
					"Place order modal is not being displayed");

			assertEquals(ui.getText(obh.locator("dialogText"), "Dialog Text").replaceAll("\n", " "), "Missing name Missing phone number");

		} catch (Exception e) {
			ui.takeSnapShot("Issue_In_error_msg_verification");
			Assert.fail(e.getMessage());
		} finally {
			console.info("###validating of error message on without providing details for pickup informations ends###");
		}
	}

}
