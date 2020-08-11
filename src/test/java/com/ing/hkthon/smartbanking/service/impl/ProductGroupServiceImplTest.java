/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: ProductGroupServiceImplTest.java
 */
package com.ing.hkthon.smartbanking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.ing.hkthon.smartbanking.model.ProductGroup;
import com.ing.hkthon.smartbanking.repository.IProductGroupDao;

@ExtendWith(MockitoExtension.class)
public class ProductGroupServiceImplTest {

	@Mock
	private IProductGroupDao productGroupDao;

	@InjectMocks
	private ProductGroupServiceImpl productGroupServiceImpl;


	private List<ProductGroup> productGroups; 
	
	@BeforeEach                           
	void setUp() {                               

		this.productGroups = new ArrayList<>();    
		this.productGroups.add(new ProductGroup(1, "Saving"));
		this.productGroups.add(new ProductGroup(2, "Betalen"));
		this.productGroups.add(new ProductGroup(3, "Hypotheek"));
	}

	/**
	 * Test find all staff members success.
	 */
	@Test
	public void testFindAllProductGroupSuccess() {

		Mockito.when(productGroupDao.findAll()).thenReturn(this.productGroups);

		ResponseEntity<List<ProductGroup>> expected = productGroupServiceImpl.getAllProductGroup();

		Assertions.assertEquals(expected, ResponseEntity.ok(this.productGroups));
	}
	
	/**
	 * Test find all staff members failure.
	 */
	@Test
	public void testFindAllProductGroupFailure() {

		Mockito.when(productGroupDao.findAll()).thenReturn(this.productGroups);

		ResponseEntity<List<ProductGroup>> expected = productGroupServiceImpl.getAllProductGroup();

		Assertions.assertNotSame(expected, ResponseEntity.noContent().build());
	}
	
	/**
	 * Test find all product group no content found.
	 */
	@Test
	public void testFindAllProductGroupNoContentFound() {

		Mockito.when(productGroupDao.findAll()).thenReturn(null);

		ResponseEntity<List<ProductGroup>> expected = productGroupServiceImpl.getAllProductGroup();

		Assertions.assertEquals(expected, ResponseEntity.noContent().build());
	}

}
