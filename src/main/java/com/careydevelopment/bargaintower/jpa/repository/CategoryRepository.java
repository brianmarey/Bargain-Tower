package com.careydevelopment.bargaintower.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careydevelopment.bargaintower.jpa.entity.Category;

public interface CategoryRepository extends BaseRepository<Category,Long>{
	
	@Query("SELECT c FROM Category c where c.slug = :slug") 
    Category findCategoryBySlug(@Param("slug") String slug);
	
}
