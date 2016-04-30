package com.careydevelopment.bargaintower.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlugParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(SlugParser.class);
	
	public static final Long getIdFromSlug(String productId) {
		Long id = null;
		
		if (productId.indexOf("-") > -1) {
			String idS = productId.substring(0,productId.indexOf("-"));
			
			try {
				id = new Long(idS);
			} catch (NumberFormatException ne) {
				LOGGER.error("Couldn't transalte " + productId + " into an ID!");
			}
		}
		
		return id;
	}
}
