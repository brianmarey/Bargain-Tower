package com.careydevelopment.bargaintower.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.careydevelopment.bargaintower.jpa.entity.Product;
import com.careydevelopment.bargaintower.jpa.repository.ProductRepository;
import com.careydevelopment.bargaintower.util.CategoryHelper;
import com.careydevelopment.bargaintower.util.PaginationHelper;

@Controller
@RequestMapping("/shop")
public class ShopController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);
	
	private static final int RESULTS_PER_PAGE = 12;
	
	@Autowired
	ProductRepository productRepository;
	
    @RequestMapping("/{root}/{category}/{subcategory}")
    public String shop(@PathVariable("root") String root, @PathVariable("category") String category,
    	@PathVariable("subcategory") String subcategory, 
    	@RequestParam(value="pageNum", required=false) String pageNum, Model model) {    	    
    	
    	model.addAttribute("shopActive", "active");
    	
    	LOGGER.info("root is" + CategoryHelper.getReadableName(root));
    	LOGGER.info("category is " + CategoryHelper.getReadableName(category));
    	LOGGER.info("subcat is " + CategoryHelper.getReadableName(subcategory));

    	model.addAttribute("root", CategoryHelper.getReadableName(root));
    	model.addAttribute("category",CategoryHelper.getReadableName(category));
    	model.addAttribute("subcategory",CategoryHelper.getReadableName(subcategory));

    	model.addAttribute("rootValue", root);
    	model.addAttribute("categoryValue",category);
    	model.addAttribute("subcategoryValue",subcategory);

    	int page = getPage(pageNum);
    	
    	Pageable pageable = new PageRequest(page,RESULTS_PER_PAGE);
    	Page<Product> products = productRepository.findProducts(pageable);
    	
    	PaginationHelper.setPageInfo(products, model, page);
    	
    	List<Product> list = new ArrayList<Product>();
    	for (Product p : products) {
    		list.add(p);
    	}
    	
    	model.addAttribute("list",list);
    	
    	return "shop";
    }    
    
    
    private int getPage(String pageNum) {
    	int page = 0;
    	
    	if (pageNum != null) {
    		try {
    			page = new Integer(pageNum);
    		} catch (NumberFormatException ne) {
    			LOGGER.warn("Page number isn't a number! " +pageNum);
    		}
    	}
    	
    	return page;
    }
}
