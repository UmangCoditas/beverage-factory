package com.tavisca.test.beverageCompany;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.tavisca.main.beverage.company.Beverage;
import com.tavisca.main.beverage.company.BeverageFactoryUtil;
import com.tavisca.main.beverage.company.MenuException;

class BeverageTest {
	private static Beverage beverage;
	private final double delta = 0.001;

	@BeforeAll
	static void setUp() throws Exception {
		beverage = BeverageFactoryUtil.createBeverage();
	}

	@AfterAll
	static void tearDown() throws Exception {
		beverage = null;
	}

	@Test
	void testOrderBeverageAndGetPrice() {
		double actualBananaSmoothiePrice = beverage.orderBeverageAndGetPrice("BananaSmoothie,-banana,-milk");
		final double expectedBananaSmoothiePrice = 4;
		assertEquals(expectedBananaSmoothiePrice, actualBananaSmoothiePrice, delta);

		double actualTeaPrice = beverage.orderBeverageAndGetPrice("Chai,-sugar,-milk");
		final double expectedTeaPrice = 2.5;
		assertEquals(expectedTeaPrice, actualTeaPrice, delta);

		double regularTeaPrice = beverage.orderBeverageAndGetPrice("Chai");
		final double expectedRegularTeaPrice = 4.0;
		assertEquals(expectedRegularTeaPrice, regularTeaPrice, delta);

		MenuException wrongIngredientException = Assertions.assertThrows(MenuException.class,
				() -> beverage.orderBeverageAndGetPrice("Chai,-sugar,-mint"));
		assertTrue(wrongIngredientException.getMessage().contains("The ingredient to be removed does not belong to this menu."));

		MenuException wrongMenuException = Assertions.assertThrows(MenuException.class,
				() -> beverage.orderBeverageAndGetPrice("Coffee,-coffee,-milk,-sugar,-water"));
		assertTrue(wrongMenuException.getMessage().contains("All the ingredients cannot be removed"));

		MenuException invalidMenuException = Assertions.assertThrows(MenuException.class,
				() -> beverage.orderBeverageAndGetPrice(""));
		assertTrue(invalidMenuException.getMessage().contains("Invalid Menu entered"));

		MenuException unavailableMenuException = Assertions.assertThrows(MenuException.class,
				() -> beverage.orderBeverageAndGetPrice("Latte"));
		assertTrue(unavailableMenuException.getMessage().contains("Invalid Menu entered"));

	}

}
