/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: ProductGroup.java
 */
package com.ing.hkthon.smartbanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class ProductGroup.
 * @author Pushpank
 */
@Entity
@Table(name="product_group")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductGroup {
	
	/** The product group id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_group_id")
	private int productGroupId;
	
	/** The name. */
	private String name;
	
	
	/** The product count.
	 * this column indicates the Product Count for each Product Group
	 *  */
	
	@Column(name="product_count")
	private int productCount;

	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	@Override
	public String toString() {
		return "ProductGroup [productGroupId=" + productGroupId + ", name=" + name + "]";
	}

	public ProductGroup(int productGroupId, String name) {
		super();
		this.productGroupId = productGroupId;
		this.name = name;
	}

	public ProductGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
}
