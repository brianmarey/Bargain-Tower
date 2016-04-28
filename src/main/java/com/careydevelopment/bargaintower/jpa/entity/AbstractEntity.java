package com.careydevelopment.bargaintower.jpa.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractEntity {

	 
	    public static final String FIND_ALL = "Entity.findAll";
	 
	    public static final String TOTAL_RESULT = "Entity.totalResult";
	
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    protected Long id;
	 
	    // Getters and Setters
}
