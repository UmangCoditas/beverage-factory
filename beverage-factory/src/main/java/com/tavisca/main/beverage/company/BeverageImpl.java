package com.tavisca.main.beverage.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeverageImpl implements Beverage {
	private String selectedMenu;
	private double beverageCost;

	@Override
	public double orderBeverageAndGetPrice(String order) {
		List<String> ingredientsList = new ArrayList<>(Arrays.asList(order.trim().split(",")));

		selectedMenu = getMenu(ingredientsList);

		beverageCost = Menu.valueOf(selectedMenu.toUpperCase()).getMenuPrice();

		ingredientsList.remove(selectedMenu);

		if (!ingredientsList.isEmpty()) {
			checkValidBeverageOrder(selectedMenu, ingredientsList);
			removeIngredients(ingredientsList);
		}
		return beverageCost;

	}

	private void removeIngredients(List<String> ingredientsList) {
		List<String> trimmedIngredientsList = ingredientsList.stream().filter(ingredient -> ingredient.startsWith("-"))
				.collect(Collectors.toList());

		trimmedIngredientsList.stream().forEach(ingredient -> checkValidIngredient(ingredient));
		trimmedIngredientsList.stream().forEach(ingredient -> calculateCost(ingredient));
	}

	private void calculateCost(String trimmedIngredient) {
		String enumIngredient = trimmedIngredient.replace("-", "");
		beverageCost = beverageCost - (Ingredient.valueOf(enumIngredient.toUpperCase()).getIngredientPrice());
	}

	private void checkValidBeverageOrder(String selectedMenu, List<String> orderedIngredientsList) {
		List<String> actualIngredientList = Menu.valueOf(selectedMenu.toUpperCase()).getIngredientList();
		if (orderedIngredientsList.equals(actualIngredientList)) {
			throw new MenuException("All the ingredients cannot be removed");
		} else if (!actualIngredientList.containsAll(orderedIngredientsList)) {
			throw new MenuException("The ingredient to be removed does not belong to this menu.");
		}
	}

	private boolean checkValidIngredient(String ingredient) {
		for (Ingredient enumIngredient : Ingredient.values()) {
			if (enumIngredient.getIngredientName().equalsIgnoreCase(ingredient)) {
				return true;
			}
		}
		return false;
	}

	private String getMenu(List<String> ingredientsList) {
		selectedMenu = ingredientsList.get(0);
		if (!isMenuAvailable(selectedMenu)) {
			throw new MenuException("Invalid Menu entered");
		}
		return selectedMenu;
	}

	private boolean isMenuAvailable(String menu) {
		for (Menu enumMenu : Menu.values()) {
			if (enumMenu.getMenuName().equalsIgnoreCase(menu)) {
				return true;
			}
		}
		return false;
	}
}
