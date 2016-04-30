package com.careydevelopment.bargaintower.util;

public class SlugMaker {

	public static final String makeSlug(String s) {
		s = s.toLowerCase();
		s = s.replaceAll("\\p{P}", "");
		s = s.replace(" ", "-");
		return s;
	}
	
	
	public static void main(String[] args) {
		String s = "Men's, Polo Shirts!";
		System.err.println(makeSlug(s));
	}
}
