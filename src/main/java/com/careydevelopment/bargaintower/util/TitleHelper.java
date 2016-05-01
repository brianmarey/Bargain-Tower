package com.careydevelopment.bargaintower.util;

import com.careydevelopment.bargaintower.jpa.entity.Product;

public class TitleHelper {

	public static final String getTitle(Product product) {
		StringBuilder builder = new StringBuilder();
		builder.append(SiteConstants.SITE_NAME);
		builder.append(SiteConstants.TITLE_SEPARATOR);
		builder.append(product.getName());
		
		return builder.toString();
	}
	
	
	public static final String getTitle(String root, String category, String subcategory) {
		StringBuilder builder = new StringBuilder();
		builder.append(SiteConstants.SITE_NAME);
		builder.append(SiteConstants.TITLE_SEPARATOR);
		
		if (subcategory != null && subcategory.length() > 2) {
			builder.append(subcategory);
		} else if (category != null && category.length() > 2) {
			builder.append(category);
		} else if (root != null && root.length() > 2) {
			builder.append(root);
		} else {
			builder.append(SiteConstants.DEFAULT_SUBTITLE);
		}
		
		return builder.toString();
	}
}
