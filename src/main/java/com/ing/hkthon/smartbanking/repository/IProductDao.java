/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: IProductDao.java
 */
package com.ing.hkthon.smartbanking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ing.hkthon.smartbanking.model.Product;

/**
 * The Interface IProductDao.
 */
public interface IProductDao extends CrudRepository<Product, Integer> {
 
	List<Product> findByProductGroup_ProductGroupId(int productGroup);
}