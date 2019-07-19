package com.tavisca.main.beverage.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Menu {
	COFFEE("Coffee", "-coffee,-milk,-sugar,-water", 5), CHAI("Chai", "-tea,-milk,-sugar,-water", 4),
	BANANASMOOTHIE("BananaSmoothie", "-banana,-milk,-sugar,-water", 6),
	STRAWBERRYSHAKE("StrawberryShake", "-strawberries,-sugar,-milk,-water", 7);

	private final String menuName;
	private final String ingredients;
	private final double menuPrice;

	private Menu(String menuName, String ingredients, double menuPrice) {
		this.menuName = menuName;
		this.ingredients = ingredients;
		this.menuPrice = menuPrice;
	}

	public String getMenuName() {
		return menuName;
	}

	public List<String> getIngredientList() {
		return new ArrayList<>(Arrays.asList(ingredients.split(",")));
	}

	public double getMenuPrice() {
		return menuPrice;
	}

}
