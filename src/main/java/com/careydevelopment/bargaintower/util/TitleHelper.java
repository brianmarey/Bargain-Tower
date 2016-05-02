package com.careydevelopment.bargaintower.util;

import com.careydevelopment.bargaintower.jpa.entity.Category;
import com.careydevelopment.bargaintower.jpa.entity.Product;

public class TitleHelper {

	public static final String getTitle(Product product) {
		StringBuilder builder = new StringBuilder();
		builder.append(SiteConstants.SITE_NAME);
		builder.append(SiteConstants.TITLE_SEPARATOR);
		builder.append(product.getName());
		
		return builder.toString();
	}
	
	
	public static final String getTitle(Category category) {
		StringBuilder builder = new StringBuilder();
		builder.append(SiteConstants.SITE_NAME);
		builder.append(SiteConstants.TITLE_SEPARATOR);
		
		if (category != null) {
			builder.append(category.getName());
		} else {
			builder.append(SiteConstants.DEFAULT_SUBTITLE);
		}
		
		return builder.toString();
	}
}
