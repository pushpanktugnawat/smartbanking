/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: ProductServiceImpl.java
 */
package com.ing.hkthon.smartbanking.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.hkthon.smartbanking.model.Product;
import com.ing.hkthon.smartbanking.repository.IProductDao;
import com.ing.hkthon.smartbanking.service.IProductService;

/**
 * The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements IProductService{

	/** The product dao. */
	@Autowired
	private IProductDao productDao;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(ProductGroupServiceImpl.class);

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@Override
	public List<Product> getAllProducts()
	{
		logger.info("@method getAllProducts");
		return (List<Product>) productDao.findAll();

	}

	@Override
	public Product getProductById(int id) {
		logger.info("@method getAllProducts");
		Optional<Product> product=productDao.findById(id);
		if(product.isPresent())
			return product.get();
		else
			return null;
	}
}
