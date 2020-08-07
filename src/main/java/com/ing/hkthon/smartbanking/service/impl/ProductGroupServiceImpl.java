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
import org.springframework.stereotype.Service;

import com.ing.hkthon.smartbanking.model.ProductGroup;
import com.ing.hkthon.smartbanking.repository.IProductGroupDao;
import com.ing.hkthon.smartbanking.service.IProductGroupService;

@Service
public class ProductGroupServiceImpl implements IProductGroupService{

	
	@Autowired
	private IProductGroupDao iProductGroupDao;
	
	private Logger logger = LoggerFactory.getLogger(ProductGroupServiceImpl.class);

	
	/**
	 * Gets the all product group.
	 *
	 * @return the all product group
	 */
	@Override
	public List<ProductGroup> getAllProductGroup() 
	{
		logger.info("@method getAllProductGroup");

		return (List<ProductGroup>) iProductGroupDao.findAll();
	}

}
