package com.careydevelopment.bargaintower.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "attribute_value")
public class AttributeValue extends AbstractEntity{
	
	@Column(name="name")
	private String name;
	
	@JoinColumn(name = "attribute_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Attribute attribute;
	
	public AttributeValue (String name) {
		this.name = name;
	}

	
	public AttributeValue() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Attribute getAttribute() {
		return attribute;
	}


	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
}
