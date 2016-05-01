package com.careydevelopment.bargaintower.util;

import com.careydevelopment.bargaintower.jpa.entity.Product;

public class DescriptionHelper {

	public static final String getDescription(Product product) {
		if (product.getDescription() != null && product.getDescription().length() > 2) {
			return product.getDescription();
		} else {
			return SiteConstants.DEFAULT_DESCRIPTION;
		}
	}
	
	
	public static final String getDescription(String category, String subcategory) {
		StringBuilder builder = new StringBuilder();
		builder.append(SiteConstants.DEFAULT_SHOP_PREFIX);
		
		if (subcategory != null && subcategory.length() > 2) {
			builder.append(subcategory);
		} else if (category != null && subcategory.length() > 2) {
			builder.append(category);
		} else {
			builder.append(SiteConstants.DEFAULT_SHOP_SUFFIX);
		}
		
		return builder.toString();
	}
}
