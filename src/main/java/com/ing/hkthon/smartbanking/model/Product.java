/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: Product.java
 */
package com.ing.hkthon.smartbanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Product.
 * @author pushpank
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="products")
public class Product {
	
	/** The product id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private int productId;
	
	/** The name. */
	private String name;
	
	/** The min balance. */
	private float minBalance;
	
	/** The duration. */
	private int duration;

	/** The product group. 
	 * As each Product belongs to a Product Group
	 * */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_group_id")
	private ProductGroup productGroup;
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(float minBalance) {
		this.minBalance = minBalance;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public ProductGroup getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(ProductGroup productGroup) {
		this.productGroup = productGroup;
	}

	

	public Product(int productId, String name, float minBalance, int duration, ProductGroup productGroup) {
		super();
		this.productId = productId;
		this.name = name;
		this.minBalance = minBalance;
		this.duration = duration;
		this.productGroup = productGroup;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
}
