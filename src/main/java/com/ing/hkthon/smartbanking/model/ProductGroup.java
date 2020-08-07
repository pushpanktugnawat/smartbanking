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

/**
 * The Class ProductGroup.
 * @author Pushpank
 */
@Entity
@Table(name="product_group")
public class ProductGroup {
	
	/** The product group id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_group_id")
	private int productGroupId;
	
	/** The name. */
	private String name;

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

	@Override
	public String toString() {
		return "ProductGroup [productGroupId=" + productGroupId + ", name=" + name + "]";
	}

	public ProductGroup(int productGroupId, String name) {
		super();
		this.productGroupId = productGroupId;
		this.name = name;
	}
	
	
	
	
	

}
