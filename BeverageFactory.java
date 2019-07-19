package com.practice.tavisca.beverageCompany;

public class BeverageFactory {
	public static Beverage createBeverage() {
		return new BeverageImpl();
	}

}
