/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: IProductService.java
 */
package com.ing.hkthon.smartbanking.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ing.hkthon.smartbanking.model.Product;

/**
 * The Interface IProductService.
 *
 * @author pintu
 */
public interface IProductService {

	/**
	 * Gets the all products by product group id.
	 *
	 * @param productGroup the product group
	 * @return the all products by product group id
	 */
	ResponseEntity<List<Product>> getAllProductsByProductGroupId(int productGroup);
	
	/**
	 * Find product by product id.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	ResponseEntity<Product> findProductByProductId(int id);

}
