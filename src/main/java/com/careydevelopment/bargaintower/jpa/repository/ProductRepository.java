package com.careydevelopment.bargaintower.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.careydevelopment.bargaintower.jpa.entity.Category;
import com.careydevelopment.bargaintower.jpa.entity.Product;

public interface ProductRepository extends BaseRepository<Product,Long>{

	@Query("SELECT p FROM Product p")
    Page<Product> findProducts(Pageable page);
	
	List<Product> findTop3ByAdvertiserCategory(Category advertiserCategory);
}
