package com.careydevelopment.bargaintower.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "attribute")
public class Attribute extends AbstractEntity{
	
	@Column(name="name")
	private String name;
	
	//@OneToMany(mappedBy = "attribute", fetch = FetchType.EAGER)
	//private List<AttributeValue> attributeValues;
	
	public Attribute (String name) {
		this.name = name;
	}

	
	public Attribute() {
		
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


	/*public List<AttributeValue> getAttributeValues() {
		return attributeValues;
	}


	public void setAttributeValues(List<AttributeValue> attributeValues) {
		this.attributeValues = attributeValues;
	}*/
	
	
}
