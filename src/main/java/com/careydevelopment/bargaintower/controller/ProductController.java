package com.careydevelopment.bargaintower.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.careydevelopment.bargaintower.exception.ProductNotFoundException;
import com.careydevelopment.bargaintower.jpa.entity.Product;
import com.careydevelopment.bargaintower.jpa.repository.ProductRepository;
import com.careydevelopment.bargaintower.util.DescriptionHelper;
import com.careydevelopment.bargaintower.util.SlugParser;
import com.careydevelopment.bargaintower.util.TitleHelper;

@Controller
@RequestMapping("/product")
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);


	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping("/{productId}")
    public String shop(@PathVariable("productId") String productId, Model model) throws ProductNotFoundException {    	    
    	
    	//model.addAttribute("shopActive", "active");
    	
		Product product = fetchProduct(productId); 
		
		LOGGER.info("Product is " + product.getName());
		
		/*for (String s : product.getSizes()) {
			LOGGER.info("Size is " + s);
		}*/
		
    	model.addAttribute("product",product);
    	model.addAttribute("title", TitleHelper.getTitle(product));
    	model.addAttribute("description", DescriptionHelper.getDescription(product));
    	
    	return "product";
    }    
	
	
	private Product fetchProduct(String productId) throws ProductNotFoundException {
		Long id = SlugParser.getIdFromSlug(productId);
		
		if (id != null) {
			Product product = productRepository.findOne(id);
			return product;
		} else {
			throw new ProductNotFoundException("Can't find product " + productId);
		}
	}
}
