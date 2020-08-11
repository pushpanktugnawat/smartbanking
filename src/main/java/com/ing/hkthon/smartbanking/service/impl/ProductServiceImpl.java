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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
	public ResponseEntity<List<Product>> getAllProductsByProductGroupId(int productGroup)
	{
		logger.info("@method getAllProductsByProductGroupId @param productGroup "+ productGroup);
		
		List<Product> products= productDao.findByProductGroup_ProductGroupId(productGroup);
		
		if(!CollectionUtils.isEmpty(products))
		 {
			 logger.debug("@method getAllProductsByProductGroupId with size "+products.size());
			 
			 return ResponseEntity.ok(products);
		 }else 
		 {
			 logger.debug("@method getAllProductsByProductGroupId with no content");
			 return ResponseEntity.noContent().build();
		 }
	}

	/* (non-Javadoc)
	 * @see com.ing.hkthon.smartbanking.service.IProductService#findProductByProductId(int)
	 */
	@Override
	public ResponseEntity<Product> findProductByProductId(int productId) 
	{
		logger.info("@method findProductByProductId @param productId"+productId);
		
		Optional<Product> product=productDao.findById(productId);
		
		if(product.isPresent())
		{
			logger.info("@method findProductByProductId @success Product found");
			return ResponseEntity.ok().body(product.get());
		}
		else{
			logger.info("@method findProductByProductId @faiure NO product Found");
			return ResponseEntity.noContent().build();
		}
	}
}
