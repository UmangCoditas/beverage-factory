package com.tavisca.main.beverage.company;

public final class BeverageFactoryUtil {

	private BeverageFactoryUtil() {
		throw new IllegalStateException("BeverageFactory class");
	}

	public static Beverage createBeverage() {
		return new BeverageImpl();
	}

}
