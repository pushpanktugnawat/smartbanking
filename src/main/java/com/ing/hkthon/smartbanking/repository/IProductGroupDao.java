/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: IProductGroupDao.java
 */
package com.ing.hkthon.smartbanking.repository;

import org.springframework.data.repository.CrudRepository;

import com.ing.hkthon.smartbanking.model.ProductGroup;

/**
 * The Interface IProductGroupDao.
 * @author Pushpank 
 */
public interface IProductGroupDao extends CrudRepository<ProductGroup, Integer>{

}
