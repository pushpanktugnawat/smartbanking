/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: ProductGroupRestImpl.java
 */
package com.ing.hkthon.smartbanking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hkthon.smartbanking.model.ProductGroup;
import com.ing.hkthon.smartbanking.service.IProductGroupService;

/**
 * The Class ProductGroupRestImpl.
 * @author pushpank
 */
@RestController
@RequestMapping("/api/productGroup")
public class ProductGroupRestImpl {

	private Logger logger = LoggerFactory.getLogger(ProductGroupRestImpl.class);
	
	@Autowired
	private IProductGroupService productGroupService;
	
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductGroup>> getAllProductGroups()
	{
		logger.info("@method getAllProductGroups ");
		
		 return productGroupService.getAllProductGroup();
		
	}
	
	
}
