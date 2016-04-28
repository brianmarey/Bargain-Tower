package com.careydevelopment.bargaintower.util;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import com.careydevelopment.bargaintower.jpa.entity.Product;

public class PaginationHelper {

    public static void setPageInfo(Page<Product> products, Model model, int pageNum) {
    	int totalPages = products.getTotalPages();
    	boolean hasNext = products.hasNext();
    	boolean hasPrevious = products.hasPrevious();
    	boolean isFirst = products.isFirst();
    	boolean isLast = products.isLast();
    	int firstPage = pageNum;
  
    	if (pageNum > 0) {
    		firstPage = pageNum - 1;
    	}
    	
    	if (totalPages - firstPage < 6) {
    		firstPage = totalPages - 5;
    	}
    	
    	if (hasNext) {
    		int nextPage = pageNum + 1;
    		model.addAttribute("nextPage",nextPage);
    	}
    	
    	if (hasPrevious) {
    		int previousPage = pageNum - 1;
    		model.addAttribute("previousPage",previousPage);
    	}
    	
    	model.addAttribute("totalPages",totalPages);
    	model.addAttribute("hasNext",hasNext);
    	model.addAttribute("hasPrevious",hasPrevious);
    	model.addAttribute("isFirst",isFirst);
    	model.addAttribute("isLast",isLast);
    	model.addAttribute("pageNum",pageNum);
    	model.addAttribute("firstPage",firstPage);
    }
}
