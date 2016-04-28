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
@Table(name = "category")
public class Category extends AbstractEntity{
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<Category> children;

	@JoinColumn(name = "parent_id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Category parent;

	public Category (String name) {
		this.name = name;
	}

	public Category (String name, Category parent) {
		this.name = name;
		this.parent = parent;
	}
	
	public Category() {
		
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
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
}
