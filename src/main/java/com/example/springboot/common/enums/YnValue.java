package com.example.springboot.common.enums;

public enum YnValue {
	Y("Y"),
	N("N");

	private String value;
	public String getValue() {
		return value;
	}

	/**
	 * Constructor
	 * @param value
	 */
	YnValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
