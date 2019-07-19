package com.tavisca.main.beverage.company;

public class MenuException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5400983803246195383L;
	private final String message;

	public MenuException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
