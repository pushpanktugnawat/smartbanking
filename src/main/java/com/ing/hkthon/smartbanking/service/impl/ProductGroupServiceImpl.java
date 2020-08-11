/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: ProductGroupServiceImpl.java
 */
package com.ing.hkthon.smartbanking.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ing.hkthon.smartbanking.model.ProductGroup;
import com.ing.hkthon.smartbanking.repository.IProductGroupDao;
import com.ing.hkthon.smartbanking.service.IProductGroupService;

/**
 * The Class ProductGroupServiceImpl.
 */
@Service
public class ProductGroupServiceImpl implements IProductGroupService{

	
	/** The i product group dao. */
	@Autowired
	private IProductGroupDao iProductGroupDao;
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(ProductGroupServiceImpl.class);

	
	/**
	 * Gets the all product group.
	 *
	 * @return the all product group
	 */
	@Override
	public ResponseEntity<List<ProductGroup>> getAllProductGroup() 
	{
		logger.info("@method getAllProductGroup");

		List<ProductGroup> productGroups= (List<ProductGroup>) iProductGroupDao.findAll();
		 
		 if(!CollectionUtils.isEmpty(productGroups))
		 {
			 logger.debug("@method getAllProductGroup with size "+productGroups.size());
			 
			 return ResponseEntity.ok(productGroups);
		 }else 
		 {
			 logger.debug("@method getAllProductGroup with no content");
			 return ResponseEntity.noContent().build();
		 }
	}

}
