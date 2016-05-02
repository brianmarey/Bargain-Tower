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

import com.careydevelopment.bargaintower.jpa.entity.Category;
import com.careydevelopment.bargaintower.jpa.entity.Product;
import com.careydevelopment.bargaintower.jpa.repository.CategoryRepository;
import com.careydevelopment.bargaintower.jpa.repository.ProductRepository;
import com.careydevelopment.bargaintower.util.DescriptionHelper;
import com.careydevelopment.bargaintower.util.PaginationHelper;
import com.careydevelopment.bargaintower.util.TitleHelper;

@Controller
@RequestMapping("/shop")
public class ShopController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);
	
	private static final int RESULTS_PER_PAGE = 12;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
    @RequestMapping("/{root}/{category}/{subcategory}")
    public String shop(@PathVariable("root") String root, @PathVariable("category") String category,
    	@PathVariable("subcategory") String subcategory, 
    	@RequestParam(value="pageNum", required=false) String pageNum, Model model) {   
    	
    	Category cat = getCategory(subcategory);
    	setModel(cat,pageNum,model);
    	    	
    	return "shop";
    }    
    

    @RequestMapping("/{root}/{category}")
    public String shop(@PathVariable("root") String root, @PathVariable("category") String category,
    	@RequestParam(value="pageNum", required=false) String pageNum, Model model) {   
    	
    	Category cat = getCategory(category);
    	setModel(cat,pageNum,model);
    	    	
    	return "shop";
    } 

    
    @RequestMapping("/{root}")
    public String shop(@PathVariable("root") String root,
    	@RequestParam(value="pageNum", required=false) String pageNum, Model model) {   
    	
    	Category cat = getCategory(root);
    	setModel(cat,pageNum,model);
    	    	
    	return "shop";
    } 
    
    
    private Category getCategory(String slug) {
    	Category cat = categoryRepository.findCategoryBySlug(slug);
    	return cat;
    }
    
    
    private void setModel(Category cat, String pageNum, Model model) {    	
    	setDiplayAttributes(model,cat);
    	fetchAndDisplayProducts(pageNum,cat,model);
    }
    
    
    private void fetchAndDisplayProducts(String pageNum, Category category, Model model) {
    	int page = getPage(pageNum);
    	
    	Pageable pageable = new PageRequest(page,RESULTS_PER_PAGE);
    	Page<Product> products = productRepository.findProductsByCategory(pageable,category);
    	
    	PaginationHelper.setPageInfo(products, model, page);
    	
    	List<Product> list = new ArrayList<Product>();
    	for (Product p : products) {
    		list.add(p);
    	}
    	
    	model.addAttribute("list",list);	
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
    
    
    private Category getSubcategory(Category cat) {
    	if (cat.hasGrandparent()) return cat;
    	else return null;
    }
    
    
    private Category getCategory(Category cat) {
    	if (cat.hasGrandparent()) return cat.getParent();
    	else if (cat.hasParent()) return cat;
    	else return null;
    }
    
    
    private Category getRoot(Category cat) {
    	if (cat.hasGrandparent()) return cat.getGrandparent();
    	else if (cat.hasParent()) return cat.getParent();
    	else return cat;
    }
    
    
    private void setDiplayAttributes(Model model, Category cat) {
    	model.addAttribute("shopActive", "active");
    	
    	Category subcategory = getSubcategory(cat);
    	Category category = getCategory(cat);
    	Category root = getRoot(cat);
    	
    	LOGGER.info("root is" + root);
    	LOGGER.info("category is " + category);
    	LOGGER.info("subcat is " + subcategory);

    	model.addAttribute("root", root.getName());
    	if (category != null) model.addAttribute("category",category.getName());
    	if (subcategory != null) model.addAttribute("subcategory",subcategory.getName());

    	model.addAttribute("rootValue", root.getSlug());
    	if (category != null) model.addAttribute("categoryValue",category.getSlug());
    	if (subcategory != null) model.addAttribute("subcategoryValue",subcategory.getSlug());
    	
    	model.addAttribute("title", TitleHelper.getTitle(cat));
    	model.addAttribute("description", DescriptionHelper.getDescription(cat));
    }
}
