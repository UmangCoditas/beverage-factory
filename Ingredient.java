package com.practice.tavisca.beverageCompany;

public enum Ingredient {

	MILK("-milk", 1), SUGAR("-sugar", .5), SODA("-soda", .5), MINT("-mint", .5), BANANA("-banana", 1), TEA("-tea", 1);

	private final String ingredientName;
	private final double ingredientPrice;

	private Ingredient(String ingredientName, double ingredientPrice) {
		this.ingredientName = ingredientName;
		this.ingredientPrice = ingredientPrice;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public double getIngredientPrice() {
		return ingredientPrice;
	}

}
