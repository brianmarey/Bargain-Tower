package com.careydevelopment.bargaintower.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careydevelopment.bargaintower.jpa.entity.Category;
import com.careydevelopment.bargaintower.jpa.entity.Product;

public interface ProductRepository extends BaseRepository<Product,Long>{

	@Query("SELECT p FROM Product p")
    Page<Product> findProducts(Pageable page);
	
	@Query("SELECT p FROM Product p where p.advertiserCategory = :category or p.advertiserCategory.parent = :category or p.advertiserCategory.parent.parent = :category")
    Page<Product> findProductsByCategory(Pageable page, @Param("category") Category category);
	
	List<Product> findTop3ByAdvertiserCategory(Category advertiserCategory);
}
