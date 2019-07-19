package com.practice.tavisca.beverageCompany;

public class MenuException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5400983803246195383L;
	private String message;

	public MenuException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
