package com.careydevelopment.bargaintower.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.careydevelopment.bargaintower.jpa.repository.ProductRepository;

@Controller
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);


	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping("/product")
    public String shop(@RequestParam(value="id", required=false) String id, Model model) {    	    
    	
    	//model.addAttribute("shopActive", "active");
    	
    	
    	//model.addAttribute("list",list);
    	
    	return "product";
    }    
}
