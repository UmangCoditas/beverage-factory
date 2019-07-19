package com.practice.tavisca.beverageCompany;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BeverageTest {
	private static Beverage beverage;
	private final double delta = 0.001;

	@BeforeClass
	static void setUp() throws Exception {
		beverage = BeverageFactory.createBeverage();
	}

	@AfterClass
	static void tearDown() throws Exception {
		beverage = null;
	}

	@Test
	void testOrderBeverageAndGetPrice() {
		beverage = BeverageFactory.createBeverage();
		double actualBananaSmoothiePrice = beverage.orderBeverageAndGetPrice("BananaSmoothie,-banana,-milk");
		double expectedBananaSmoothiePrice = 4;
		assertEquals(expectedBananaSmoothiePrice, actualBananaSmoothiePrice, delta);

		double actualTeaPrice = beverage.orderBeverageAndGetPrice("Chai,-sugar,-milk");
		double expectedTeaPrice = 2.5;
		assertEquals(expectedTeaPrice, actualTeaPrice, delta);

		double regularTeaPrice = beverage.orderBeverageAndGetPrice("Chai");
		double expectedRegularTeaPrice = 4.0;
		assertEquals(expectedRegularTeaPrice, regularTeaPrice, delta);

		MenuException wrongIngredientException = Assertions.assertThrows(MenuException.class,
				() -> beverage.orderBeverageAndGetPrice("Chai,-sugar,-mint"));
		assertEquals("The ingredient to be removed does not belong to this menu.",
				wrongIngredientException.getMessage());

		MenuException wrongMenuException = Assertions.assertThrows(MenuException.class,
				() -> beverage.orderBeverageAndGetPrice("Coffee,-coffee,-milk,-sugar,-water"));
		assertEquals("All the ingredients cannot be removed", wrongMenuException.getMessage());

		MenuException invalidMenuException = Assertions.assertThrows(MenuException.class,
				() -> beverage.orderBeverageAndGetPrice(""));
		assertEquals("Invalid Menu entered", invalidMenuException.getMessage());

		MenuException unavailableMenuException = Assertions.assertThrows(MenuException.class,
				() -> beverage.orderBeverageAndGetPrice("Latte"));
		assertEquals("Invalid Menu entered", unavailableMenuException.getMessage());

	}

}
