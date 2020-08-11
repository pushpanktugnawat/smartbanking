/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: IProductGroupService.java
 */
package com.ing.hkthon.smartbanking.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ing.hkthon.smartbanking.model.ProductGroup;

/**
 * The Interface IProductGroupService.
 */
public interface IProductGroupService {

	/**
	 * Gets the all product group.
	 *
	 * @return the all product group
	 */
	ResponseEntity<List<ProductGroup>> getAllProductGroup();

}
