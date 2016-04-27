package com.careydevelopment.bargaintower.util;

public class CategoryHelper {

	public static final String getReadableName(String cat) {
		String category = null;
		
		switch (cat) {
		case "men":
			category = "Men";
			break;
		case "mens-shirts":
			category = "Men's Shirts";
			break;
		case "mens-polo-shirts":
			category = "Men's Polo Shirts";
			break;
		}
		
		return category;
	}
}
