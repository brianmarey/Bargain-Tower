package com.careydevelopment.bargaintower.util;

import com.careydevelopment.bargaintower.jpa.entity.Category;
import com.careydevelopment.bargaintower.jpa.entity.Product;

public class DescriptionHelper {

	public static final String getDescription(Product product) {
		if (product.getDescription() != null && product.getDescription().length() > 2) {
			return product.getDescription();
		} else {
			return SiteConstants.DEFAULT_DESCRIPTION;
		}
	}
	
	
	public static final String getDescription(Category category) {
		StringBuilder builder = new StringBuilder();
		builder.append(SiteConstants.DEFAULT_SHOP_PREFIX);
		
		if (category.hasGrandparent() || category.hasParent()) {
			builder.append(category.getName());
		} else {
			builder.append(SiteConstants.DEFAULT_SHOP_SUFFIX);
		}
		
		return builder.toString();
	}
}
